package com.hiq.lab

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class SimulatorTest {

    @Test
    fun testDrivingCarEndsInCorrectPosition() {
        val room = Room(5, 5, 0, 0)
        val car = Car(
            0, 0, Direction.EAST
        )
        val simulator = Simulator(
            room, car, listOf("F", "F", "F", "F")
        )
        simulator.start()
        assertEquals(0,car.xPos, "Car xPos position is not correct")
        assertEquals(4,car.yPos, "Car yPos position is not correct")
        assertEquals(Direction.EAST, car.direction, "Car yPos position is not correct")
    }

    @Test
    fun testMoreComplexDrivingCarEndsInCorrectPosition() {
        val room = Room(5, 5, 0, 0)
        val car = Car(
            0, 0, Direction.EAST
        )
        val simulator = Simulator(
            room, car, listOf("F", "F", "R", "F", "F", "L", "F", "F", "R", "B")
        )
        simulator.start()
        assertEquals(1,car.xPos, "Car xPos is not correct")
        assertEquals(4,car.yPos, "Car yPos is not correct")
        assertEquals(Direction.SOUTH,car.direction, "Car direction is not correct")
    }

    @Test
    fun testDrivingCarOutOfBoundsThrowsCollisionException() {
        assertFailsWith<CollisionException> {
            val room = Room(5, 5, 0, 0)
            val car = Car(
                0, 0, Direction.EAST
            )
            val simulator = Simulator(
                room, car, listOf("F", "F", "F", "F", "F")
            )
            simulator.start()
        }
    }
}