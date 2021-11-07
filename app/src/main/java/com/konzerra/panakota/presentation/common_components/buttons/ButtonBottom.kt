package com.konzerra.panakota.presentation.common_components.buttons

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.ui.theme.BlackBasic
import com.konzerra.panakota.ui.theme.White


@Composable
fun ButtonBottom(
    modifier: Modifier,
    text:String,
    onClicked:(Unit)->Unit
){
    Button(
        modifier = modifier
            .padding(top = 8.dp, bottom = 16.dp, start = 16.dp, end = 16.dp)
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = BlackBasic,
        ),
        onClick = {
            onClicked(Unit)
        }
    ) {
        Text(
            text = text,
            color = White,
        )
    }
}