package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.presentation.navigation.components.DrawerItem

@Composable
fun MiddleItems(
    modifier: Modifier,
    currentScreen: String,
    onItemClicked: (String) -> Unit,
){
    LazyColumn(modifier = modifier
        .fillMaxSize()){
        item {
            DrawerItem(
                thisScreen = Screen.HomeScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.BillListScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.PartyListScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.ListScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.DeputyListScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.ElectionListScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
        }
    }
}