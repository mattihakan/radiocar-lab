package com.hiq.lab

class Car(var xPos: Int, var yPos: Int, var direction: Direction) {
    override fun toString(): String {
        return "Car(xPos=$xPos, yPos=$yPos, direction=$direction)"
    }
}