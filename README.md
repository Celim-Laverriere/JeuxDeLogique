# JeuxDeLogique

 ##Comment lancer l'application :
    
  - Pour lancer l'application "JeuxDeLogique" vous devez au préalable vous placer dans le dossier JeuxDeLogique où 
    se trouve son "Executable Jar File". 
    Une fois dans ce dossier, pour appeler l'application et lancer le jeu vous devez saisir la commande 
    suivante : java -jar JeuxDeLogique.jar 
    
        Exemple : 
    
         E:\WORKSPACES\PROJETS_OC\JeuxDeLogique>java -jar JeuxDeLogique.jar 
     
  - Pour lancer l'application en mode développeur vous devez lors de son exécution lui passer
    le paramètre "-dev".
    
        Exemple :  E:\WORKSPACES\PROJETS_OC\JeuxDeLogique>java -jar JeuxDeLogique.jar -dev
    
##Configuration du jeu

 - Vous pouvez si vous le désiré paramétrer l'application comme il vous convient, ou presque !
   Comme changer le nombre de cases de la combinaison secrète, le nombre d'essais possible ou encore pour 
   le jeu Mastermind les chiffres utilisables pour la combinaison secrète.
   
   Pour ce ce faire vous devez ouvrir le fichier de configuration "config.properties" et saisir 
   vos nouveaux paramètres et sauvegarder.
   
  - Attention : pour le bon fonctionnement de l'application et le confort de jeu il est fortement recommandé 
   de respecter une configuration maximale de 8 cases pour un intervalle de 0 à 3 !    
 
# Annex 

##Comment lancer invite de commande : 

 - Pour ouvrir l'invite de commande tapez "cmd" dans la barre de recherche de Windows, 
   ce dernier va apparaître dans les résultats.

## Les commandes de base de l’invite de commande :

 - Pour naviguer entre les lecteurs vous devez taper la lettre du lecteur que vous voulez ouvrir suivi 
   de " : ", comme dans l'exemple ci-après :  
     
         C:\Users\LEO>D:

 - Pour naviguer dans vos dossiers vous devez taper "cd" puis le nom du dossier désiré. Pour ouvrir un dossier
   contenu dans un autre, il vous faura au préalable ouvrir le dossier pécédant.
   Comme dans l'exemple ci-dessous :  

        C:\Users\CELIM>E: 
    
        E:\>cd WORKSPACES
    
        E:\WORKSPACES>cd PROJETS_OC
    
        E:\WORKSPACES\PROJETS_OC>cd JeuxDeLogique
    
        E:\WORKSPACES\PROJETS_OC\JeuxDeLogique> ect...
    
 - Pour revenir sur le dossier précédent vous devez taper "cd .." ! reprenons notre exemple ci-dessus et remontons 
   d'un  dossier :
 
        E:\WORKSPACES\PROJETS_OC\JeuxDeLogique>cd ..
     
        E:\WORKSPACES\PROJETS_OC>
    
 - Pour afficher le contenu d'un dossier, palcez-vous dans ce dossier et tapez "dir", le contenu du dossier
   s'affichera dans votre console :
  
        E:\WORKSPACES\PROJETS_OC\JeuxDeLogique>dir
    
