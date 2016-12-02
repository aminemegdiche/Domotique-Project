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
```
## Identification des acteurs
a. Les acteurs
« Un acteur représente l’abstraction d’un rôle joué par des entités externes (utilisateur,
dispositif matériel ou autre système) qui interagissent directement avec le système étudié. » [mg]
Tous simplement un acteur est une entité physique (personne) ou abstraite (logiciel)
capable d’utilisée le système afin de répondre à un besoin bien définit. Les acteurs de notre
application sont :
Utilisateur : Il désigne la personne ou l'entité qui prend la décision de consulte les états des équipements, pilote les différent équipements.
Administrateur : l’administrateur a accès à toutes les fonctionnalités du système sans limite, ces fonctionnalités qui sont principalement la gestion des maisons, les endroits, les équipements.
## Les besoins fonctionnels
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
## Les besoins non fonctionnels
Les besoins non fonctionnels sont des besoins qui ont un aspect visible pour l’utilisateur, mais qui ne sont pas reliés directement au comportement du système. Les besoins non fonctionnels de notre système se décrivent comme suit :

•	De la sécurité 
La solution proposée permet à l’utilisateur une navigation sécurisée. Elle n’est accessible qu’avec une authentification.

•	Besoins d’utilisation : 
Tous les standards d’ergonomies doivent être présents : interface utilisateur bien claire et simple dans l’utilisation.
•	Besoins de performance : il s’agit d’optimiser le temps de chargements des pages par l’utilisation des bonnes pratiques du développement.
```