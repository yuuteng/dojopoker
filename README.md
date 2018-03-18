# dojopoker
#### Dojo - La main de Poker

###### Motif de conception

On désigne le project en MVC(Model , View , Controller) 

###### Structure

```
src
  +--control
       +--Game.java
       +--Test.java
  +--model
  	   +--Card.java
  	   +--Player.java
  	   +--Rank.java
  	   +--Suit.java
test
  +--control
       +--Game.java
  +--model
  	   +--CardTest.java
  	   +--PlayerTest.java
```

Dans le fichier **model**

- Suit.java : Un  enum enregistre 4 couleurs

- Rank.java: Un  enum enregistre 13 ranks les noms et les valeurs(par example ACE(valeur14 le max), TWO(valeur 2 le min) on utile les valeurs pour comparer)

- Card.java: Un model pour enregistrer l'information de la carte. Il implemente l'interface `Comparable` . Après on peut comparer la carte directement.

- Player.java : Un model pour enregistrer l'information de le player (le nom et les cartes).  

  > `handleCards()` : On trie les cartes (max -> min).
  >
  > `havePair()` : Si il a une même valeur  dans `List<Card>`,on fait return la valeur. Sinon on fait return 0.
  >
  > `haveThree()`: Presque la même chose comme `havePair()`.
  >
  > `haveFull()`: On fait `haveThree()>0`  (c'est-à-dire on a three et obtient la valeur). Après on cherche si il y a l'lautre paire dans la liste pas de valeur three on fait return la valeur de three.
  >
  > `haveFour()`: On cherche dans la liste de la main ,si il y a 4 cartes qui ont la même valeur on fait return la valeur.
  >
  > `haveSuit()`:On compare card1=card2=card3=card4=card5. Si c'est true on retrun la première valeur de la carte(max).
  >
  > `haveSameColor()`: Si 5 cartes ont la même suite ,return la plus grande valeur.
  >
  > `haveTwoPair()`: Si il y a 2 paire dans la main ,on fait une return `List<Card>` qui ont les deux valeurs de la paire pour comparer.
  >
  > `haveFlush()`: Si `haveSuit()`et`haveSameColor()` ,on fait return de la plus grande valeur.


Dans le fichier **control **

- Game.java: Pour controller le joue.

  > `addPlayer1Card()`: Ajouter une carte à la main de Player1. En suite on handle la séquence de les cartes.
  >
  > `addPlayer2Card()`:Comme avant.
  >
  > `matchCard()`: Switch la valeur et return  le nom de la carte ("11=V","12=D","13=R","1=As")
  >
  > `compareHighCard()`:Si player1 win return `Map<String,List<Card>>` ("1" et la Carte).
  >
  > `comparePair()`: on utile le method `havePair()` ,return 0:p1=p2 ;1:p1 win; 2:p2 win
  >
  > `compareThree()`,`compareFull()`,`compareFour()`,`compareSuit()`,`compareColor()`,`compareTwoPair()`,`compareFlush()` sont la même chose comme la même chose comme `comparePair()`
  >
  > `compare()`: On compare les cartes dans l'ordre(flush->four->full->color->suit->three->twopair->pair->high card) et utile`matchCard()` pour printer le résultat comme la question.
  >
  > ```
  > Exemples
  > Main 1:  2Tr 6Ca 7Ca 8Tr APi  
  > Main 2:  3Tr 5Ca 9Ca DCo RCo  
  > La main 1 gagne avec carte la plus élevée : As    
  >
  > Main 1:  2Tr 6Ca 7Ca 8Tr APi  
  > Main 2:  3Tr 5Ca 5Co DCo RCo  
  > La main 2 gagne avec paire de 5
  >
  > Main 1:  2Tr 6Ca 3Ca 8Tr APi  
  > Main 2:  3Tr 6Pi 2Ca 8Co ACo  
  > Egalite
  > ```

Dans le fichier **test **

- GameTest.java : On teste tous les comparations dans le fichier Game.java

- CardTest.java : On teste les methods dans le fichier Card.java

- PlayerTest.java: On teste les methods dans le fichier Player.java 

  ---

###### Description du problème

Comparer deux mains de poker saisie sur l’entrée standard, déterminer laquelle est la plus forte et afficher ce résultat.

###### Description des règles

Une main de poker comprend 5 cartes tirées d’un seul jeu de 52 cartes. Chaque carte à une couleur, Trèfle, Carreau, Coeur, Pique (dénotée Tr, Ca, Co, Pi) et une valeur parmi 2, 3, 4, 5, 6, 7, 8, 9, 10, valet, dame, roi, as (dénotée 2, 3, 4, 5, 6, 7, 8, 9, 10, V, D, R, A). Pour le calcul du score, toutes les couleurs ont le même niveau, par exemple l’as de carreau n’est pas battu par l’as de pique, ils sont égaux. Les valeurs sont ordonnées comme définies précédemment, le 2 étant la plus petite valeur et l’as la plus grande.

Une main de poker est faite de 5 cartes et les mains sont classées de la plus petite à la plus grande, de la manière suivante :

- <font color="red">Plus haute carte :</font> les mains qui ne correspondent à aucune autre catégorie sont classées par la valeur de leur plus haute carte. Si les plus hautes cartes ont la même valeur, les mains sont classées par la plus haute suivante et ainsi de suite.
- <font color="red">Paire : </font>2 des 5 cartes de la main ont la même valeur. Deux mains qui contiennent une paire sont classées par la valeur des cartes formant la paire. Si les valeurs sont les mêmes, les mains sont classées par les cartes hors de la paire, en ordre décroissant.
- <font color="red">Deux paires : </font>La main contient deux paires différentes. Les mains qui contiennent deux paires sont classées par la valeur de la paire la plus élevée. Deux mains avec la paire la plus élevée de même valeur sont classées par l’autre paire. Si ces valeurs sont les mêmes, les mains sont classées par la valeur de la carte restante.
- <font color="red"> Brelan : </font> 3 cartes dans la main ont la même valeur. Deux mains avec un brelan sont classées par la valeur des 3 cartes.
- <font color="red">Suite : </font> 5 cartes de valeurs consécutives. Deux suites sont classées par la valeur de leur carte la plus élevée.
- <font color="red">Couleur : </font> La main contient 5 cartes de la même couleur. Deux mains “couleur” sont classées par les règles de la carte la plus élevée.
- <font color="red">Full :</font> La main contient  3 cartes de la même valeur avec les 2 cartes formant une paire, le classement se fait par la valeur des 3 cartes.
- <font color="red">Carré :</font> 4 cartes de la même valeur, classement par la valeur des 4 cartes.
- <font color="red">Quinte Flush :</font>  5 cartes de la même couleur avec des valeurs consécutives, classement par la carte la plus élevée dans la main.

###### Exemples

Main 1:  2Tr 6Ca 7Ca 8Tr APi  

Main 2:  3Tr 5Ca 9Ca DCo RCo  

La main 1 gagne avec carte la plus élevée : As    

Main 1:  2Tr 6Ca 7Ca 8Tr APi  

Main 2:  3Tr 5Ca 5Co DCo RCo  

La main 2 gagne avec paire de 5

Main 1:  2Tr 6Ca 3Ca 8Tr APi  

Main 2:  3Tr 6Pi 2Ca 8Co ACo  

Egalite








