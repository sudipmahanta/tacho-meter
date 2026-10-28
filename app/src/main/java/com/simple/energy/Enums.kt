package com.simple.energy

enum class EnumDriveState(val label: String) {
    PARKED("PARKED"),
    READY("READY"),
    ACCELERATING("ACCELERATING"),
    DEACCELERATING("DEACCELERATING"),
    CHARGING("CHARGING"),
}