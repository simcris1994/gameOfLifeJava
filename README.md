# Conway's Game of Life

Java implementation of Conway's Game of Life (https://web.stanford.edu/class/sts145/Library/life.pdf).

It takes as input a pattern represented as a .lif file, which describes the initial configuration - a grid with cells that are either alive or dead.

The game will then run by itself, changing each cell's state according to these rules:
    
    1. Any live cell with two or three live neighbours survives.
    
    2. Any dead cell with three live neighbours becomes a live cell.
    
    3. All other live cells die in the next generation. Similarly, all other dead cells stay dead.
    
Create your model or use an existing one (http://www.radicaleye.com/lifepage/patterns/contents.html), and then add it to the resources folder, then update the file path in LifReader.java.

How to run:
  1. Compile: javac com/game/Grid.java
  2. Build jar file: jar cmvf META-INF/MANIFEST.MF game.jar com/game/Grid.class
  3. Run jar
  

![game_of_life](https://user-images.githubusercontent.com/7521620/139602395-c285cada-90c8-48d8-a1f5-7af785c740f3.PNG)
