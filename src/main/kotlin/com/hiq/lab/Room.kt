package com.hiq.lab

class CollisionException(message: String) : Exception(message)

class Room(width: Int, height: Int, startingXPos: Int, startingYPos: Int) : Observer {
    val grid = Array(width) {Array(height) {0} }
    init {
        try {
            grid[startingXPos][startingYPos] = 1
        }
        catch (exception: ArrayIndexOutOfBoundsException) {
            throw CollisionException("Invalid starting position for car x: $startingXPos y: $startingYPos")
        }
    }

    override fun update(car: Car) {
        try {
            grid[car.xPos][car.yPos] = 1
        }
        catch (exception: ArrayIndexOutOfBoundsException) {
            throw CollisionException("The car collided with a wall at xPos: ${car.xPos} and yPos: ${car.yPos}")
        }
    }
}