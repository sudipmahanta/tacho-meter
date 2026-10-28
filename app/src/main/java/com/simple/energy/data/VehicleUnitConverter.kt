package com.simple.energy.data

object VehicleUnitConverter {

    /// Convert m/s to km/h
    fun metersPerSecondToKilometersPerHour (speedMetersPerSecond: Float): Float {
        require(value = speedMetersPerSecond.isFinite() && speedMetersPerSecond >= 0f) {
            "Speed must be finite and non-negative"
        }
        /// km/h
        val kmpH = speedMetersPerSecond * 3.6f
        return kmpH
    }


    /// Vehicle Speed should be between 0-100
    fun isUnderControlledSpeed(range: Float): Boolean {
        return range.isFinite() &&
                range >= 0f && range <= 100f
    }
}