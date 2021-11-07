package com.konzerra.panakota.presentation.common_components.tabs

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.ui.theme.Gray300
import com.konzerra.panakota.ui.theme.PurpleDark
import com.konzerra.panakota.ui.theme.White
import com.konzerra.panakota.ui.theme.Wood500

@Composable
fun CustomTab(
    modifier: Modifier,
    tabText: String,
    currentTab: Int,
    tabId: Int,
    updateCurrentTab : (Int) -> Unit
){
    Box(
        modifier = modifier
            .clip(shape = RoundedCornerShape(4.dp))
            .background(if (currentTab == tabId) Wood500 else Gray300)
            .clickable {
                updateCurrentTab(tabId)
            })
    {
        Text(
            text = tabText,
            color = if (currentTab == tabId) White else PurpleDark,
            modifier = Modifier
                .padding(top = 7.dp, bottom = 10.dp)
                .align(alignment = Alignment.Center)
        )
    }
}
