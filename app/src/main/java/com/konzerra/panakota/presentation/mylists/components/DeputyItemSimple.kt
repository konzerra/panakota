package com.konzerra.panakota.presentation.mylists.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.domain.model.Deputy
import com.konzerra.panakota.ui.theme.Gray300
import com.konzerra.panakota.ui.theme.Wood100
import com.konzerra.panakota.ui.theme.Wood700

@Composable
fun DeputyItemSimple(
    deputy: Deputy,
){
    val constraints = setConstraints()

    ConstraintLayout(
        constraints,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp)
            .fillMaxWidth()

    ) {
        Box(modifier = Modifier
            .layoutId("mainBox")
            .padding(top = 10.dp)
            .fillMaxWidth()
            .fillMaxHeight()
            .background(Gray300),
            contentAlignment = Alignment.CenterStart
        ){
            Box(modifier = Modifier
                .width(6.dp)
                .fillMaxHeight()
                .background(Wood700)
            )
        }
        Text(
            modifier = Modifier
                .layoutId("tvName")
                .padding(start = 22.dp, top = 24.dp),
            text = deputy.name
        )
        Text(
            modifier = Modifier
                .layoutId("tvDate")
                .padding(start = 22.dp, top = 12.dp, bottom = 16.dp),
            text = deputy.date
        )

    }
}
//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val mainBox = createRefFor("mainBox")
        val tvName = createRefFor("tvName")
        val tvDate = createRefFor("tvDate")
        val buttonAdd = createRefFor("buttonAdd")
        constrain(mainBox) {
            top.linkTo(parent.top)
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
        constrain(tvName) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvDate) {
            top.linkTo(tvName.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(buttonAdd) {
            bottom.linkTo(parent.bottom)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

    }
    return constraints
}
