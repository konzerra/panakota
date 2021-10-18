package com.konzerra.panakota

import android.os.Bundle
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.konzerra.panakota.domain.usecase.GetBillUseCase
import com.konzerra.panakota.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel(){
    private val _currentScreen = mutableStateOf<String>("home_screen")
    val currentScreen : State<String> = _currentScreen
    private val _navControllerState = mutableStateOf<Bundle>(Bundle.EMPTY)
    val navControllerState : State<Bundle> = _navControllerState

    fun saveNavControllerState(state: Bundle){
        _navControllerState.value = state
    }
    fun setCurrentScreen(screenRoute:String){
        _currentScreen.value = screenRoute
    }
}