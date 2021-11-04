package com.konzerra.panakota.presentation.common_components.elections_view

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Election
import com.konzerra.panakota.ui.theme.Wood100
import com.konzerra.panakota.ui.theme.Wood700

@Composable
fun ElectionItem(
    election: Election
){
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
            text = election.name,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(start = 8.dp, end = 8.dp, bottom = 6.dp, top = 5.dp)
        )
    }
}