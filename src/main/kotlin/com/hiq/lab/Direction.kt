package com.hiq.lab

enum class Direction(val s: String) {
    NORTH("N"), SOUTH("S"), WEST("W"), EAST("E");

    companion object {
        infix fun from(value: String): Direction? = entries.firstOrNull { it.s == value }
    }
}