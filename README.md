ChessProblem
============
The problem is to find all unique configurations of a set of normal chess pieces on a chess
board with dimensions M×N where none of the pieces is in a position to take any of the
others. Assume the colour of the piece does not matter, and that there are no pawns among
the pieces.

### How to run program for 7×7 board with 2 Kings, 2 Queens, 2 Bishops and 1 Knight

1. In Intellij IDEA run Worksheet.sc
2. In the console using sbt
```
$ export SBT_OPTS="-Xmx4G -XX:+UseConcMarkSweepGC -XX:+CMSClassUnloadingEnabled -XX:MaxPermSize=4G -Xss2M"
$ sbt
[info] Set current project to chess-problem (in build file:/Users/vm/development/sworkspace/ChessProblem/)
> runMain Main
[info] Running Main 
3063828 solutions for Bishop=2, King=2, Queen=2, Knight=1 on board 7*7
. . . . B . . 
. . Q . . . . 
. . . . K . . 
. . . . . . Q 
. . . B . . . 
. K . N . . . 
. . . . . . . 

Q . . . . . . 
. . . B N . B 
. . . . . . . 
. . . . . . K 
. . . . . . . 
. Q . . . . . 
. . . . K . . 

Q . . . . . . 
. . . B N . K 
. . . . . . . 
. . . . . . K 
. . . . . . . 
. Q . . . . . 
. . . . B . . 

. . . . . . . 
. . . . . . Q 
. B . . . . . 
. N . . . K . 
. . . . . . . 
. . . K . B . 
Q . . . . . . 

. . . Q . . . 
. . . . . . N 
Q . . . . . . 
. . . . . . . 
. . . . K . B 
. . . . . . . 
. . K . . B . 

. . . Q . . . 
. . . . . . B 
Q . . . . . . 
. . . . . . . 
. . . . K . K 
. . . . . . . 
. . N . . B . 

. . . Q . . . 
. . . . . . K 
Q . . . . . . 
. . . . . . . 
. . . . K . B 
. . . . . . . 
. . N . . B . 

. . . Q . . . 
. . . . . . B 
Q . . . . . . 
. . . . . . . 
. . . . K . B 
. . . . . . . 
. . N . . K . 

. B . . . K . 
. . . Q . . . 
. . . . . . . 
. . . . . . Q 
. . . . . . . 
K . . . . . . 
. . B . N . . 

. K . . . . N 
. . . . . . B 
Q . . . . . . 
. . . . . Q . 
. . . . . . . 
. K . . . . . 
. . . . . . B 

[success] Total time: 142 s, completed Jul 30, 2014 8:25:54 AM
```
where:
* K -> King
* Q -> Queen
* B -> Bishop
* N -> Knight

`Program lists 10 unique configurations to the console`
