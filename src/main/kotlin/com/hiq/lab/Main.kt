package com.hiq.lab

fun main() = try {
    println("Input room dimensions in metres (width and height) eg 5x5")
    val numbers = readln().split("x").mapNotNull { it.toIntOrNull() }

    if (numbers.isEmpty() || numbers.size != 2) {
        throw IllegalArgumentException("Invalid room dimensions entered, please input in the format of 5x5")
    }

    println("Input car starting position (x and y) eg 1,3")
    val carPosition = readln().split(",").mapNotNull { it.toIntOrNull() }

    if (carPosition.isEmpty() || carPosition.size != 2) {
        throw IllegalArgumentException("Invalid car starting position entered, please input in the format of 1,3")
    }

    println("Input car starting direction [NESW] e.g N")
    val carStartingPosition = readln()
    val direction = Direction.from(carStartingPosition)
        ?: throw IllegalArgumentException("Invalid car direction entered, please use one of these for values N E S W")

    println(
        """Input car movement commands in a sequence.
Drive Forward (F)
Drive Backwards (B)
Turn Left (L)
Turn Right (R)
e.g
        
FFFFLFFFRBBFF

"""
    )
    val listOfCarInputMoves = readln().mapNotNull { it.toString() }
    listOfCarInputMoves.forEach {
        if (it != "F" && it != "B" && it != "L" && it != "R") {
            throw IllegalArgumentException("Invalid car movement $it. Please use one of F B L R")
        }
    }

    val room = Room(numbers[0], numbers[1], carPosition[0], carPosition[1])
    val car = Car(
        carPosition[0], carPosition[1], direction
    )
    val simulator = Simulator(room, car, listOfCarInputMoves)
    simulator.start()
    println("The simulation was successful, car end position was: $car")
    println("The car covered this route:")
    room.grid.forEach {
        println(it.joinToString())
    }

} catch (exception: Exception) {
    println("The simulation was unsuccessful: ${exception.message}")
}