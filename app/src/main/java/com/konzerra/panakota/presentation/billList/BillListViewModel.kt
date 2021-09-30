package com.konzerra.panakota.presentation.billList

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.konzerra.panakota.common.Resource
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.usecase.GetBillsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class BillListViewModel @Inject constructor(
    private val getBillsUseCase: GetBillsUseCase
):ViewModel(){
    private val _state = mutableStateOf(BillListState())
    val state : State<BillListState> = _state

    init{
        val bill1= DetailedBill(
            "О проекте Закона «О признании утратившим силу Закона Кыргызской Республики «О закрытом акционерном обществе «Пятый канал»",
            "12/12/2012",
            listOf("Boris Johnson"),
            25,
            155,
            "uk.gov/doc/34643",
            "34643"

        )
        val list = listOf(bill1)
        _state.value=BillListState(bills=list)

    }
    private fun getBills(){

        getBillsUseCase().onEach { result->
            when(result){
                is Resource.Success->{
                    _state.value = BillListState(bills = result.data ?: emptyList())
                }
                is Resource.Error->{
                    _state.value = BillListState(error = result.message ?:
                    "An unexpected error occurred")
                }
                is Resource.Loading->{
                    _state.value = BillListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}


//listOf( mapOf("name" to "VI созыв", "date" to "2015-2021"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"), mapOf("name" to "V созыв", "date" to "2010-2015"))