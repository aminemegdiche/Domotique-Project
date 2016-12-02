/*
  WEB CLIUENT
 
 */

#include <SPI.h>
#include <SD.h>
#include <Ethernet.h>
#include <Wire.h> 
#include <LiquidCrystal_I2C.h>


LiquidCrystal_I2C lcd(0x27,20,4); // définir l'adresse LCD à 0x27 pour un affichage 16 caractères et 2 lignes
// Entrez une adresse MAC de votre contrôleur ci-dessous.
// Les nouveaux shields  Ethernet ont une adresse MAC imprimée sur un autocollant sur le shilde
byte mac[] = { 0xDE, 0xAD, 0xBE, 0xEF, 0xFE, 0xED };
//  IP serur:
IPAddress server(192,168,1,22);  // numeric IP for Google (no DNS)
//char server[] = "www.google.com";    // name address for Google (using DNS)
  String str="";
// adress statique de la cate
IPAddress ip(192,168,1,177);


String date;
// pin=-1 mahiyech moujouda
int epin=-1;
int evalue=-1;
//declaration
EthernetClient client;
const int chipSelect = 4;   
   
   
   
   
void setup() {
 // initialisation les valeurs
  Serial.begin(9600);
   lcd.init();        // initialize the lcd 
  // afficher le message dans LCD.
  lcd.backlight();
  
 
   while (!Serial) {
    ; //pour fixer le shiled est connecté
  }
 
  Serial.println("card initialized.");
  if (Ethernet.begin(mac) == 0) {
    Serial.println("Failed to configure Ethernet using DHCP");
     lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("Failed to configure Ethernet using DHCP");
    
// si l'dress mac mamchetich na3mlou mac+ip
    Ethernet.begin(mac, ip);
  }
  
   if (!SD.begin(chipSelect)) {
    Serial.println("Card failed, or not present");
     lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("Card SD failed, or not present");
    // don't do anything more:  // mata3mil 7atta chay e5ir
    return;
  }
  Serial.println("card initialized.");
   lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("card SD initialized.");
    
   
}

void loop()
{
  Serial.println("initialization done");
   //  delay pour la shilde pour initialisée
  delay(+1000);
  lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("Connecting...");
  Serial.println("connecting...");
 


  // si connectè, retern via serial:
  if (client.connect(server, 80)) {
    Serial.println("connected");
     lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("Connected To Network");
    // Make a HTTP request:
    client.println("GET /Domotique/arduino.php?id_chmbre=1&temp=22&humi=23 HTTP/1.1");
    client.println("Host: 192.168.1.22");
    client.println("Connection: close");
    client.println();
  } 
  
  
  
  
  
  
  

//String str2=str.substring(index,ic);

  
  // if there are incoming bytes available 
  // from the server, read them and print them:
  while (client.available()) {
    char c = client.read();
    Serial.print(c);
     str=str+c;
  //    Serial.println(str);
  if(c == '\n') { 
         str="";
  }
     if(str.startsWith("Date")&&str.endsWith("GMT")) { // Si la ligne commence par <action>
         date=str; 
         Serial.println(date);
              str="";
 
     }
  
     if(str.startsWith("<equip>")&&str.endsWith("</equip>")) { // Si la ligne commence par <action>
          str.replace("<equip>", "");   
           str.replace(" ", "");
          str.replace("</equip>", "");
         evalue=str.toInt(); 
         Serial.println(evalue);
              str="";
 
     }
    if(str.startsWith("<pin>")&&str.endsWith("</pin>")) { // Si la ligne commence par <action>
          Serial.println(str);
          str.replace("<pin>", "");   
           str.replace(" ", "");
          str.replace("</pin>", ""); 
          epin=str.toInt();
          Serial.println(epin);
               str="";
 
     }
      
     if(epin!=-1 && evalue!=-1)
     {
        lcd.clear();
       lcd.setCursor(0,0);
       lcd.print("Valeur ="+String(evalue));
      lcd.setCursor(0,1);
       lcd.print("Equipement  ="+String(epin));
         pinMode(epin,OUTPUT); 
       if(evalue==0)
     {
      digitalWrite(epin, LOW);
     }
     else
     {
       digitalWrite(epin, HIGH);
     }
          
  
  
   File dataFile = SD.open("datalog.txt", FILE_WRITE);

       // if the file is available, write to it:
  if (dataFile) {
     Serial.println("LOG BEGIN");
       dataFile.println("---------------------------------------------------------");
     dataFile.println(date);
    dataFile.println("L'équipement reliée au pin "+String(epin)+" est "+String(evalue) );
     dataFile.println("---------------------------------------------------------");
    dataFile.close();
    // print to the serial port too:
    Serial.println("LOG END");
  }
  // if the file isn't open, pop up an error:
  else {
    Serial.println("error opening datalog.txt");
  }
  
  
  
  
     evalue=-1;
     epin=-1;
     delay(3000);
     
     }
 
  }
  
  
  

  // if the server's disconnected, stop the client:
  if (!client.connected()) {
    Serial.println("");
    Serial.println("disconnecting.");
    client.stop();

    // do nothing forevermore:

  }
}
