package com.konzerra.panakota.presentation.party

import android.util.Log
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.presentation.bill.BillViewModel
import com.konzerra.panakota.presentation.bill.components.BillTabs
import com.konzerra.panakota.presentation.bill.components.DeputyListView
import com.konzerra.panakota.presentation.bill.components.DetailedBillCompose
import com.konzerra.panakota.presentation.common_components.Triangle
import com.konzerra.panakota.presentation.common_components.buttons.ButtonBottom
import com.konzerra.panakota.presentation.common_components.topbars.TopBarText

@Composable
fun BillScreen(
    party: Party,
    openDrawer: (Unit) -> Unit,
    viewModel: BillViewModel = hiltViewModel(),

    ){

    val state = viewModel.state.value
    val constraints = setConstraints()
    val screenHeight = remember{
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current.density
    state.bill?.let{
        ConstraintLayout(
            constraints,
            modifier = Modifier.fillMaxSize()
        ) {
            LazyColumn(modifier = Modifier
                .layoutId("deputyListView")
                .fillMaxSize()
                .onGloballyPositioned {
                    screenHeight.value = it.size.height.dp / density
                }
            ) {
                item{
                    DetailedBillCompose(
                        modifier = Modifier,
                        bill = state.bill
                    )
                    BillTabs(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                        ,
                        currentTab = viewModel.currentTab.value,
                        updateCurrentTab = {
                            viewModel.setCurrentTab(it)
                            Log.w("currentTab", "Now!")
                        })
                    DeputyListView(
                        modifier = Modifier,
                        screenHeight = screenHeight.value,
                        list = emptyList() ,
                        onItemClicked = {})
                }

            }
            ButtonBottom(modifier = Modifier
                .layoutId("buttonAddAll"),
                text = "Add All",
                onClicked = {

                })
            TopBarText(
                modifier = Modifier.layoutId("topBar"),
                title = "Bill",
                onMenuClicked = {
                    openDrawer(Unit)
                }
            )
            Triangle(modifier = Modifier.layoutId("topTriangle"))

        }

    }
    if(state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        )
    }
}
//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val topTriangle = createRefFor("topTriangle")
        val deputyListView = createRefFor("deputyListView")
        val buttonAddAll = createRefFor("buttonAddAll")
        constrain(topTriangle) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(topBar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(buttonAddAll) {
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(deputyListView) {
            top.linkTo(topBar.bottom)
            bottom.linkTo(buttonAddAll.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
    return constraints
}
