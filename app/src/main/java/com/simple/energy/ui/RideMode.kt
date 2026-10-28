package com.simple.energy.ui

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun RideMode (
    currentState: VehicleState
) {
    val mode: String = when {
        currentState.speedInKmPerHour >= 0 && currentState.speedInKmPerHour < 40 -> "ECONOMY"
        currentState.speedInKmPerHour >= 40 && currentState.speedInKmPerHour < 60 -> "RIDE"
        currentState.speedInKmPerHour >= 60 -> "SPORT"
        else -> "UNKNOWN"
    }
    val color: Color = when {
        currentState.speedInKmPerHour >= 0 && currentState.speedInKmPerHour < 40 -> AppColor.StatusGreen
        currentState.speedInKmPerHour >= 40 && currentState.speedInKmPerHour < 60 ->  AppColor.StatusAmber
        currentState.speedInKmPerHour >= 60 -> AppColor.StatusRed
        else -> AppColor.SecondaryText
    }

    Surface (
        modifier = Modifier
            .width(110.dp)
            .height(40.dp),
        shape = RoundedCornerShape(60.dp),
        color = color.copy(alpha = 0.09f),
    ) {
        Box(
            modifier = Modifier.padding(10.dp),
            contentAlignment = Alignment.Center) {
            Text(text = mode, color = color)
        }
    }

}