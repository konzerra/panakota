package com.konzerra.panakota.presentation.home

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.presentation.commoncomponents.TopBarText
import com.konzerra.panakota.presentation.commoncomponents.Triangle

@Composable
fun HomeScreen(){
    val constraints = setConstraints()
    ConstraintLayout(constraints) {
        TopBarText(
            modifier = Modifier.layoutId("topBar"),
            title = "Panakota"
        )
        Triangle(modifier = Modifier.layoutId("triangle"))

    }
}

private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val triangle = createRefFor("triangle")

        constrain(topBar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(triangle) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

    }
    return constraints
}