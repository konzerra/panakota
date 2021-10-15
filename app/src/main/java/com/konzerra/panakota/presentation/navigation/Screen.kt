package com.konzerra.panakota.presentation.navigation

import com.konzerra.panakota.R


sealed class Screen(
    val route:String,
    val stringResource: Int,
    val drawableResource: Int,
){
    object HomeScreen : Screen(
        "home_screen",
        R.string.home,
        R.drawable.ic_home
    )
    object BillScreen : Screen(
        "bill_screen",
        R.string.bill,
        R.drawable.ic_bill
    )
    object BillListScreen : Screen(
        "bill_list_screen",
        R.string.bills,
        R.drawable.ic_bill,
    )
    object PartyScreen : Screen(
        "party_screen",
        R.string.party,
        R.drawable.ic_party
    )
    object PartyListScreen : Screen(
        "party_list_screen",
        R.string.parties,
        R.drawable.ic_party
    )
    object ListScreen : Screen(
        "list_screen",
        R.string.my_lists,
        R.drawable.ic_list
    )
    object DeputyScreen : Screen(
        "deputy_screen",
        R.string.deputy,
        R.drawable.ic_deputy
    )
    object DeputyListScreen : Screen(
        "deputy_list_screen",
        R.string.deputies,
        R.drawable.ic_deputy
    )
    object ElectionScreen : Screen(
        "election_screen",
        R.string.election,
        R.drawable.ic_elections
    )
    object ElectionListScreen : Screen(
        "election_list_screen",
        R.string.elections,
        R.drawable.ic_elections
    )
    object SettingsScreen : Screen(
        "settings_screen",
        R.string.settings,
        R.drawable.ic_settings
    )
    object HelpScreen : Screen(
        "help_screen",
        R.string.help,
        R.drawable.ic_help,
    )
    object AboutUsScreen : Screen(
        "about_us_screen",
        R.string.about_us,
        R.drawable.ic_about
    )

    fun withArgs(vararg args:String):String{
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}

