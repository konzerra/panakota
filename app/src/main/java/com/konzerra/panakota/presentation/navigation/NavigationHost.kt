package com.konzerra.panakota.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.konzerra.panakota.SharedViewModel
import com.konzerra.panakota.presentation.bill.BillScreen
import com.konzerra.panakota.presentation.billList.BillListScreen
import com.konzerra.panakota.presentation.home.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController
){
    val sharedViewModel:SharedViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination =  navController.currentDestination?.route ?: Screen.HomeScreen.route ,
    ){
        composable(
            route = Screen.BillScreen.route+"/{billId}",
            arguments = listOf(
                navArgument(name = "billId"){
                    type = NavType.StringType
                    defaultValue = "Nothing"
                }
            )
        ){ entry ->
            sharedViewModel.setCurrentScreen(Screen.BillScreen.route)
            BillScreen(billId = entry.arguments?.getString("billId") ?: "Nothing")
        }

        composable(
            route = Screen.BillListScreen.route
        ){
            sharedViewModel.setCurrentScreen(Screen.BillListScreen.route)
            BillListScreen(navController)
        }
        composable(
            route = Screen.HomeScreen.route
        ){
            sharedViewModel.setCurrentScreen(Screen.HomeScreen.route)
            HomeScreen()
        }

    }
}