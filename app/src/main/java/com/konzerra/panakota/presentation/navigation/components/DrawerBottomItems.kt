package com.konzerra.panakota.presentation.navigation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.presentation.navigation.Screen
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.Blue700


@Composable
fun BottomItems(
    modifier: Modifier,
    currentScreen: Screen,
    onItemClicked: (Screen) -> Unit,
){


    Card(modifier = modifier,
        elevation = 4.dp,
        shape = RoundedCornerShape(0.dp)
    ){
        Column(modifier = Modifier
            .background(Blue500)) {
            Spacer(modifier = Modifier
                .padding(start = 6.dp, end = 6.dp, bottom = 5.dp)
                .fillMaxWidth()
                .height(4.dp)
                .background(Blue700)
            )
            DrawerItem(
                thisScreen = Screen.SettingsScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.AboutUsScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            DrawerItem(
                thisScreen = Screen.HelpScreen,
                currentScreen = currentScreen,
                onClick = { screen->
                    onItemClicked(screen)
                }
            )
            Spacer(modifier = Modifier
                .height(50.dp)

            )
        }
    }
}
