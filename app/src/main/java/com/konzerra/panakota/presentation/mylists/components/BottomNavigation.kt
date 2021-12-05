package com.konzerra.panakota.presentation.mylists.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.ui.theme.BlackBasic
import com.konzerra.panakota.ui.theme.Gray500

@Composable
fun MyListsBottomNavigation(
    modifier: Modifier,
    currentTab:Int,
    updateCurrentTab : (Int) -> Unit
){
    Row(modifier = modifier
        .fillMaxWidth()
        .height(56.dp)
    ){
        Box(modifier = Modifier
            .fillMaxSize()
            .background(BlackBasic)
            .clickable {
                updateCurrentTab(0)
            },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "My list",
                style = if(currentTab == 0 )
                    TextStyle(textDecoration = TextDecoration.Underline)
                else
                    TextStyle(textDecoration = TextDecoration.LineThrough)
            )
        }
        Box(modifier = Modifier
            .fillMaxSize()
            .background(BlackBasic)
            .clickable {
                updateCurrentTab(1)
            },
            contentAlignment = Alignment.Center
        )  {
            Text(
                text = "My anti-list",
                style = if(currentTab == 1 )
                            TextStyle(textDecoration = TextDecoration.Underline)
                        else
                            TextStyle(textDecoration = TextDecoration.LineThrough)
            )
        }
    }
}