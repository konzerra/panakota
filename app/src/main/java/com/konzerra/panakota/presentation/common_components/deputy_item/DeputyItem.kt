package com.konzerra.panakota.presentation.common_components

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
fun DeputyItem(
    deputy: Deputy,
){
    val constraints = setConstraints()

    ConstraintLayout(
        constraints,
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp)
    ) {
        Box(modifier = Modifier
            .layoutId("mainBox")
            .padding(top = 10.dp)
            .fillMaxWidth()
            .height(IntrinsicSize.Max)
            .background(Gray300)
        ){
            Box(modifier = Modifier
                .width(6.dp)
                .height(IntrinsicSize.Max)
                .background(Wood700)
            )
        }
        Text(
            modifier = Modifier
                .layoutId("tvName")
                .padding(start = 22.dp, top = 16.dp),
            text = deputy.name
        )
        Text(
            modifier = Modifier
                .layoutId("tvDate")
                .padding(start = 22.dp, top = 12.dp),
            text = deputy.date
        )
        Box(modifier = Modifier
            .layoutId("buttonAdd")
            .padding(start = 8.dp, end = 8.dp, bottom = 8.dp)
            .height(44.dp)
            .width(120.dp)
            .border(BorderStroke(2.dp, Wood700))
            .background(Wood100),
            contentAlignment = Alignment.CenterStart
        ) {
            Text(
                text = "to My list"
            )
        }
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
            start.linkTo(parent.start)
            end.linkTo(buttonAdd.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(tvName) {
            top.linkTo(mainBox.bottom)
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
            bottom.linkTo(mainBox.bottom)
            end.linkTo(mainBox.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

    }
    return constraints
}
