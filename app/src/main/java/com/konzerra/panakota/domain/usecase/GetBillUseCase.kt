package com.konzerra.panakota.domain.usecase

import com.konzerra.panakota.common.Resource
import com.konzerra.panakota.data.dto.toBill
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.repository.PanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import retrofit2.HttpException
import javax.inject.Inject

class GetBillUseCase @Inject constructor(
    private val repository: PanRepository
) {
    operator fun invoke(billId: String): Flow<Resource<DetailedBill>> = flow {
        try {
            emit(Resource.Loading<DetailedBill>())
            val bill = repository.getBill(billId).toBill()
            emit(Resource.Success<DetailedBill>(bill))
        } catch(e: HttpException) {
            emit(Resource.Error<DetailedBill>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<DetailedBill>("Couldn't reach server. Check your internet connection."))
        }
    }
}