package com.simple.energy.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.indication
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.runtime.Composable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material.icons.rounded.BuildCircle
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight

@Composable
fun IndicatorState(
) {
    Row(
        modifier = Modifier
            .height(64.dp)
            .padding(horizontal = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
        ) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
            contentDescription = "Left indicator",
            modifier = Modifier.size(64.dp),
            tint = AppColor.StatusGreen
        )
        Icon(
            imageVector = Icons.Rounded.BuildCircle,
            contentDescription = "Service Due",
            modifier = Modifier.size(42.dp),
            tint = AppColor.StatusAmber
        )
        Surface(
            modifier = Modifier.padding(horizontal = 10.dp),
            shape = RoundedCornerShape(999.dp)
        ) {
            Box(
                modifier = Modifier
                    .background(color = AppColor.StatusGreen)
                    .size(40.dp),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "TC",
                    fontWeight = FontWeight.W800,
                    color = AppColor.BackgroundWhite
                )
            }
        }
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = "Right indicator",
            modifier = Modifier.size(64.dp),
            tint = AppColor.StatusGreen
        )
    }
}
