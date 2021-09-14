package com.konzerra.panakota.presentation.bills

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
import com.konzerra.panakota.presentation.commoncomponents.BillItem
import com.konzerra.panakota.presentation.commoncomponents.Convocation
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

        LazyRow(modifier = Modifier.padding(top = 16.dp)){
            itemsIndexed(
                listOf( mapOf("name" to "VI созыв", "date" to "2015-2021"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"))
            ){ index, item ->
                Convocation(name = item["name"]!!, date = item["date"]!!)
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