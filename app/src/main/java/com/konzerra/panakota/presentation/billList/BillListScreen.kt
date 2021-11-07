package com.konzerra.panakota.presentation.billList

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
import com.konzerra.panakota.presentation.billList.components.BillListView
import com.konzerra.panakota.presentation.common_components.topbars.TopBarSearch
import com.konzerra.panakota.presentation.common_components.Triangle
import com.konzerra.panakota.presentation.common_components.convocations_view.ConvocationsView

import com.konzerra.panakota.presentation.navigation.Screen


@Composable
fun BillListScreen(
    navController: NavController,
    openDrawer: (Unit) -> Unit,
    viewModel: BillListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    val constraints = setConstraints() //see at the end
    ConstraintLayout(constraints) {
        BillListView(
            modifier = Modifier.layoutId("itemsView"),
            bills = state.bills,
            onItemClicked = { billId->
                navController.navigate(Screen.BillScreen.withArgs(billId))
            })
        ConvocationsView(modifier = Modifier.layoutId("convocationsView"))
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
        text = stringResource(id = R.string.filter_by_convocations),
        modifier = modifier.padding(top = 16.dp, start = 16.dp)
    )
}

//constraints
private fun setConstraints():ConstraintSet{
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val topTriangle = createRefFor("topTriangle")
        val tvSort = createRefFor("tvSort")
        val convocationsView = createRefFor("convocationsView")
        val itemsView = createRefFor("itemsView")
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
        constrain(convocationsView) {
            top.linkTo(tvSort.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(itemsView) {
            top.linkTo(convocationsView.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    return constraints
}