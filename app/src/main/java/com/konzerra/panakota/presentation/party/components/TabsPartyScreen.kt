package com.konzerra.panakota.presentation.party.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.R
import com.konzerra.panakota.presentation.common_components.tabs.CustomTab
import com.konzerra.panakota.ui.theme.Gray300

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

        CustomTab(modifier = Modifier
            .layoutId("tabCandidates"),
            currentTab = currentTab,
            tabId = 0,
            tabText = stringResource(id = R.string.candidates),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )
        CustomTab(modifier = Modifier
            .layoutId("tabLeaders"),
            currentTab = currentTab,
            tabId = 1,
            tabText = stringResource(id = R.string.leaders),
            updateCurrentTab = {
                updateCurrentTab(it)
            }
        )

    }
}

private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet{
        val tabCandidates = createRefFor("tabCandidates")
        val tabLeaders = createRefFor("tabLeaders")
        constrain(tabCandidates){
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(tabLeaders.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(tabLeaders){
            top.linkTo(parent.top)
            start.linkTo(tabCandidates.end)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }

    }
    return constraints
}