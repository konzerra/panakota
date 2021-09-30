package com.konzerra.panakota.presentation.billList

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.konzerra.panakota.R
import com.konzerra.panakota.domain.model.Convocation
import com.konzerra.panakota.presentation.commoncomponents.BillItem
import com.konzerra.panakota.presentation.commoncomponents.ConvocationItem
import com.konzerra.panakota.presentation.commoncomponents.TopBarSearch
import com.konzerra.panakota.presentation.navigation.Screen


@Composable
fun BillListScreen(
    navController: NavController,
    viewModel: BillListViewModel = hiltViewModel()
){
    val state = viewModel.state.value
    Column {
        TopBarSearch( contentDescription = "icon", searchTitle = "Search")
        TextFilter()

        LazyRow(modifier = Modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)){
            itemsIndexed(
                listOf(
                    Convocation("VI созыв", "", ""),
                    Convocation("V созыв", "", ""),
                    Convocation("IV созыв", "", ""),
                )
            ){ index, item ->
                ConvocationItem(item)
            }
        }

        LazyColumn(modifier = Modifier.padding(top = 16.dp)){
            itemsIndexed( state.bills ){ index, bill ->
                BillItem(bill = bill, onItemClick = {
                    navController.navigate(Screen.BillScreen.withArgs(bill.id))
                })
            }
        }
    }
}

@Composable
fun HorizontalScroll(){

}
@Composable
fun VerticalScroll(){

}
@Composable
fun TextFilter(){
    Text(
        text = stringResource(id = R.string.filter_by_convocations),
        modifier = Modifier.padding(top = 16.dp, start = 16.dp)
    )
}