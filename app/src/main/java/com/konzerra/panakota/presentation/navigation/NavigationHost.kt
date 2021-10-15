package com.konzerra.panakota.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.konzerra.panakota.presentation.bill.BillScreen
import com.konzerra.panakota.presentation.billList.BillListScreen
import com.konzerra.panakota.presentation.home.HomeScreen

@Composable
fun Navigation(
    navController: NavHostController
){
//
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
            BillScreen(billId = entry.arguments?.getString("billId") ?: "Nothing")
        }

        composable(
            route = Screen.BillListScreen.route
        ){
            BillListScreen(navController)
        }
        composable(
            route = Screen.HomeScreen.route
        ){
            HomeScreen()
        }

    }
}