package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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


@Composable
fun AccountInfo(modifier: Modifier){
    val constraints = ConstraintSet {
        val textView = createRefFor("textView")
        val iconView = createRefFor("iconView")
        constrain(textView) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(iconView.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(iconView) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    ConstraintLayout(
        constraints,
        modifier = modifier
            .fillMaxWidth()
            .height(86.dp)
            .background(Blue700)
    ) {
        Text(
            text = "Guest",
            fontSize = 18.sp,
            modifier = Modifier.layoutId("textView")
        )
        Image(
            painterResource(R.drawable.ic_account),
            "",
            modifier = Modifier
                .layoutId("iconView")
                .padding(end = 10.dp, start = 16.dp)
                .height(30.dp)
                .width(30.dp),
            contentScale = ContentScale.Fit
        )
    }
}