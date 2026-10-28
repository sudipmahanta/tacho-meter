package com.simple.energy.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PowerSettingsNew
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun KillSwitchState(
    isActive: Boolean,
    onToggle: (Boolean) -> Unit,
    modifier: Modifier = Modifier
) {
    val accentColor = if (isActive) {
        AppColor.StatusRed
    } else {
        AppColor.StatusGreen
    }

    Surface(
        modifier = modifier
            .width(140.dp)
            .clickable {
                onToggle(!isActive)
            },
        shape = RoundedCornerShape(18.dp),
        color = AppColor.SurfaceLight,
        shadowElevation = 3.dp,
        border = androidx.compose.foundation.BorderStroke(
            1.dp,
            if (isActive) AppColor.StatusRedLight
            else AppColor.GaugeTrack
        )
    ) {
        Row(
            modifier = Modifier.padding(
                horizontal = 16.dp,
                vertical = 14.dp
            ),
        ) {
            Icon(
                imageVector = Icons.Filled.PowerSettingsNew,
                contentDescription = "Kill switch",
                modifier = Modifier.size(16.dp),
                tint = accentColor
            )
            Spacer(modifier= Modifier.width(5.dp))
            Text(
                text = "KILL SWITCH",
                fontSize = 14.sp,
                fontWeight = FontWeight.ExtraBold,
                color = accentColor
            )
        }
    }
}
