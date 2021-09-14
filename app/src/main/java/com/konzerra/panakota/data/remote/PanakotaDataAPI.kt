package com.konzerra.panakota.data.remote

import com.konzerra.panakota.data.dto.BillDto
import retrofit2.http.GET
import retrofit2.http.Path


interface PanakotaDataAPI {
    @GET("/bill/{billId}")
    suspend fun getBill(@Path("billId") billId:String):BillDto

    @GET("/bills/")
    suspend fun getBills():List<BillDto>
}