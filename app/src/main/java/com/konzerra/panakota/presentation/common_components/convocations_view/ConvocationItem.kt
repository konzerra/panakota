package com.konzerra.panakota.presentation.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Convocation
import com.konzerra.panakota.ui.theme.*

@Composable
fun ConvocationItem(convocation: Convocation){
    Box(
        modifier = Modifier
            .padding(start = 10.dp)
            .border(
                width = 1.dp,
                color = Wood700,
                shape = RoundedCornerShape(100.dp)
            )
            .clip(RoundedCornerShape(100.dp))
            .background(color = Wood100)
    ) {
        Text(
            text = convocation.name,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 6.dp, top = 5.dp)
        )
    }
}