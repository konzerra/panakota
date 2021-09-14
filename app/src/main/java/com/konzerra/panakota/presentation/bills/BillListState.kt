package com.konzerra.panakota.presentation.bills

import com.konzerra.panakota.domain.model.DetailedBill

data class BillListState (
    val isLoading :Boolean = false,
    val bills : List<DetailedBill> = emptyList(),
    val error : String = ""
        ){
}