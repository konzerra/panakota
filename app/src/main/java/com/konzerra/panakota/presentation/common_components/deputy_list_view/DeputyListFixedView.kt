package com.konzerra.panakota.presentation.bill.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Deputy
import com.konzerra.panakota.presentation.common_components.deputy_list_view.DeputyItem


@Composable
fun DeputyListFixedView(
    modifier: Modifier,
    screenHeight:Dp,
    list:List<Deputy>,
    onItemClicked:(Unit)->Unit,
){
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
            .height(screenHeight - 40.dp)
    ){
        itemsIndexed(list){ index, item ->
            DeputyItem(deputy = item)
        }
    }
}