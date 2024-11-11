package com.hiq.lab

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class TurnLeftCarMoveCommandTest {

    @Test
    fun move() {
        val factory = CarMoveCommandFactoryImpl()
        val car = Car(
            0, 0, Direction.EAST
        )
        factory.createCommand("F", car).move()
        kotlin.test.assertEquals(1, car.yPos, "Expected car to be at yPos 1")
        factory.createCommand("B", car).move()
        kotlin.test.assertEquals(0, car.yPos, "Expected car to be at yPos 0")
        factory.createCommand("R", car).move()
        kotlin.test.assertEquals(Direction.SOUTH, car.direction, "Expected car direction to be SOUTH")
        factory.createCommand("L", car).move()
        kotlin.test.assertEquals(Direction.EAST, car.direction, "Expected car direction to be EAST")
    }
}