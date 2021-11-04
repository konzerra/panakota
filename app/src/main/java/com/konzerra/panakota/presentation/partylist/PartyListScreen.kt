package com.konzerra.panakota.presentation.partylist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.konzerra.panakota.R
import com.konzerra.panakota.presentation.common_components.TopBarSearch
import com.konzerra.panakota.presentation.common_components.Triangle
import com.konzerra.panakota.presentation.common_components.convocations_view.ConvocationsView
import com.konzerra.panakota.presentation.common_components.elections_view.ElectionsView
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.presentation.partylist.components.PartyListView

@Composable
fun PartyListScreen(
    navController: NavController,
    openDrawer: (Unit) -> Unit,
    viewModel: PartyListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val constraints = setConstraints() //see at the end
    ConstraintLayout(constraints) {
        PartyListView(
            modifier = Modifier.layoutId("partyListView"),
            partyList = state.partyList,
            onItemClicked = { party->
                navController.navigate(Screen.PartyScreen.route) //.withArgs(party)
            })
        ElectionsView(modifier = Modifier.layoutId("electionsView"))
        TextFilter(modifier = Modifier.layoutId("tvSort"))
        TopBarSearch(
            modifier = Modifier.layoutId("topBar"),
            searchTitle = "Search",
            onMenuClicked = {
                openDrawer(Unit)
            },
            onSearchRequest = {

            }
        )
        Triangle(modifier = Modifier.layoutId("topTriangle"))

    }

}
@Composable
fun TextFilter(modifier: Modifier){
    Text(
        text = stringResource(id = R.string.filter_by_elections),
        modifier = modifier.padding(top = 16.dp, start = 16.dp)
    )
}

//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val topTriangle = createRefFor("topTriangle")
        val tvSort = createRefFor("tvSort")
        val electionsView = createRefFor("electionsView")
        val partyListView = createRefFor("partyListView")
        constrain(topBar) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(topTriangle) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvSort) {
            top.linkTo(topBar.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(electionsView) {
            top.linkTo(tvSort.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(partyListView) {
            top.linkTo(electionsView.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    return constraints
}