package com.hiq.lab
import java.util.Stack

class Simulator(private val room: Room, private val car: Car, private val listOfCarInputMoves: List<String>) {
    // TODO This could be useful for implementing undo() if one would want to
    //  each command would just call it's own undo(), in backwards sequence from the stack
    private val stackCommands = Stack<CarMoveCommand>()
    private val carMoveCommandFactory = CarMoveCommandFactoryImpl()

    fun start() {
        listOfCarInputMoves.map {
            val command = carMoveCommandFactory.createCommand(it, car).apply { move() }
            room.update(car)
            stackCommands.push(command)
        }
    }
}