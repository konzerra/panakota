package com.konzerra.panakota.presentation.partylist

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konzerra.panakota.common.Resource
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.domain.usecase.GetPartyListUseCase
import com.konzerra.panakota.presentation.billList.BillListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class PartyListViewModel @Inject constructor(
    private val getPartyListUseCase: GetPartyListUseCase
): ViewModel(){
    private val _state = mutableStateOf(PartyListState())
    val state : State<PartyListState> = _state

    init{
        val party1= Party(
            "Биримдик",
            "12/12/2012",
            "34643",
        )
        val list = listOf(party1)
        _state.value=PartyListState(partyList= list)

    }

    private fun getPartyList(){
        getPartyListUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = PartyListState(partyList = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = PartyListState(error = result.message ?:
                    "An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value = PartyListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}