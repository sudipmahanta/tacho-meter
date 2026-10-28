package com.simple.energy.data

import java.time.Instant

data class VehicleData (
    /// State of Vehicle
    val state: String,

    /// meter per sec this will make calc
    val speedms: Float,

    /// Determine whether engine is running condition.
    val isEngineOn: Boolean,

    /// Determine whether power-supply to engine/motor is on/off.
    val isKillSwitchOn: Boolean,

    /// UTC will help to avoid ambiguous data, When supply goes global.
    val timestampUtc: Instant,
    )