# Lab solution
This was created using IntelliJ 2024.2.4 (Community Edition)
* Java SDK 21
* Kotlin 2.0.20
* No libraries or frameworks
## Prerequisites
You need to have Java SDK 21 Installed and in your path in order to run this.
## Run the project:

```
./gradlew run -q --console=plain
```

Example of successful terminal session:

```
Input room dimensions in metres (width and height) eg 5x5
7x7
Input car starting position (x and y) eg 1,3
0,0
Input car starting direction [NESW] e.g N
E
Input car movement commands in a sequence.
Drive Forward (F)
Drive Backwards (B)
Turn Left (L)
Turn Right (R)
e.g
        
FFFFLFFFRBBFF


FFFFRF
The simulation was successful, car end position was: Car(xPos=1, yPos=4, direction=SOUTH)
The car covered this route:
1, 1, 1, 1, 1, 0, 0
0, 0, 0, 0, 1, 0, 0
0, 0, 0, 0, 0, 0, 0
0, 0, 0, 0, 0, 0, 0
0, 0, 0, 0, 0, 0, 0
0, 0, 0, 0, 0, 0, 0
0, 0, 0, 0, 0, 0, 0

Process finished with exit code 0
```

Example of unsuccessful terminal session:

```
Input room dimensions in metres (width and height) eg 5x5
5x5
Input car starting position (x and y) eg 1,3
0,0
Input car starting direction [NESW] e.g N
N
Input car movement commands in a sequence.
Drive Forward (F)
Drive Backwards (B)
Turn Left (L)
Turn Right (R)
e.g

FFFFLFFFRBBFF


F
The simulation was unsuccessful: The car collided with a wall at xPos: -1 and yPos: 0
```

## Run the tests:

```
./gradlew test
```

### TODO (improvements if I had more time)
* make a FAT runnable jar file
* Immutable cars 
* Implement undo move