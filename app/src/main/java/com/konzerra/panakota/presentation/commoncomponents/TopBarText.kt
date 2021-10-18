package com.konzerra.panakota.presentation.commoncomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konzerra.panakota.R
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.Blue700

@Composable
fun TopBarText(
    contentDescription: String,
    title:String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Blue500),
    ){
        Row(modifier = Modifier.fillMaxHeight(),) {
            Image(
                painterResource(R.drawable.ic_menu),
                "",
                modifier = Modifier
                    .layoutId("iconMenuView")
                    .padding(end = 16.dp, start = 16.dp, top = 16.dp)
                    .height(25.dp)
                    .width(25.dp),
                contentScale = ContentScale.Fit,
                colorFilter = ColorFilter.lighting(Blue700, Blue700)
            )
            Text(text = title,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}