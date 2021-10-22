package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
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
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.ui.theme.Blue700
import com.konzerra.panakota.R
import com.konzerra.panakota.ui.theme.GrayForItems
import com.konzerra.panakota.ui.theme.WhiteSurface


@Composable
fun AccountInfo(modifier: Modifier){
    Surface(
        modifier = modifier,
        color = WhiteSurface) {
        Card(modifier = Modifier
            .padding(top = 4.dp, end = 8.dp, bottom = 4.dp)
            .fillMaxWidth()
            .height(86.dp),
            backgroundColor = GrayForItems,
            shape = RoundedCornerShape(topEnd = 30.dp, bottomEnd = 30.dp),

            ){
            Row(
                verticalAlignment = Alignment.CenterVertically
            ){

                Image(
                    painterResource(R.drawable.ic_account),
                    "",
                    modifier = Modifier
                        .layoutId("iconView")
                        .padding(end = 10.dp, start = 26.dp)
                        .height(40.dp)
                        .width(40.dp),
                    contentScale = ContentScale.Fit,
                    colorFilter = ColorFilter.lighting(WhiteSurface, WhiteSurface)
                )
                Text(
                    text = "Guest",
                    fontSize = 18.sp,

                    modifier = Modifier.layoutId("textView")
                )
            }
        }
    }

}