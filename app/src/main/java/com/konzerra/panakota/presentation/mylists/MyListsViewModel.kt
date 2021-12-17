package com.konzerra.panakota.presentation.mylists

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.model.Deputy
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyListsViewModel @Inject constructor(
): ViewModel() {
    private val _state = mutableStateOf(MyListsState())
    val state : State<MyListsState> = _state
    private val _currentTab = mutableStateOf(0)
    val currentTab : State<Int> = _currentTab

    fun setCurrentTab(index:Int){
        _currentTab.value = index
    }
    init{
        _state.value= MyListsState(list = listOf(
            Deputy(
                active = true,
                name = "Dastan Bekeshev",
                date = "18.12.1967",
                url = "youtube.com/konzerra"
            ),
            Deputy(
                active = true,
                name = "Ruslan",
                date = "18.12.1967",
                url = "youtube.com/konzerra"
            )
        ))
    }
}