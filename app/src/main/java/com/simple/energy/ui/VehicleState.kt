package com.simple.energy.ui

data class VehicleState (
    val speedInKmPerHour: Float = 0f,
    val isEngineOn: Boolean = false,
    val isKillSwitchOn: Boolean = false,
    val state: String = "PARKED",
    val isTelemetryAvailable: Boolean = false,
    val isTelemetryStale: Boolean = false,
    val feedbackMsg: String? = null,
)