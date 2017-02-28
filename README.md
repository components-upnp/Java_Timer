# upnp_Timer
Chronomètre UpNp qui lance un évènement après un intervalle de temps donné. Ce composant utilise Upnp 
pour communiquer avec les atures composants, ils doivent être dans le même reseau.

Installation:
Il faut l'ajouter avec d'autre(s) composant(s) sur wcomp, voir ce lien https://wwwsecu.irit.fr/swiki/doku.php?id=smac:oppocampus:wcomp:bean. Et puis le connecté avec d'autre composant par exemple un bouton. 
Dès qu'il reçoit un évènement, le chronomètre est lancé et quand le temps s'écoule il envoie un évènement
à une ampoule par exemple pour l'éteindre.

Exemple d'utilisation:
Par exemple après un cours, quand tout le monde sort et que personne n'eteind la lumière, après un temps donné
le timer envoie un évènement à la lumière. Dès que la lumière reçiut le timer elle s'eteind.
