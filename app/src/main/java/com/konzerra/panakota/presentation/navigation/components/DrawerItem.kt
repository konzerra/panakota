package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.Blue700
import com.konzerra.panakota.ui.theme.Typography

@Composable
fun DrawerItem(
    thisScreen: Screen,
    currentScreen: String,
    onClick: (String) -> Unit
){
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

    Card(modifier = Modifier
        .height(46.dp)
        .padding(start = 6.dp, end = 6.dp, top = 4.dp, bottom = 4.dp)
        .clickable {
            onClick(thisScreen.route)
        },
        //comparing drawable resources makes drawer display correct tab
        elevation = if(thisScreen.route == currentScreen) 4.dp else 0.dp,
        shape = RoundedCornerShape(4.dp)
    ) {
        ConstraintLayout(
            constraints,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .background( if(thisScreen.route == currentScreen) Blue700 else Blue500)
        ) {
            Text(
                text = stringResource(id = thisScreen.stringResource),
                style = Typography.body1,
                modifier = Modifier.layoutId("textView")
            )
            Image(
                painterResource(thisScreen.drawableResource),
                "",
                modifier = Modifier
                    .layoutId("iconView")
                    .padding(end = 22.dp, start = 16.dp)
                    .height(25.dp)
                    .width(25.dp),
                contentScale = ContentScale.Fit
            )
        }
    }
}