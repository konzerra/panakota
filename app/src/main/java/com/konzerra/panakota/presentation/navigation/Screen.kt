package com.konzerra.panakota.presentation.navigation

sealed class Screen(val route:String){
    object BillScreen : Screen("bill_screen")
    object BillListScreen : Screen("bill_list_screen")

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}
