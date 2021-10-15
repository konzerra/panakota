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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController

import com.konzerra.panakota.presentation.commoncomponents.TopBarSearch
import com.konzerra.panakota.presentation.navigation.Drawer

import com.konzerra.panakota.presentation.navigation.Navigation
import com.konzerra.panakota.ui.theme.Blue700
import com.konzerra.panakota.ui.theme.PanakotaTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            val sharedViewModel:SharedViewModel = hiltViewModel()
            val scaffoldState = rememberScaffoldState()
            PanakotaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Drawer(
                                currentScreen = sharedViewModel.currentScreen.value
                            ){ screen ->
                                sharedViewModel.setCurrentScreen(screen)
                                navController.navigate(screen.route)
                            }
                        }
                    ) {
                        Navigation(navController)
                    }
                }
            }
        }
    }
}







