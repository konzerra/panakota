package com.konzerra.panakota.di

import com.konzerra.panakota.common.Constants
import com.konzerra.panakota.data.remote.PanakotaDataAPI
import com.konzerra.panakota.data.repository.PanRepositoryImpl
import com.konzerra.panakota.domain.repository.PanRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providePanakotaDataAPI():PanakotaDataAPI{
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(PanakotaDataAPI::class.java)
    }
    @Provides
    @Singleton
    fun providePanRepository(api: PanakotaDataAPI):PanRepository{
        return PanRepositoryImpl(api)
    }
}