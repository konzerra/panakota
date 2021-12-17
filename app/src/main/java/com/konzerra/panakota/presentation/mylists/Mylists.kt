package com.konzerra.panakota.presentation.mylists

import androidx.compose.foundation.layout.fillMaxSize
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
import com.konzerra.panakota.R
import com.konzerra.panakota.presentation.common_components.Triangle
import com.konzerra.panakota.presentation.common_components.topbars.TopBarSearch
import com.konzerra.panakota.presentation.mylists.components.DeputyListView
import com.konzerra.panakota.presentation.mylists.components.MyListsBottomNavigation


@Composable
fun MyListsScreen(
    openDrawer: (Unit) -> Unit,
    viewModel: MyListsViewModel = hiltViewModel(),
)
{
    val state = viewModel.state.value
    val constraints = setConstraints() //see at the end
    if(state.list.isNotEmpty()){
        ConstraintLayout(
            modifier = Modifier.fillMaxSize(),
            constraintSet = constraints
        ) {
            DeputyListView(modifier = Modifier.layoutId("deputyListView"),
                list = state.list,
                onItemClicked = {

                })
            MyListsBottomNavigation(modifier = Modifier.layoutId("bottomNavigation"),
                currentTab = viewModel.currentTab.value,
                updateCurrentTab = {
                    viewModel.setCurrentTab(it)
                })
            TextTotal(
                modifier = Modifier.layoutId("tvTotal"),
                number = state.list.size
            )
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
    if(state.isLoading){

    }
    if(state.error.isNotBlank()){

    }
}

}
@Composable
fun TextTotal(
        modifier: Modifier,
        number: Int,
    ){
    Text(
        text = stringResource(id = R.string.total)+": $number",
        modifier = modifier.padding(top = 16.dp, start = 16.dp)
    )
}

//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val topBar = createRefFor("topBar")
        val topTriangle = createRefFor("topTriangle")
        val tvTotal = createRefFor("tvTotal")
        val bottomNavigation = createRefFor("bottomNavigation")
        val deputyListView = createRefFor("deputyListView")
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
        constrain(tvTotal) {
            top.linkTo(topBar.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(bottomNavigation){
            bottom.linkTo(parent.bottom)
            start.linkTo(parent.start)

            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(deputyListView){
            top.linkTo(tvTotal.bottom)
            bottom.linkTo(bottomNavigation.top)
            start.linkTo(parent.start)
            end.linkTo(parent.end)
            width = Dimension.fillToConstraints
            height = Dimension.fillToConstraints
        }
    }
    return constraints
}