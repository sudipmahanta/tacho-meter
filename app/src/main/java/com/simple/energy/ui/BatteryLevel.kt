package com.simple.energy.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BatteryLevel(
    batteryLevel: Int
) {

    val color: Color = when {
        batteryLevel <= 20 -> AppColor.StatusRed
        batteryLevel <= 40 -> AppColor.StatusAmber
        else -> AppColor.StatusGreen
    }
    Column {
        Text(
            text = "BATTERY",
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = AppColor.InactiveGray
        )
        Spacer(modifier = Modifier.height(10.dp))

        LinearProgressIndicator(
            progress = { batteryLevel.coerceIn(0, 100) / 100f },
            modifier = Modifier
                .width(180.dp)
                .height(12.dp),
            color = color,
            trackColor = AppColor.GaugeTrack,
            strokeCap = StrokeCap.Square
        )
        Spacer(modifier = Modifier.height(10.dp))

        Text(
            text = "$batteryLevel%",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = color
        )
    }
}