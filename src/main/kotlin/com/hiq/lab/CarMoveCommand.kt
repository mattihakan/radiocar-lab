package com.hiq.lab

interface CarMoveCommand {
    fun move()
    fun undo()
}

class TurnLeftCarMoveCommand(private val car: Car) : CarMoveCommand {
    override fun move() {
        car.direction = when (car.direction) {
            Direction.NORTH -> Direction.WEST
            Direction.SOUTH -> Direction.EAST
            Direction.WEST -> Direction.SOUTH
            Direction.EAST -> Direction.NORTH
        }
    }

    override fun undo() {
        TODO("Not yet implemented, should be the opposite of move()")
    }

    companion object {
        const val input = "L"
    }
}

class TurnRightCarMoveCommand(private val car: Car) : CarMoveCommand {
    override fun move() {
        car.direction = when (car.direction) {
            Direction.NORTH -> Direction.EAST
            Direction.SOUTH -> Direction.WEST
            Direction.WEST -> Direction.NORTH
            Direction.EAST -> Direction.SOUTH
        }
    }

    override fun undo() {
        TODO("Not yet implemented, should be the opposite of move()")
    }

    companion object {
        const val input = "R"
    }
}

class DriveForwardCarMoveCommand(private val car: Car) : CarMoveCommand {
    override fun move() {
        when (car.direction) {
            Direction.NORTH -> car.xPos--
            Direction.SOUTH -> car.xPos++
            Direction.WEST -> car.yPos--
            Direction.EAST -> car.yPos++
        }
    }

    override fun undo() {
        TODO("Not yet implemented, should be the opposite of move()")
    }

    companion object {
        const val input = "F"
    }
}

class DriveBackwardCarMoveCommand(private val car: Car) : CarMoveCommand {
    override fun move() {
        when (car.direction) {
            Direction.NORTH -> car.xPos++
            Direction.SOUTH -> car.xPos--
            Direction.WEST -> car.yPos++
            Direction.EAST -> car.yPos--
        }
    }

    override fun undo() {
        TODO("Not yet implemented, should be the opposite of move()")
    }

    companion object {
        const val input = "B"
    }
}

interface CarMoveCommandFactory {
    fun createCommand(input: String, car: Car): CarMoveCommand
}

class CarMoveCommandFactoryImpl : CarMoveCommandFactory {
    override fun createCommand(input: String, car: Car): CarMoveCommand =
        when (input) {
            DriveForwardCarMoveCommand.input -> DriveForwardCarMoveCommand(car)
            DriveBackwardCarMoveCommand.input -> DriveBackwardCarMoveCommand(car)
            TurnLeftCarMoveCommand.input -> TurnLeftCarMoveCommand(car)
            TurnRightCarMoveCommand.input -> TurnRightCarMoveCommand(car)
            else -> {
                throw IllegalArgumentException("No such move command")
            }
        }
}

