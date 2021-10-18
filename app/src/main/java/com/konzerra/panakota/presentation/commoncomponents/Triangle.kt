package com.konzerra.panakota.presentation.commoncomponents

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.shape.GenericShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.drawscope.clipPath
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.ui.theme.Blue700

@Composable
fun TopTriangle(){
    val triangle = Path().apply{
        lineTo(100f, 0f)
        lineTo(100f, 86f)
        lineTo(0f,0f)
    }
    Canvas(modifier = Modifier.shadow(5.dp)){
        clipPath(triangle){
            drawRect(
                color = Blue700,
                size = size
            )
        }
    }
}