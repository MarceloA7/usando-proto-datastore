package com.marcelo.usandoprotodatastore.di


import com.marcelo.usandoprotodatastore.data.repository.FakeUserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object HiltModule {

    @Provides
    @Singleton
    fun providerFakeUserRepository():FakeUserRepository{
        return FakeUserRepository()
    }
}