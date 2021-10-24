package com.konzerra.panakota

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.rememberNavController
import com.konzerra.panakota.presentation.navigation.Drawer
import com.konzerra.panakota.presentation.navigation.Navigation
import com.konzerra.panakota.ui.theme.PanakotaTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val sharedViewModel: SharedViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val scaffoldState = rememberScaffoldState()
            val navController = rememberNavController()
            val coroutineScope = rememberCoroutineScope()
            PanakotaTheme {
                Surface(color = MaterialTheme.colors.background) {
                    Scaffold(
                        scaffoldState = scaffoldState,
                        drawerContent = {
                            Drawer(
                                currentScreen = sharedViewModel.currentScreen.value,
                                onItemClicked = {  screenRoute ->
                                    navController.navigate(screenRoute)
                                    coroutineScope.launch {
                                        scaffoldState.drawerState.close()
                                    }
                                }
                            )
                        },
                    ) {
                        Navigation(
                            navController,
                            openDrawer = {
                                coroutineScope.launch {
                                    scaffoldState.drawerState.open()
                                }
                            }
                        )
                    }
                }
            }
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
    }
}







