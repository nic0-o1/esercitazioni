Scomposizioni in fattori primi
==============================

Descrizione
-----------

Ogni numero intero maggiore di 1 può essere *scomposto* nel prodotto di
*fattori* opportunamente scelti tra i *numeri primi*. Ad esempio, questa è una
rappresentazione testuale delle scomposizioni degli interi tra 2 e 13

    2 => [2]
    3 => [3]
    4 => [2, 2]
    5 => [5]
    6 => [2, 3]
    7 => [7]
    8 => [2, 2, 2]
    9 => [3, 3]
    10 => [2, 5]
    11 => [11]
    12 => [2, 2, 3]
    13 => [13]

Scrivete un programma che, dato un numero come parametro sulla linea di comando,
emetta nel flusso di uscita la sequenza di scomposizioni, fino al numero dato
(compreso).


Vincoli
-------

Si può assumere che i numeri ottenuti dalle trasformazioni possano sempre essere
rappresentati con una variabile di tipo `int`.


Esempio
-------

Eseguendo `soluzione` e avendo `20` come parametro sulla linea di comando, il
programma emette

    2 => [2]
    3 => [3]
    4 => [2, 2]
    5 => [5]
    6 => [2, 3]
    7 => [7]
    8 => [2, 2, 2]
    9 => [3, 3]
    10 => [2, 5]
    11 => [11]
    12 => [2, 2, 3]
    13 => [13]
    14 => [2, 7]
    15 => [3, 5]
    16 => [2, 2, 2, 2]
    17 => [17]
    18 => [2, 3, 3]
    19 => [19]
    20 => [2, 2, 5]

nel flusso d'uscita.