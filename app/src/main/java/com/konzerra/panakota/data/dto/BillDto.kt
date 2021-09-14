package com.konzerra.panakota.data.dto

import com.konzerra.panakota.domain.model.DetailedBill

data class BillDto(
    val name:String,
    val date:String,
    val initiators:List<String>,
    val no:Int,
    val yes:Int,
    val link:String,
    val id:String
)
fun BillDto.toBill(): DetailedBill {
    return DetailedBill(
        name = name,
        date = date,
        initiators = initiators,
        no = no,
        yes = yes,
        link = link,
        id = id
    )
}
