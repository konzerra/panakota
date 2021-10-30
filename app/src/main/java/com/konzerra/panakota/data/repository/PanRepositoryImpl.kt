package com.konzerra.panakota.data.repository

import com.konzerra.panakota.data.dto.BillDto
import com.konzerra.panakota.data.dto.PartyDto
import com.konzerra.panakota.data.remote.PanakotaDataAPI
import com.konzerra.panakota.domain.repository.PanRepository
import javax.inject.Inject

class PanRepositoryImpl @Inject constructor(
    private val api:PanakotaDataAPI
):PanRepository{
    override suspend fun getBill(billId: String): BillDto {
        return api.getBill(billId)
    }

    override suspend fun getBills(): List<BillDto> {
        return api.getBillList()
    }

    override suspend fun getPartyList(): List<PartyDto> {
        return api.getPartyList()
    }
}