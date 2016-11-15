#include <SPI.h> //library SPI pour la communication hardware
#include <Ethernet.h> //Librarie ethernet
byte mac[] = { //Adresse MAC del'ethernet shield 
0xDE,0xAD,0xBE,0xEF,0xFE,0xED};
int x=0;
String temp="";
char server[]="www.domoarduino.net"; //Adresse IP du serveur distant(ici mon serveur web local)
EthernetClient client; //Creation d'un objet EthernetClient
// pin mapping
//setup
void setup(){
  pinMode(2,OUTPUT);//met la broche en sortie
  pinMode(3,OUTPUT);//met la broche en sortie
  Serial.begin (9600);  //Initialisation  du port serie
  if(!Ethernet.begin(mac)){ //obtention d'une adresse IP par DHCP
  Serial.println(F("Erreur DHCP"));
  for(;;);
  }
  Serial.println(F("DHCP OK"));
}

//loop()
Void loop() {
  String str; // string contenant une ligne de la reponse http
  char c;  // char temporaire
  // Supervision de la temperature dans le batiment 
  x = analogRead(0);
  x=x*0.48;
  Serial.println(x);
  temp="GET /arduino.php?id=1&tmp="+(String (x))+" HTTP/1.0";
  if (client.connect(server,80)) {  ///connection au serveur web
  client.println(temp); //demande de ARDUINO.PHP  en HTTP 1.0
  client.println(F("Host: www.domoarduino.net"));
  client.println(F("Accept: */*"));//*/
  //A cause d'un bug de l'ide Ardino tout /* d'où Avoir son */ associé même dans une chaine de char
  client.println();
  client.println();
  } else { 
    Serial.println(F("Erreur TCP")); // si erreur lors de la connexion 
    return; //Qitte loop()
  }
  for(;;){//boucle infini
  
  if(client.available()) { //si des données sont disponibles sr l'ojet ethernetclient
  
  
  c = client.read(); lecture d'un octet
  Serial.print(c);
  if(c == '\n') { // Si fin de ligne atteinte
  //pensez à mettre une ligne vide à la fin de flux.xml)
  if(str.startsWith("<action>")){//si la ligne commance par <action>
  Serial.println(str);
  str.replace("<action>","");
  str.replace("</action>",""); Enléve les balises XML
  Serial.println(Str).
  if(str=="1") // Si le flux contient "1" on allume la led
  {digitalWrite(2,HIGH); //allume la led 
  //attend une seconde
  }
  else // si le flux contient 2 en alluma led 
  {Serial.println("222");
  digitalWrite(2,LOW); //eteint la led
  //attend une seconde
  }
  //si le flux contient autre chose il y a un probleme ,on fait  rien ....
  ///sort de la boucle infini
  }
  
  
  
