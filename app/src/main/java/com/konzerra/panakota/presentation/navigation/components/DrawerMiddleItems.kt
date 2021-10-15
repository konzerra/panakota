package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.presentation.navigation.components.DrawerItem

@Composable
fun MiddleItems(modifier: Modifier){
    LazyColumn(modifier = modifier
        .fillMaxSize()){
        item {
            //DrawerItem(Screen.BillListScreen)
        }
    }
}