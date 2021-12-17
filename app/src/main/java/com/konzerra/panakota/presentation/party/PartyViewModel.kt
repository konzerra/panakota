package com.konzerra.panakota.presentation.party

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.domain.usecase.GetBillUseCase
import com.konzerra.panakota.presentation.bill.BillState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PartyViewModel @Inject constructor(
    private val getBillUseCase: GetBillUseCase,

): ViewModel(){
    private val _state = mutableStateOf(PartyScreenState())
    val state : State<PartyScreenState> = _state
    private val _currentTab = mutableStateOf(0)
    val currentTab : State<Int> = _currentTab

    fun setCurrentTab(index:Int){
        _currentTab.value = index
    }
    init{
        _state.value = PartyScreenState(
            false,
            Party(
                name = "Биримдик",
                date = "22/01/2002",
                id = "34",
                ideology = "евразийство, социализм, демократия и парламентаризм",
                leader = "Сооронбай Жеенбеков"
            )
        )
    }
}