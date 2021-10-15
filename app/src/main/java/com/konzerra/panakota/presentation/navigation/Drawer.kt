package com.konzerra.panakota.presentation.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.presentation.navigation.components.*
import com.konzerra.panakota.ui.theme.Blue500

@Composable
fun Drawer(
    currentScreen: Screen,
    onItemClicked: (Screen) -> Unit,
){
    val constraints = ConstraintSet {
        val topBox = createRefFor("topBox")
        val bottomBox = createRefFor("bottomBox")
        val accountInfo = createRefFor("accountInfo")
        val bottomItems = createRefFor("bottomItems")
        val middleItems = createRefFor("middleItems");

        constrain(topBox) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(accountInfo) {
            top.linkTo(topBox.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(middleItems) {
            top.linkTo(accountInfo.bottom)
            start.linkTo(parent.start)
            bottom.linkTo(bottomItems.top)
            width = Dimension.wrapContent
            height = Dimension.fillToConstraints
        }

        constrain(bottomItems) {
            bottom.linkTo(bottomBox.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

        constrain(bottomBox) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    ConstraintLayout(constraints,
        modifier = Modifier
            .fillMaxSize()
            .background(Blue500)
    ) {
        BottomBox(modifier = Modifier.layoutId("bottomBox"))
        BottomItems(modifier = Modifier.layoutId("bottomItems"), currentScreen){ screen ->
            onItemClicked(screen)
        }
        MiddleItems(modifier = Modifier.layoutId("middleItems"),currentScreen){ screen ->
            onItemClicked(screen)
        }
        AccountInfo(modifier = Modifier.layoutId("accountInfo"))
        TopBox(modifier = Modifier.layoutId("topBox"))

    }
}