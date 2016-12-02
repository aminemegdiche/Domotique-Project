Domotique
=============================

Cette application prend l'initiative dans le domaine de la domotique et propose une solution plus efficace, simple à utiliser et moins coûteuse que celles commercialisées actuellement.
Cette dernière offre la passibilité à son utilisateur d’administrer et de gérer n’importe quelle surface
de son choix (son domicile, son usine ou même un ensemble de bâtiments). Ce contrôle peut être
effectué soit à distance (à travers un terminal mobile) ou localement. Donc notre solution permet de
gérer un bâtiment à distance quel que soit l'emplacement de l’utilisateur.
En résumé, le projet offre à l’utilisateur un bouquet de fonctions très utiles tel que :
- Surveiller son établissement à distance quel que soit son emplacement tant qu’il dispose
d’une connexion internet.
- Permet de réaliser des différentes actions à distance, lancées depuis le terminal mobile du
client ou à partir du serveur, tel que contrôler une machine, allumer ou éteindre une
lampe,…
- Offre une meilleure surveillance en intégrant des différents capteurs sans fil répartis dans
différents emplacements stratégiques, selon la nature de l’établissement et le besoin du
client.
- On peut programmer le serveur pour qu’il déclenche automatiquement une action suite à un
événement tel que la hausse de la température à un seuil fixé par l’utilisateur, dans ce cas : le
serveur active automatiquement la climatisation, on peut aussi programmer le serveur pour
qu’il nous envoie une alerte sur notre terminal mobile s’il détecte une présence hostile.

