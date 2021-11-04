package com.konzerra.panakota.presentation.common_components.elections_view

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Convocation
import com.konzerra.panakota.domain.model.Election
import com.konzerra.panakota.presentation.common_components.ConvocationItem

@Composable
fun ElectionsView(
    modifier: Modifier
){
    LazyRow(modifier = modifier.padding(start = 16.dp, top = 16.dp, end = 16.dp)){
        itemsIndexed(
            listOf(
                Election("Выборы в ЖК 2021"),
                Election("Выборы в ЖК 2020"),
            )
        ){ index, item ->
            ElectionItem(item)
        }
    }
}