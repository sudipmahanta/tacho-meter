package com.simple.energy.data

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.time.Instant
import kotlin.time.Duration.Companion.milliseconds


class VehicleDataSource (
    private val intervalMillis: Long = 1_000L,
    private val nowUtc: ()-> Instant = { Instant.now() }
) {
    init {
        require(intervalMillis > 0L) {
            "Update Interval should be positive"
        }
    }

    val vehicleData: Flow<VehicleData> = flow {

        val states = listOf(
            VehicleState(
                name = "PARKED",
                speedList = listOf(0f),
                motorOn = false,
                killSwitchActive = false
            ),
            VehicleState(
                name = "READY",
                speedList = listOf(0f),
                motorOn = true,
                killSwitchActive = false
            ),
            VehicleState(
                name = "RIDING",
                speedList = listOf(5f, 5f, 5f),
                motorOn = true,
                killSwitchActive = false
            ),
            VehicleState(
                name = "ACCELERATING",
                speedList =
                    listOf(2.78f, 5.56f, 8.33f, 11.11f, 13.89f, 16.67f, 22.22f, 32.32f),
                motorOn = true,
                killSwitchActive = false
            ),
            VehicleState(
                name = "DECELERATING",
                speedList =
                    listOf(22.22f, 16.67f, 13.89f, 11.11f, 8.33f, 5.56f, 2.78f, 0f),
                motorOn = true,
                killSwitchActive = false
            ),
            VehicleState(
                name = "PARKING",
                speedList = listOf(0f),
                motorOn = false,
                killSwitchActive = true
            )
        )

        while (true) {
            for (state in states) {
                for (speed in state.speedList) {
                    emit(
                        value = VehicleData(
                            state = state.name,
                            speedms = speed,
                            isEngineOn = state.motorOn,
                            isKillSwitchOn = state.killSwitchActive,
                            timestampUtc = nowUtc()
                        )
                    )
                    delay(intervalMillis.milliseconds)
                }
            }
        }
    }

    private data class VehicleState (
        val name: String,
        val speedList: List<Float>,
        val motorOn: Boolean,
        val killSwitchActive: Boolean
    )
}