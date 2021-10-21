package com.konzerra.panakota.presentation.bill.components



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.Blue700


@Composable
fun BillTabs(
    modifier: Modifier,
    updateState : (Int) -> Unit){
    val constraints = ConstraintSet{
        val btInitiators = createRefFor("btInitiators")
        val btFor = createRefFor("btFor")
        val btAgainst = createRefFor("btAgainst")
        val btAbsent = createRefFor("btAbsent")

        constrain(btInitiators){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(btFor.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(btFor){
            top.linkTo(parent.top)
            start.linkTo(btInitiators.end)
            end.linkTo(btAgainst.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(btAgainst){
            top.linkTo(parent.top)
            start.linkTo(btFor.end)
            end.linkTo(btAbsent.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(btAbsent){
            top.linkTo(parent.top)
            start.linkTo(btAgainst.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
    }
    val currentTab = remember { mutableStateOf(0)}
    updateState(currentTab.value)
    ConstraintLayout(constraints,
        modifier = modifier
            .fillMaxWidth()
            .padding( top = 16.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .background(Blue500)
    ) {

        Box(modifier = Modifier
            .layoutId("btInitiators")
            .clip(shape = RoundedCornerShape(4.dp))
            .background(if (currentTab.value == 0 ) Blue700 else Blue500)
            .clickable{
                currentTab.value=0
            }){
            Text(text = "Lolol",
                modifier = Modifier
                    .padding(top = 7.dp, bottom = 10.dp)
                    .align(alignment = Alignment.Center))
        }
        Box(modifier = Modifier
            .layoutId("btFor")
            .clip(shape = RoundedCornerShape(4.dp))
            .background(if (currentTab.value == 1 ) Blue700 else Blue500)
            .clickable{
                currentTab.value=1
            }){
            Text(text = "Lolol",
                modifier = Modifier
                    .padding(top = 7.dp, bottom = 10.dp)
                    .align(alignment = Alignment.Center))
        }
        Box(modifier = Modifier
            .layoutId("btAgainst")
            .clip(shape = RoundedCornerShape(4.dp))
            .background(if (currentTab.value == 2 ) Blue700 else Blue500)
            .clickable{
                currentTab.value=2
            }){
            Text(text = "Lolol76787",
                modifier = Modifier
                    .padding(top = 7.dp, bottom = 10.dp)
                    .align(alignment = Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .layoutId("btAbsent")
                .clip(shape = RoundedCornerShape(4.dp))
                .background(if (currentTab.value == 3 ) Blue700 else Blue500)
                .clickable{
                    currentTab.value=3
                })
        {
            Text(
                text = "Absent",
                modifier = Modifier
                    .padding(top = 7.dp, bottom = 10.dp)
                    .align(alignment = Alignment.Center)
            )
        }

    }
}