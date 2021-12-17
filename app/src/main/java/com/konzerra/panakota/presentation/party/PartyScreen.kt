package com.konzerra.panakota.presentation.party

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
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
import com.konzerra.panakota.presentation.bill.components.DeputyListFixedView
import com.konzerra.panakota.presentation.common_components.Triangle
import com.konzerra.panakota.presentation.common_components.buttons.ButtonBottom
import com.konzerra.panakota.presentation.common_components.elections_view.ElectionsView
import com.konzerra.panakota.presentation.common_components.topbars.TopBarSearch
import com.konzerra.panakota.presentation.party.components.TabsPartyScreen
import com.konzerra.panakota.presentation.partylist.components.DetailedPartyView
import com.konzerra.panakota.ui.theme.Wood700

@Composable
fun PartyScreen(
    party: String,
    openDrawer: (Unit) -> Unit,
    viewModel: PartyViewModel = hiltViewModel(),

    ){

    val state = viewModel.state.value
    val constraints = setConstraints()
    val screenHeight = remember{
        mutableStateOf(0.dp)
    }
    val density = LocalDensity.current.density
    state.party?.let{
        ConstraintLayout(
            constraints,
            modifier = Modifier
                .fillMaxSize()
                .onGloballyPositioned {
                    screenHeight.value = it.size.height.dp / density
                }
        ) {
            LazyColumn(modifier = Modifier
                .layoutId("deputyListView")
                .fillMaxSize()

            ) {
                item{
                    DetailedPartyView(
                        modifier= Modifier.padding(16.dp),
                        party = state.party
                    )
                    Box(modifier = Modifier
                        .padding(top = 4.dp, start = 8.dp, end = 8.dp)
                        .height(4.dp)
                        .fillMaxWidth()
                        .background(Wood700)
                    )
                    Text(
                        text = "Sort by elections",
                        modifier = Modifier.padding(start = 16.dp, top = 10.dp, bottom = 10.dp)
                    )
                    ElectionsView(modifier = Modifier.padding(start = 16.dp, end = 16.dp, bottom = 10.dp))
                    TabsPartyScreen(
                        modifier = Modifier
                            .padding(start = 16.dp, end = 16.dp)
                        ,
                        currentTab = viewModel.currentTab.value,
                        updateCurrentTab = {
                            viewModel.setCurrentTab(it)
                            Log.w("currentTab", "Now!")
                        })
                    DeputyListFixedView(
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
            TopBarSearch(
                modifier = Modifier.layoutId("topBar"),
                searchTitle = "Search in list",
                onMenuClicked = {
                    openDrawer(Unit)
                },
                onSearchRequest = {

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
    if(state.isLoading){
        Text(
            text = "Loading",
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
