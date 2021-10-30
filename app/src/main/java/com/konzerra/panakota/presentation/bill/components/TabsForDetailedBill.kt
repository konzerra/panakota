package com.konzerra.panakota.presentation.bill.components



import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.R
import com.konzerra.panakota.ui.theme.*


@Composable
fun BillTabs(
    modifier: Modifier,
    currentTab:Int,
    updateCurrentTab : (Int) -> Unit
){
    val constraints = setConstraints()

    ConstraintLayout(constraints,
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 16.dp)
            .clip(shape = RoundedCornerShape(4.dp))
            .background(Gray300)
    ) {
        Tab(modifier = Modifier
            .layoutId("btInitiators"),
            currentTab = currentTab,
            tabId = 0,
            tabText = stringResource(id = R.string.initiators),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )
        Tab(modifier = Modifier
            .layoutId("btFor"),
            currentTab = currentTab,
            tabId = 1,
            tabText = stringResource(id = R.string.yes),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )
        Tab(modifier = Modifier
            .layoutId("btAgainst"),
            currentTab = currentTab,
            tabId = 2,
            tabText = stringResource(id = R.string.no),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )
        Tab(modifier = Modifier
            .layoutId("btAbsent"),
            currentTab = currentTab,
            tabId = 3,
            tabText = stringResource(id = R.string.absent),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )
    }
}

@Composable
private fun Tab(
    modifier: Modifier,
    tabText: String,
    currentTab: Int,
    tabId: Int,
    updateCurrentTab : (Int) -> Unit
){
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(if (currentTab == tabId) Wood500 else Gray300)
            .clickable {
                updateCurrentTab(tabId)
            })
    {
        Text(
            text = tabText,
            color = if (currentTab == tabId) White else PurpleDark,
            modifier = Modifier
                .padding(top = 7.dp, bottom = 10.dp)
                .align(alignment = Alignment.Center)
        )
    }
}
private fun setConstraints():ConstraintSet{
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
    return constraints
}