# Capture des besoins
## Identification des acteurs
```
a. Les acteurs
« Un acteur représente l’abstraction d’un rôle joué par des entités externes (utilisateur,
dispositif matériel ou autre système) qui interagissent directement avec le système étudié. » [mg]
Tous simplement un acteur est une entité physique (personne) ou abstraite (logiciel)
capable d’utilisée le système afin de répondre à un besoin bien définit. Les acteurs de notre
application sont :
Utilisateur : Il désigne la personne ou l'entité qui prend la décision de consulte les états des équipements, pilote les différent équipements.
Administrateur : l’administrateur a accès à toutes les fonctionnalités du système sans limite, ces fonctionnalités qui sont principalement la gestion des maisons, les endroits, les équipements.
```
## Les besoins fonctionnels
```
Les besoins fonctionnels ou les cas d’utilisations en terme d’UML peuvent être définis comme suit : « Un cas d’utilisation (use case) représente un ensemble de séquences d’actions réalisées par le système et produisant un résultat observable intéressant pour un acteur particulier. » [MG]
Un cas d’utilisation est une suite d’actions effectuées par le système afin de répondre à
une demande d’un utilisateur (acteur). Dans ce qui suit, nous décrivons les différents besoins fonctionnels de notre système par acteur :

Utilisateur : cet acteur attend les fonctionnalités suivantes au système :
•	Authentification
•	Consulter l’état des équipements électriques
•	Piloter les différents équipements électriques
•	Consulter  température et humidité
Administrateur : cet acteur se focalise essentiellement sur les fonctionnalités 
•	Gérer les maisons, les endroits.
•	Gérer les endroits.
•	Gérer les équipements.
```
## Les besoins non fonctionnels
```
Les besoins non fonctionnels sont des besoins qui ont un aspect visible pour l’utilisateur, mais qui ne sont pas reliés directement au comportement du système. Les besoins non fonctionnels de notre système se décrivent comme suit :

•	De la sécurité 
La solution proposée permet à l’utilisateur une navigation sécurisée. Elle n’est accessible qu’avec une authentification.

•	Besoins d’utilisation : 
Tous les standards d’ergonomies doivent être présents : interface utilisateur bien claire et simple dans l’utilisation.
•	Besoins de performance : il s’agit d’optimiser le temps de chargements des pages par l’utilisation des bonnes pratiques du développement.
```
# Directory Structure
```

|   README.md
|   
+---01. Arduino
|       DOMOTIQUE.ino
|       
+---02. Android
|   \---DOMOTIQUE
|       +---.metadata
|       |   |   .lock
|       |   |   .log
|       |   |   version.ini
|       |   |   
|       |   +---.mylyn
|       |   |       repositories.xml.zip
|       |   |       tasks.xml.zip
|       |   |       
|       |   \---.plugins
|       |       +---com.android.ide.eclipse.adt
|       |       |   +---palette-preview-r16b-17-apptheme-37inwvganexusone
|       |       |   |       AnalogClock.png
|       |       |   |       AutoCompleteTextView.png
|       |       |   |       Button.png
|       |       |   |       CalendarView.png
|       |       |   |       CheckBox.png
|       |       |   |       CheckedTextView.png
|       |       |   |       Date.png
|       |       |   |       DigitalClock.png
|       |       |   |       Email.png
|       |       |   |       ExpandableListView.png
|       |       |   |       LargeText.png
|       |       |   |       ListView.png
|       |       |   |       MediumText.png
|       |       |   |       MultiAutoCompleteTextView.png
|       |       |   |       MultilineText.png
|       |       |   |       Number.png
|       |       |   |       NumberDecimal.png
|       |       |   |       NumberSigned.png
|       |       |   |       Password.png
|       |       |   |       PasswordNumeric.png
|       |       |   |       PersonName.png
|       |       |   |       Phone.png
|       |       |   |       PlainText.png
|       |       |   |       PostalAddress.png
|       |       |   |       preview.properties
|       |       |   |       ProgressBarHorizontal.png
|       |       |   |       ProgressBarLarge.png
|       |       |   |       ProgressBarNormal.png
|       |       |   |       ProgressBarSmall.png
|       |       |   |       QuickContactBadge.png
|       |       |   |       RadioButton.png
|       |       |   |       RadioGroup.png
|       |       |   |       RatingBar.png
|       |       |   |       SeekBar.png
|       |       |   |       SmallButton.png
|       |       |   |       SmallText.png
|       |       |   |       Spinner.png
|       |       |   |       Switch.png
|       |       |   |       TabHost.png
|       |       |   |       TabWidget.png
|       |       |   |       TextView.png
|       |       |   |       Time.png
|       |       |   |       ToggleButton.png
|       |       |   |       ZoomButton.png
|       |       |   |       ZoomControls.png
|       |       |   |       
|       |       |   \---palette-preview-r16b-18-apptheme-37inwvganexusone
|       |       |           preview.properties
|       |       |           Switch.png
|       |       |           TabHost.png
|       |       |           TabWidget.png
|       |       |           
|       |       +---org.eclipse.cdt.core
|       |       |       .log
|       |       |       
|       |       +---org.eclipse.cdt.make.core
|       |       |       specs.c
|       |       |       specs.cpp
|       |       |       
|       |       +---org.eclipse.core.resources
|       |       |   |   .snap
|       |       |   |   
|       |       |   +---.history
|       |       |   |   +---1b
|       |       |   |   |       107fabaab2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---1f
|       |       |   |   |       006987b3b2b900131c998677f6ff02a4
|       |       |   |   |       e043fa04bbb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---22
|       |       |   |   |       e0f67319bbb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---23
|       |       |   |   |       603ad242c0b900131c998677f6ff02a4
|       |       |   |   |       801030432ebb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---29
|       |       |   |   |       0091125b2ebb001319c9864c29872429
|       |       |   |   |       f07b3c80bab900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---2c
|       |       |   |   |       70869e142ebb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---31
|       |       |   |   |       60b4a5d7bfb900131c998677f6ff02a4
|       |       |   |   |       d0b06abdb2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---36
|       |       |   |   |       a0e99b0f2fbb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---3c
|       |       |   |   |       30b05ec9b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---3e
|       |       |   |   |       a01cfd94b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---49
|       |       |   |   |       001ef4b92ebb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---56
|       |       |   |   |       106b66bdb2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---59
|       |       |   |   |       60ffa598bdb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---81
|       |       |   |   |       10728cb3b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---82
|       |       |   |   |       d05b176bbcb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---85
|       |       |   |   |       f0b58068bdb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---86
|       |       |   |   |       a098539fb2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---88
|       |       |   |   |       30e972722ebb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---8b
|       |       |   |   |       00028d2fbbb900131c998677f6ff02a4
|       |       |   |   |       a0063385c0b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---96
|       |       |   |   |       308e7d61beb900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---ab
|       |       |   |   |       d05680a7b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---b0
|       |       |   |   |       e09b7ba7b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---b2
|       |       |   |   |       e0a39ca62ebb001319c9864c29872429
|       |       |   |   |       
|       |       |   |   +---bb
|       |       |   |   |       e016599fb2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---c2
|       |       |   |   |       001d63c9b2b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---f1
|       |       |   |   |       a0058fb2bab900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   +---f3
|       |       |   |   |       20244625c0b900131c998677f6ff02a4
|       |       |   |   |       
|       |       |   |   \---fe
|       |       |   |           60468d1b2ebb001319c9864c29872429
|       |       |   |           
|       |       |   +---.projects
|       |       |   |   +---Domotique
|       |       |   |   |   |   .markers
|       |       |   |   |   |   .markers.snap
|       |       |   |   |   |   .syncinfo.snap
|       |       |   |   |   |   
|       |       |   |   |   \---.indexes
|       |       |   |   |       |   history.index
|       |       |   |   |       |   properties.index
|       |       |   |   |       |   
|       |       |   |   |       +---a0
|       |       |   |   |       |   +---3c
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---5f
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---66
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---cd
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---d6
|       |       |   |   |       |   |       history.index
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---de
|       |       |   |   |       |   |       history.index
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   +---eb
|       |       |   |   |       |   |       properties.index
|       |       |   |   |       |   |       
|       |       |   |   |       |   \---ee
|       |       |   |   |       |           properties.index
|       |       |   |   |       |           
|       |       |   |   |       \---e4
|       |       |   |   |           \---81
|       |       |   |   |               \---96
|       |       |   |   |                   \---df
|       |       |   |   |                           history.index
|       |       |   |   |                           
|       |       |   |   \---TrainingDom
|       |       |   |       |   .location
|       |       |   |       |   .markers.snap
|       |       |   |       |   .syncinfo.snap
|       |       |   |       |   
|       |       |   |       \---.indexes
|       |       |   |           |   properties.index
|       |       |   |           |   
|       |       |   |           \---a0
|       |       |   |               +---3c
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---5f
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---66
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---cd
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---d6
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---de
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               +---eb
|       |       |   |               |       properties.index
|       |       |   |               |       
|       |       |   |               \---ee
|       |       |   |                       properties.index
|       |       |   |                       
|       |       |   +---.root
|       |       |   |   |   .markers.snap
|       |       |   |   |   7.tree
|       |       |   |   |   
|       |       |   |   \---.indexes
|       |       |   |           history.version
|       |       |   |           properties.index
|       |       |   |           properties.version
|       |       |   |           
|       |       |   \---.safetable
|       |       |           org.eclipse.core.resources
|       |       |           
|       |       +---org.eclipse.core.runtime
|       |       |   \---.settings
|       |       |           com.android.ide.eclipse.adt.prefs
|       |       |           com.android.ide.eclipse.ddms.prefs
|       |       |           org.eclipse.cdt.debug.core.prefs
|       |       |           org.eclipse.cdt.ui.prefs
|       |       |           org.eclipse.core.resources.prefs
|       |       |           org.eclipse.debug.core.prefs
|       |       |           org.eclipse.debug.ui.prefs
|       |       |           org.eclipse.epp.usagedata.recording.prefs
|       |       |           org.eclipse.jdt.core.prefs
|       |       |           org.eclipse.jdt.launching.prefs
|       |       |           org.eclipse.jdt.ui.prefs
|       |       |           org.eclipse.mylyn.context.core.prefs
|       |       |           org.eclipse.mylyn.monitor.ui.prefs
|       |       |           org.eclipse.team.cvs.ui.prefs
|       |       |           org.eclipse.team.ui.prefs
|       |       |           org.eclipse.ui.editors.prefs
|       |       |           org.eclipse.ui.ide.prefs
|       |       |           org.eclipse.ui.prefs
|       |       |           org.eclipse.ui.workbench.prefs
|       |       |           org.eclipse.wst.sse.core.prefs
|       |       |           org.eclipse.wst.sse.ui.prefs
|       |       |           
|       |       +---org.eclipse.debug.core
|       |       |   \---.launches
|       |       |           Domotique.launch
|       |       |           
|       |       +---org.eclipse.debug.ui
|       |       |       dialog_settings.xml
|       |       |       launchConfigurationHistory.xml
|       |       |       
|       |       +---org.eclipse.e4.workbench
|       |       |       workbench.xmi
|       |       |       
|       |       +---org.eclipse.epp.usagedata.recording
|       |       |       usagedata.csv
|       |       |       
|       |       +---org.eclipse.jdt.core
|       |       |       2054458034.index
|       |       |       2836109955.index
|       |       |       630010313.index
|       |       |       783754427.index
|       |       |       externalLibsTimeStamps
|       |       |       invalidArchivesCache
|       |       |       javaLikeNames.txt
|       |       |       nonChainingJarsCache
|       |       |       savedIndexNames.txt
|       |       |       variablesAndContainers.dat
|       |       |       
|       |       +---org.eclipse.jdt.launching
|       |       |       .install.xml
|       |       |       libraryInfos.xml
|       |       |       
|       |       +---org.eclipse.jdt.ui
|       |       |   |   dialog_settings.xml
|       |       |   |   OpenTypeHistory.xml
|       |       |   |   QualifiedTypeNameHistory.xml
|       |       |   |   
|       |       |   \---jdt-images
|       |       |           0.png
|       |       |           
|       |       +---org.eclipse.ltk.core.refactoring
|       |       |   \---.refactorings
|       |       |       \---Domotique
|       |       |           \---2014
|       |       |               \---4
|       |       |                   \---14
|       |       |                           refactorings.history
|       |       |                           refactorings.index
|       |       |                           
|       |       +---org.eclipse.ltk.ui.refactoring
|       |       |       dialog_settings.xml
|       |       |       
|       |       +---org.eclipse.ui.workbench
|       |       |       dialog_settings.xml
|       |       |       workbench.xml
|       |       |       workingsets.xml
|       |       |       
|       |       +---org.eclipse.wst.internet.cache
|       |       |       cache.xml
|       |       |       
|       |       +---org.eclipse.wst.sse.ui
|       |       |       dialog_settings.xml
|       |       |       
|       |       \---org.eclipse.wst.xml.core
|       |               default_catalog.xml
|       |               system_catalog.xml
|       |               
|       \---Domotique
|           |   .classpath
|           |   .project
|           |   AndroidManifest.xml
|           |   ic_launcher-web.png
|           |   JSONParser.java
|           |   proguard-project.txt
|           |   project.properties
|           |   
|           +---.metadata
|           |   |   .lock
|           |   |   .log
|           |   |   version.ini
|           |   |   
|           |   +---.mylyn
|           |   |       repositories.xml.zip
|           |   |       
|           |   \---.plugins
|           |       +---org.eclipse.core.resources
|           |       |   +---.root
|           |       |   |   |   1.tree
|           |       |   |   |   
|           |       |   |   \---.indexes
|           |       |   |           history.version
|           |       |   |           properties.index
|           |       |   |           properties.version
|           |       |   |           
|           |       |   \---.safetable
|           |       |           org.eclipse.core.resources
|           |       |           
|           |       +---org.eclipse.core.runtime
|           |       |   \---.settings
|           |       |           org.eclipse.core.resources.prefs
|           |       |           org.eclipse.epp.usagedata.recording.prefs
|           |       |           org.eclipse.jdt.ui.prefs
|           |       |           org.eclipse.mylyn.context.core.prefs
|           |       |           org.eclipse.mylyn.monitor.ui.prefs
|           |       |           org.eclipse.team.cvs.ui.prefs
|           |       |           org.eclipse.team.ui.prefs
|           |       |           org.eclipse.ui.ide.prefs
|           |       |           org.eclipse.ui.prefs
|           |       |           org.eclipse.ui.workbench.prefs
|           |       |           
|           |       +---org.eclipse.epp.usagedata.recording
|           |       |       usagedata.csv
|           |       |       
|           |       +---org.eclipse.jdt.core
|           |       |       nonChainingJarsCache
|           |       |       variablesAndContainers.dat
|           |       |       
|           |       +---org.eclipse.jdt.ui
|           |       |       dialog_settings.xml
|           |       |       OpenTypeHistory.xml
|           |       |       QualifiedTypeNameHistory.xml
|           |       |       
|           |       \---org.eclipse.ui.workbench
|           |               dialog_settings.xml
|           |               workbench.xml
|           |               workingsets.xml
|           |               
|           +---.settings
|           |       org.eclipse.jdt.core.prefs
|           |       
|           +---bin
|           |   |   AndroidManifest.xml
|           |   |   classes.dex
|           |   |   Domotique.apk
|           |   |   jarlist.cache
|           |   |   resources.ap_
|           |   |   
|           |   +---classes
|           |   |   \---com
|           |   |       \---example
|           |   |           +---domotique
|           |   |           |   |   BuildConfig.class
|           |   |           |   |   Camera$1.class
|           |   |           |   |   Camera$ListHouseTask.class
|           |   |           |   |   Camera.class
|           |   |           |   |   DashBoard$1.class
|           |   |           |   |   DashBoard$2.class
|           |   |           |   |   DashBoard$3.class
|           |   |           |   |   DashBoard$4.class
|           |   |           |   |   DashBoard$5.class
|           |   |           |   |   DashBoard.class
|           |   |           |   |   DetailLetter.class
|           |   |           |   |   Letter$1.class
|           |   |           |   |   Letter$ListHouseTask.class
|           |   |           |   |   Letter.class
|           |   |           |   |   Lights$1.class
|           |   |           |   |   Lights$2.class
|           |   |           |   |   Lights$3.class
|           |   |           |   |   Lights$4.class
|           |   |           |   |   Lights$5.class
|           |   |           |   |   Lights$6$1.class
|           |   |           |   |   Lights$6.class
|           |   |           |   |   Lights$LightStateTask.class
|           |   |           |   |   Lights$LightTask.class
|           |   |           |   |   Lights$RoomTask.class
|           |   |           |   |   Lights.class
|           |   |           |   |   Maison$1.class
|           |   |           |   |   Maison$ListHouseTask.class
|           |   |           |   |   Maison.class
|           |   |           |   |   Params$1.class
|           |   |           |   |   Params$ConnectTask.class
|           |   |           |   |   Params.class
|           |   |           |   |   R$attr.class
|           |   |           |   |   R$dimen.class
|           |   |           |   |   R$drawable.class
|           |   |           |   |   R$id.class
|           |   |           |   |   R$layout.class
|           |   |           |   |   R$menu.class
|           |   |           |   |   R$string.class
|           |   |           |   |   R$style.class
|           |   |           |   |   R.class
|           |   |           |   |   Rooms.class
|           |   |           |   |   Settings.class
|           |   |           |   |   Shutters$1.class
|           |   |           |   |   Shutters$2.class
|           |   |           |   |   Shutters$3.class
|           |   |           |   |   Shutters$4.class
|           |   |           |   |   Shutters$CommandRoomTask.class
|           |   |           |   |   Shutters$ListRoomTask.class
|           |   |           |   |   Shutters$ShutterStateTask.class
|           |   |           |   |   Shutters.class
|           |   |           |   |   Thermiques$1.class
|           |   |           |   |   Thermiques$2.class
|           |   |           |   |   Thermiques$3.class
|           |   |           |   |   Thermiques$4.class
|           |   |           |   |   Thermiques$5.class
|           |   |           |   |   Thermiques$6$1.class
|           |   |           |   |   Thermiques$6.class
|           |   |           |   |   Thermiques$ChangeTask.class
|           |   |           |   |   Thermiques$LoadTask.class
|           |   |           |   |   Thermiques$ThermiqueStateTask.class
|           |   |           |   |   Thermiques.class
|           |   |           |   |   
|           |   |           |   \---dummy
|           |   |           |           DummyContent$DummyItem.class
|           |   |           |           DummyContent.class
|           |   |           |           
|           |   |           \---utils
|           |   |                   Alarme.class
|           |   |                   BoiteLetter.class
|           |   |                   Cam.class
|           |   |                   Climatiseur.class
|           |   |                   Equip.class
|           |   |                   House.class
|           |   |                   JSONParser.class
|           |   |                   Lampe.class
|           |   |                   Model_Equip.class
|           |   |                   Personne.class
|           |   |                   Room.class
|           |   |                   Shutter.class
|           |   |                   User.class
|           |   |                   Visiteur.class
|           |   |                   
|           |   +---dexedLibs
|           |   |       android-support-v4-1de5d1e1f5df7548f5ed72b15882517a.jar
|           |   |       
|           |   \---res
|           |       \---crunch
|           |           +---drawable-hdpi
|           |           |       boitealettre.png
|           |           |       camera.png
|           |           |       close.png
|           |           |       e.png
|           |           |       ic_launcher.png
|           |           |       light_low.png
|           |           |       light_max.png
|           |           |       light_middle.png
|           |           |       light_off.png
|           |           |       open.png
|           |           |       p.png
|           |           |       param.png
|           |           |       porte.png
|           |           |       t.png
|           |           |       v.png
|           |           |       
|           |           +---drawable-mdpi
|           |           |       ic_launcher.png
|           |           |       
|           |           +---drawable-xhdpi
|           |           |       ic_launcher.png
|           |           |       
|           |           \---drawable-xxhdpi
|           |                   ic_launcher.png
|           |                   
|           +---gen
|           |   \---com
|           |       \---example
|           |           \---domotique
|           |                   BuildConfig.java
|           |                   R.java
|           |                   
|           +---libs
|           |       android-support-v4.jar
|           |       
|           +---res
|           |   +---drawable-hdpi
|           |   |       backg.jpg
|           |   |       boitealettre.png
|           |   |       camera.png
|           |   |       close.png
|           |   |       dash.jpg
|           |   |       dash_gradient.xml
|           |   |       e.png
|           |   |       gradient_bgreen.xml
|           |   |       gradient_bm.xml
|           |   |       gradient_bn.xml
|           |   |       gradient_br.xml
|           |   |       gradient_bred.xml
|           |   |       ic_launcher.png
|           |   |       light_low.png
|           |   |       light_max.png
|           |   |       light_middle.png
|           |   |       light_off.png
|           |   |       open.png
|           |   |       p.png
|           |   |       param.png
|           |   |       porte.png
|           |   |       shutterc.jpg
|           |   |       shutterdc0.jpg
|           |   |       shutterdo.jpg
|           |   |       shuttero.jpg
|           |   |       t.png
|           |   |       v.png
|           |   |       
|           |   +---drawable-mdpi
|           |   |       ic_launcher.png
|           |   |       
|           |   +---drawable-xhdpi
|           |   |       ic_launcher.png
|           |   |       
|           |   +---drawable-xxhdpi
|           |   |       ic_launcher.png
|           |   |       
|           |   +---layout
|           |   |       activity_camera.xml
|           |   |       activity_dash_board.xml
|           |   |       activity_detail_letter.xml
|           |   |       activity_letter.xml
|           |   |       activity_lights.xml
|           |   |       activity_maison.xml
|           |   |       activity_params.xml
|           |   |       activity_rooms.xml
|           |   |       activity_shutters.xml
|           |   |       activity_thermiques.xml
|           |   |       
|           |   +---menu
|           |   |       camera.xml
|           |   |       dash_board.xml
|           |   |       detail_letter.xml
|           |   |       letter.xml
|           |   |       ligh.xml
|           |   |       lights.xml
|           |   |       maison.xml
|           |   |       params.xml
|           |   |       rooms.xml
|           |   |       shutter.xml
|           |   |       shutters.xml
|           |   |       thermiques.xml
|           |   |       
|           |   +---values
|           |   |       dimens.xml
|           |   |       strings.xml
|           |   |       styles.xml
|           |   |       
|           |   +---values-sw600dp
|           |   |       dimens.xml
|           |   |       
|           |   +---values-sw720dp-land
|           |   |       dimens.xml
|           |   |       
|           |   +---values-v11
|           |   |       styles.xml
|           |   |       
|           |   \---values-v14
|           |           styles.xml
|           |           
|           \---src
|               \---com
|                   \---example
|                       +---domotique
|                       |   |   Camera.java
|                       |   |   DashBoard.java
|                       |   |   DetailLetter.java
|                       |   |   Letter.java
|                       |   |   Lights.java
|                       |   |   Maison.java
|                       |   |   Params.java
|                       |   |   Rooms.java
|                       |   |   Settings.java
|                       |   |   Shutters.java
|                       |   |   Thermiques.java
|                       |   |   
|                       |   \---dummy
|                       |           DummyContent.java
|                       |           
|                       \---utils
|                               Alarme.java
|                               BoiteLetter.java
|                               Cam.java
|                               Climatiseur.java
|                               Equip.java
|                               House.java
|                               JSONParser.java
|                               Lampe.java
|                               Model_Equip.java
|                               Personne.java
|                               Room.java
|                               Shutter.java
|                               User.java
|                               Visiteur.java
|                               
+---03. WS
|       arduino.php
|       arduinoV1.php
|       db_config.php
|       db_connect.php
|       Droit.php
|       insertletter.php
|       Letter.php
|       Light - Copie.php
|       Light.php
|       LightState.php
|       List.php
|       Maison.php
|       Param.php
|       Room.php
|       Shutter.php
|       ShutterState.php
|       statshutt.php
|       statslight.php
|       statthermique.php
|       Thermique.php
|       ThermiqueState.php
|       
\---04. DataBase
        domotique.sql
```