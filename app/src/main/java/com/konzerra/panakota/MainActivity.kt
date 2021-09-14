package com.konzerra.panakota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

import com.konzerra.panakota.presentation.commoncomponents.TopBarSearch
import com.konzerra.panakota.presentation.navigation.NavDrawer
import com.konzerra.panakota.presentation.navigation.Navigation
import com.konzerra.panakota.ui.theme.Blue700
import com.konzerra.panakota.ui.theme.PanakotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PanakotaTheme {
                Surface(color = MaterialTheme.colors.background) {
                   Navigation()
                }
            }
        }
    }
}




@Composable
fun Triangle(modifier: Modifier){
    Canvas(modifier = Modifier.fillMaxSize()) {
        val canvasQuadrantSize = size / 2F
        drawRect(
            color = Blue700,
            size = canvasQuadrantSize
        )
    }
}






@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    val state = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    PanakotaTheme {
        Scaffold(
            drawerContent = { NavDrawer() },
            content = {
                TopBarSearch(contentDescription = "", searchTitle = "Search")
            }
        )

    }
}