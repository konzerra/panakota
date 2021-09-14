package com.konzerra.panakota.domain.repository

import com.konzerra.panakota.data.dto.BillDto


interface PanRepository {
    suspend fun getBill (billId:String): BillDto
    suspend fun getBills (): List<BillDto>
}