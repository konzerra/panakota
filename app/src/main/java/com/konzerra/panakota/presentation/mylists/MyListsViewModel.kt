package com.konzerra.panakota.presentation.mylists

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.presentation.bill.BillState
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

}