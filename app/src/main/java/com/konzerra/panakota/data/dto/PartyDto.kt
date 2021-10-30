package com.konzerra.panakota.data.dto

import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.model.Party

data class PartyDto(
    val name:String,
    val date:String,
    val initiators:List<String>,
    val no:Int,
    val yes:Int,
    val link:String,
    val id:String
)
fun PartyDto.toParty(): Party {
    return Party(
        name = name,
        date = date,
        id = id
    )
}