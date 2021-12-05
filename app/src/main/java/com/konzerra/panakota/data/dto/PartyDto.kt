package com.konzerra.panakota.data.dto

import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.model.Party

data class PartyDto(
    val name:String,
    val date:String,
    val id:String,
    val ideology:String,
    val leader:String
)
fun PartyDto.toParty(): Party {
    return Party(
        name = name,
        date = date,
        id = id,
        ideology = ideology,
        leader = leader
    )
}