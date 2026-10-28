package com.simple.energy.ui

import android.R
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.simple.energy.EnumDriveState


@Composable
fun DriveState(
    currentState: VehicleState
) {
    val textColor = when {
        currentState.speedInKmPerHour > 60 -> AppColor.StatusRed

        currentState.state == EnumDriveState.PARKED.name ->
            AppColor.StatusGreen

        currentState.state == EnumDriveState.READY.name ->
            AppColor.DashboardBlue

        currentState.state == EnumDriveState.ACCELERATING.name ->
            AppColor.StatusGreen

        currentState.state == EnumDriveState.DEACCELERATING.name ->
            AppColor.StatusGreen

        else -> AppColor.SecondaryText
    }

    Surface(
        modifier = Modifier.width(160.dp)
            .height(40.dp),
        shape = RoundedCornerShape(60.dp),
        color = textColor.copy(alpha = 0.09f),
    ) {
        Box(
            modifier = Modifier.padding(10.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = currentState.state,
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = textColor
            )
        }
    }
}
