package com.konzerra.panakota.domain.usecase

import com.konzerra.panakota.common.Resource

import com.konzerra.panakota.data.dto.toParty

import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.domain.repository.PanRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetPartyListUseCase @Inject constructor(
    private val repository: PanRepository
) {
    operator fun invoke(): Flow<Resource<List<Party>>> = flow {
        try {
            emit(Resource.Loading())
            val partyList = repository.getPartyList().map{ it.toParty()}
            emit(Resource.Success(partyList))
        } catch(e: HttpException) {
            emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
        } catch(e: IOException) {
            emit(Resource.Error("Couldn't reach server. Check your internet connection."))
        }
    }
}