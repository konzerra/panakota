package com.konzerra.panakota.presentation.common_components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.ui.theme.BlackBasic

@Composable
fun Triangle(modifier: Modifier){
    Canvas(modifier = modifier
        .height(86.dp)
        .width(100.dp)
    ){
        val rectSize = size
        val triangle = Path().apply{
            lineTo(rectSize.width, 0f)
            lineTo(rectSize.width, rectSize.height)
            lineTo(0f,0f)
            close()
        }
        clipPath(triangle){
            drawRect(
                color = BlackBasic,
                size = rectSize,
            )
        }
    }
}