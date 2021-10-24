package com.konzerra.panakota.presentation.bill.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.konzerra.panakota.domain.model.Deputy
import com.konzerra.panakota.presentation.common_components.DeputyItem


@Composable
fun DeputyListView(
    modifier: Modifier,
    list:List<Deputy>
){
    LazyColumn(
        modifier = modifier
            .fillMaxSize(),
    ){
        itemsIndexed(list){ index, item ->
            DeputyItem(deputy = item)
        }
    }
}