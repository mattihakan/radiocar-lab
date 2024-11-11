package com.hiq.lab

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*
import kotlin.test.assertEquals

class RoomTest {

    @Test
    fun update() {
        val room = Room(5, 5, 0, 0)
        val car = Car(0,1,Direction.EAST)
        room.update(car)
        assertEquals(room.grid[0][1], 1, "Car should have visited 0,1")
        car.yPos = 2
        room.update(car)
        assertEquals(room.grid[0][2], 1, "Car should have visited 0,2")
        assertNotEquals(room.grid[1][2], 1, "Car should not have visited 0,2")
    }
}