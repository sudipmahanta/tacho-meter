package com.simple.energy.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Composable
fun DashboardDateTime() {
    var currentTime by remember {
        mutableStateOf(LocalDateTime.now())
    }

    LaunchedEffect(Unit) {
        while (true) {
            currentTime = LocalDateTime.now()
            delay(1000)
        }
    }

    val date = currentTime.format(
        DateTimeFormatter.ofPattern("dd MMM yyyy")
    )

    val time = currentTime.format(
        DateTimeFormatter.ofPattern("hh:mm a")
    )

    Box(
        modifier = Modifier.width(120.dp)
    ) {
        Column {
            Text(
                text = date,
                fontSize = 16.sp
            )
            Text(
                text = time,
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}
