package com.simple.energy.data

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.filter
import java.time.Duration
import java.time.Instant

class TelemetryRepository (
    private val dataSource: VehicleDataSource,
    private val maxTelemetry: Long = 5_000L,
    private val nowUtc: () -> Instant = { Instant.now() }
) {
    init {
        require (maxTelemetry > 0L) {
            "Maximum telemetry age should be positive"
        }
    }

    val vehicleData: Flow<VehicleData> = dataSource.vehicleData.filter {
        data ->

        val isValidSpeed: Boolean =
            VehicleUnitConverter.isUnderControlledSpeed(data.speedms)

        val ageMillis = Duration.between(
            data.timestampUtc, nowUtc()
        ).toMillis()

        val isTimestampValid = ageMillis >= 0L && ageMillis <= maxTelemetry

        isValidSpeed && isTimestampValid
    }
}