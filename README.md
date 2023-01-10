# Labo

Classe Personne :  Attribut String"nom" et "Club".
Avec constructor, getter et setter pour chaque attribut.

Classe Stage : Attribut String "nom", Treeset de personnes "Inscrit", "horaire" de type horaire.
Avec constructor, getter et setter pour chaque attribut.

Record Horaire qui implémente Comparable<Horaire> prenant en argument LocalDateTime (debut du stage) et LocalTime (heure de fin du stage).

Classe DateHoraire utilisé pour la création de la date et heure avec les méthodes dateTime() servant à entrer la date de début et time() servant a entrer l'heure de fin du stage.

Interface Controleur avec les méthodes TreeSet<Personne> inscription(TreeSet<Personne> personneList). Servant à la gestion des personnes dans les stages.
Stage(), servant à la gestion des stages.
afficherListeStage() servant à afficher les différent stages avec les toutes les données inserer, classer par ordre chronologique de la date et heure du stage.

Classe CreateControleur, implemente les méthode de l'interface Controleur et utilise les sous-méthode: editStage, deleteStage et addStage, pour la modification, la suppression et l'ajout des Stages dans une Map<Stage, TreeSet<Personne>. Ainsi que les même méthode pour la gestion du TreeSet de personnes.

Interface input avec méthode String red(String message)
Classe ScannerInput qui implemente Input. Utiliser pour communiquer et entrer les données de l'utilisateur.

Classe Main, Utiliser pour exécuter le programme et gestion du menu principal

Le programme est loin d'être terminer, l'objectif que je m'étais fixé était de travailler avec les collections et d'être plusà l'aise avec la gestion des adresses mémoire des différents objets contenuent dans les collections.
J'auai pu m'abstenir de faire une date de fin de stage comme je l'ai fais et faire uniquement une addition des minutes que l'utilsateur aurait entrer au moment de la création de la date du stage.
Il est probal que le fait d'avoir fait les stages comme la valeur principal pour un planning n'est pas des plus judicieux. Car pour l'ajout des repas, des logements et autres, cela complique énorment les choses. 
