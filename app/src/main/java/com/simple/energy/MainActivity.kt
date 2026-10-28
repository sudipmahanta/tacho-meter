package com.simple.energy

import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.appcompat.app.AppCompatActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.simple.energy.data.TelemetryRepository
import com.simple.energy.data.VehicleDataSource
import com.simple.energy.ui.VehicleDashboard
import com.simple.energy.ui.VehicleViewModel

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val dataSource = VehicleDataSource()
        val repository = TelemetryRepository(dataSource)

        val factory = object : ViewModelProvider.Factory {
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(VehicleViewModel::class.java)) {
                    @Suppress("UNCHECKED_CAST")
                    return VehicleViewModel(repository) as T
                }
                throw IllegalArgumentException(
                    "Unknown ViewModel class: ${modelClass.name}"
                )
            }
        }

        val vehicleVm = ViewModelProvider(this, factory)[VehicleViewModel::class.java]
        setContent {
            val vehicleState by vehicleVm.uiState.collectAsStateWithLifecycle();
            VehicleDashboard(vehicleState)
        }
    }
}