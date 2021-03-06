package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.ui.theme.Wood500
import com.konzerra.panakota.ui.theme.White
import com.konzerra.panakota.ui.theme.Wood700

@Composable
fun DrawerItemList(
    modifier: Modifier,
    currentScreen: String,
    onItemClicked: (String) -> Unit,
) {
    Card(
        modifier = modifier
            .fillMaxSize(),
        elevation = 4.dp,
        shape = RoundedCornerShape(0.dp)
    ) {
        Box(modifier =  modifier
            .background(White)
            .fillMaxSize(),
        ) {
            Box(
                modifier = Modifier
                    .width(52.dp)
                    .padding(top = 4.dp)
                    .fillMaxHeight()
                    .background(Wood500)
            )
            LazyColumn(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxSize()
            ) {
                item {
                    DrawerItem(
                        thisScreen = Screen.HomeScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.BillListScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.PartyListScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.MyListsScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.DeputyListScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.ElectionListScreen,
                        currentScreen = currentScreen,
                        onClick = { screen ->
                            onItemClicked(screen)
                        }
                    )
                    Spacer(
                        modifier = Modifier
                            .padding(start = 58.dp, end = 6.dp, bottom = 8.dp,)
                            .fillMaxWidth()
                            .height(4.dp)
                            .background(Wood700)
                    )
                    DrawerItem(
                        thisScreen = Screen.SettingsScreen,
                        currentScreen = currentScreen,
                        onClick = { screenRoute ->
                            onItemClicked(screenRoute)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.AboutUsScreen,
                        currentScreen = currentScreen,
                        onClick = { screenRoute ->
                            onItemClicked(screenRoute)
                        }
                    )
                    DrawerItem(
                        thisScreen = Screen.HelpScreen,
                        currentScreen = currentScreen,
                        onClick = { screenRoute ->
                            onItemClicked(screenRoute)
                        }
                    )
                }
            }
        }
    }
}