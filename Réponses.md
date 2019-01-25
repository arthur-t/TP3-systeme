# TP3

### 1.

####A.

Voir classe WebVerif

#### B.

Il y a la liste des résultats qui est partagée puisqu'il faut stockers les résultats du code renvoyé dans chaque thread.
Il y a aussi un sémaphore qui empêche d'ajouter dans la liste des résultat en même temps.

Je fixe le nombre de threads à 2 car utiliser trop de threads n'est pas performant, le processeur ne pouvant supporter un nombre de threads trop élevé.

#### C.

Voir classe GatStatus

### 2.

####A.

Pour le nombre de bananes, on va utiliser une 

####B.

Pour additionner les bananes, j'additione toutes les bananes qui ont été ajoutées dans la liste une fois que tous les services ont finit d'être exécuté.


####C.

Si on utilise une ArrayList, il faut utiliser un sémaphore intialisé à 1 que l'on va acquire avant l'ajout à la liste et release après l'ajout afin de garantir l'exclusion mutuelle.



####D.

On peut prendre une ArrayBlockingQueue qui sera ThreadSafe.
