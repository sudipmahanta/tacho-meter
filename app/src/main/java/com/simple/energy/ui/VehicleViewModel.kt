package com.simple.energy.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.simple.energy.data.TelemetryRepository
import com.simple.energy.data.VehicleUnitConverter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class VehicleViewModel (
    private val telemetry: TelemetryRepository
): ViewModel() {
    private val _uiState = MutableStateFlow(VehicleState())
    val uiState: StateFlow<VehicleState> = _uiState.asStateFlow()

    init {
        observeVehicleData()
    }

    private fun observeVehicleData() {
        viewModelScope.launch {
            telemetry.vehicleData.collect {
                data ->
                _uiState.value = VehicleState(
                    state = data.state,
                    speedInKmPerHour = VehicleUnitConverter.metersPerSecondToKilometersPerHour(data.speedms),
                    isEngineOn = data.isEngineOn,
                    isKillSwitchOn = data.isKillSwitchOn,
                    isTelemetryAvailable = true,
                    isTelemetryStale = false,
                    feedbackMsg = null,
                )
            }
        }
    }
}