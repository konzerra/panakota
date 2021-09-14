package com.konzerra.panakota.domain.model

data class DetailedBill(
    val name:String,
    val date:String,
    val initiators:List<String>,
    val no:Int,
    val yes:Int,
    val link:String,
    val id:String
)
