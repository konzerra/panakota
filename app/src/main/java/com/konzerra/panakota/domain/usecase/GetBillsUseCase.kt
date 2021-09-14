package com.konzerra.panakota.domain.usecase

import com.konzerra.panakota.common.Resource
import com.konzerra.panakota.data.dto.toBill
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.repository.PanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetBillsUseCase @Inject constructor(
    private val repository: PanRepository
) {
    operator fun invoke(): Flow<Resource<List<DetailedBill>>> = flow {
        try {
            emit(Resource.Loading<List<DetailedBill>>())
            val bills = repository.getBills().map{ it.toBill()}
            emit(Resource.Success<List<DetailedBill>>(bills))
        } catch(e: HttpException) {
            emit(Resource.Error<List<DetailedBill>>(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error<List<DetailedBill>>("Couldn't reach server. Check your internet connection."))
        }
    }
}