package com.konzerra.panakota.presentation.billList.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.presentation.common_components.BillItem

@Composable
fun BillListView(
    modifier: Modifier,
    bills:List<DetailedBill>,
    onItemClicked: (String) -> Unit
){
    LazyColumn(modifier = modifier
        .padding(top = 16.dp)
    ){
        itemsIndexed( bills ){ index, bill ->
            BillItem(bill = bill, onItemClick = {
                onItemClicked(it)
            })
        }
    }
}