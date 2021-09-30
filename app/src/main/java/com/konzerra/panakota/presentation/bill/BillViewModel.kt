package com.konzerra.panakota.presentation.bill

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konzerra.panakota.common.Resource
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.usecase.GetBillUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BillViewModel @Inject constructor(
    private val getBillUseCase: GetBillUseCase,

):ViewModel(){
    private var billId:String ="Nothing"
    private val _state = mutableStateOf(BillState())
    val state : State<BillState> = _state
    private val _currentTab = mutableStateOf(0)
    val currentTab : State<Int> = _currentTab

    fun setCurrentTab(index:Int){
        _currentTab.value = index
    }
    fun setBillId(billId:String){
        val bill = DetailedBill(
            "О защите от ложной и недостоверной информации",
            "12/08/2021",
            listOf("Айчурок Маратова", "Дастан Бекешев"),
            45,
            98,
            "https://youtu.be/dQw4w9WgXcQ",
            "128"
        )
        Log.d("setting bill", bill.name)
        this.billId =billId
        _state.value = BillState(bill=bill)
        //getBill(billId)
    }
    private fun getBill(billId:String){
        getBillUseCase(billId).onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = BillState(bill = result.data)
                }
                is Resource.Error->{
                    _state.value = BillState(error = result.message ?:
                    "An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value = BillState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
/*

)*/
