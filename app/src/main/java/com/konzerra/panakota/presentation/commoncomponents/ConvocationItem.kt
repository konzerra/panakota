package com.konzerra.panakota.presentation.commoncomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konzerra.panakota.ui.theme.Black500
import com.konzerra.panakota.ui.theme.Blue500

@Composable
fun Convocation(name:String, date:String){
    Card(modifier = Modifier
        .width(105.dp)
        .height(40.dp)
        .padding(start = 16.dp,)

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.background(color = Blue500)

        ) {
            Text(
                text = name
            )
            Text(
                text = date,
                color = Black500,
                fontSize = 10.sp

            )
        }
    }
}