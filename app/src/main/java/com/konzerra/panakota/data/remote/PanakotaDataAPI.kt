package com.konzerra.panakota.data.remote

import com.konzerra.panakota.data.dto.BillDto
import com.konzerra.panakota.data.dto.PartyDto
import retrofit2.http.GET
import retrofit2.http.Path


interface PanakotaDataAPI {
    @GET("/bill/{billId}")
    suspend fun getBill(@Path("billId") billId:String):BillDto

    @GET("/bill_list/")
    suspend fun getBillList():List<BillDto>

    @GET("/party_list/")
    suspend fun getPartyList():List<PartyDto>
}