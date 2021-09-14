package com.konzerra.panakota.presentation.bill

import com.konzerra.panakota.domain.model.DetailedBill

data class BillState (
    val isLoading :Boolean = false,
    val bill : DetailedBill? = null,
    val error : String = ""
        ){
}