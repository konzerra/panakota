package com.konzerra.panakota

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.usecase.GetBillUseCase
import com.konzerra.panakota.presentation.navigation.Screen
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class SharedViewModel @Inject constructor(): ViewModel(){
    private val _currentScreen = mutableStateOf<Screen>(Screen.HomeScreen)
    val currentScreen : State<Screen> = _currentScreen
    fun setCurrentScreen(screen:Screen){
        _currentScreen.value = screen
    }
}