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

class GetBillListUseCase @Inject constructor(
    private val repository: PanRepository
) {
    operator fun invoke(): Flow<Resource<List<DetailedBill>>> = flow {
        try {
            emit(Resource.Loading())
            val bills = repository.getBills().map{ it.toBill()}
            emit(Resource.Success(bills))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}