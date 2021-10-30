package com.konzerra.panakota.domain.repository

import com.konzerra.panakota.data.dto.BillDto
import com.konzerra.panakota.data.dto.PartyDto


interface PanRepository {
    suspend fun getBill (billId:String): BillDto
    suspend fun getBills (): List<BillDto>
    suspend fun getPartyList(): List<PartyDto>
}