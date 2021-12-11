package com.example.composeworkshop.core.di

import com.example.composeworkshop.interactor.feed.FeedApi
import com.example.composeworkshop.interactor.feed.FeedInteractor
import com.example.composeworkshop.interactor.feed.FeedRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
class FeedModule {

    @Provides
    fun provideFeedApi(retrofit: Retrofit): FeedApi = retrofit.create(FeedApi::class.java)

    @Provides
    fun provideFeedRepository(api: FeedApi) = FeedRepository(api)

    @Provides
    fun provideFeedInteractor(repository: FeedRepository) = FeedInteractor(repository)
}