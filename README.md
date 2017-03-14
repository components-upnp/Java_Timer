# upnp_Timer
Un composant permettant de simuler un chronomètre.

Il possède trois boutons, un bouton start qui permet de lancer le chronomètre, un bouton stop qui permet d'arreter le chronomètre et le bouton "remise à zéro" qui permet de reinitialiser le compteur.
Les boutons start et stop sont confondus. C'est le même bouton qui est utilisé, seulement le nom qui change.
à l'état initial le bouton start est activé, le bouton stop n'est pas visible et le bouton mise à jour est désactivé. Donc
c'est sur le bouton star qu'on peut appyer, quand le chronomètre est en marche, le bouton stop activé, le bouton start est invisible et le bouton mise à jour est desactivé.
Quand on clique sur le bouton stop, les boutons start et mise à zéro sont activé et le bouton stop est invisible.
On peut cliquer sur remise à zero pour réunitiliser le compteur oubien sur start pour continuer.

Installation:
Il faut l'ajouter avec d'autre(s) composant(s) sur wcomp, voir ce lien https://wwwsecu.irit.fr/swiki/doku.php?id=smac:oppocampus:wcomp:bean. Et puis le connecté avec d'autre(s) composant(s) par exemple un bouton. 
Dès qu'il reçoit un évènement, il se lance et quand le temps s'écoule il envoie un évènement
à une ampoule par exemple pour l'éteindre.

Exemple d'utilisation:
Pendant le cours, quand le professeur donne un exercice à faire, il peut dire aux étudiant par exemple qu'ils ont dix minutes pour le faire. Dès qu'il voudra que les étudiants commencent, il appuye sur le bouton start pour lancer le chronomètre. Quand le temps s'écoule, il appuye sur le bouton stop pour arreter le chronomètre. Il peut reinitialiser le chronomètre ou augmenter le temps. 
