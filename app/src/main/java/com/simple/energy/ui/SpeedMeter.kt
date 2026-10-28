package com.simple.energy.ui
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathEffect
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SpeedMeter(
    progress: Float,
    modifier: Modifier = Modifier,
    trackColor: Color = AppColor.GaugeTrack,
    strokeWidth: Float = 14f
) {
    val animatedProgress by animateFloatAsState(
        targetValue = progress.coerceIn(0f, 120f),
        animationSpec = tween(durationMillis = 700),
        label = "CircularProgress"
    )

    val progressColor = when {
        animatedProgress > 0 && animatedProgress < 30 -> AppColor.StatusGreen
        animatedProgress >= 30 && animatedProgress < 60 -> AppColor.StatusAmber
        animatedProgress >= 60 -> AppColor.StatusRed
        else -> AppColor.InactiveGray
    }

    Box(
        modifier = modifier.size(360.dp),
        contentAlignment = Alignment.Center
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val stroke = Stroke(
                width = strokeWidth.dp.toPx(),
                cap = StrokeCap.Round,
            )

            val diameter = size.minDimension - stroke.width/4
            val arcSize = Size(diameter, diameter)
            val topLeft = Offset(
                x = (size.width - diameter) / 2f,
                y = (size.height - diameter) / 2f
            )

            drawArc(
                color = trackColor,
                startAngle = 180f,
                sweepAngle = 180f,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = stroke
            )
            drawArc(
                color = progressColor,
                startAngle = 180f,
                sweepAngle = 180f * animatedProgress / 120f,
                useCenter = false,
                topLeft = topLeft,
                size = arcSize,
                style = stroke
            )
        }

        Column(
            modifier = Modifier.offset(y = (-55).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = "${animatedProgress.toInt()}",
                fontSize = 75.sp,
                fontWeight = FontWeight.ExtraBold,
                color = progressColor
            )
            Spacer(modifier= Modifier.height(10.dp))
            Text(
                text = "KM/H",
                fontSize = 22.sp,
                fontWeight = FontWeight.Medium,
                color = AppColor.SecondaryText
            )
        }

    }
}
