package com.konzerra.panakota.presentation.commoncomponents

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.remember

import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Tab
import com.konzerra.panakota.ui.theme.Blue500

@Composable
fun CustomTabs(list: List<String>,
               currentTab: Int,
               updateState : (Int) -> Unit){
    val size = remember { mutableStateOf(IntSize.Zero) }
    Row(horizontalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
        .padding(start = 16.dp, end = 16.dp)
        .fillMaxWidth()
        .onSizeChanged {
            size.value = it }
        .background(Blue500))
        {
        list.forEachIndexed { index, name ->
            Log.w("Size", size.value.width.toString())
            val tab = Tab(name, index)
            TabCompose(
                tab,
                size.value.width.dp/4,
                updateState = { currentTab->
                updateState(currentTab)
                Log.d("CurrentTab1", currentTab.toString())
            } )

        }
    }
}

@Composable
private fun TabCompose(tab:Tab,
                       sizeForTab: Dp,
                       updateState : (Int) -> Unit,
                       ){
    Box(
        modifier = Modifier
            .background(Blue500)
            .width(sizeForTab)
            .clickable {
            updateState(tab.index)
        }
    ){
        Text(
            text = tab.name,
            style = MaterialTheme.typography.body1,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .padding(top = 10.dp, bottom = 10.dp)

        )
    }
}