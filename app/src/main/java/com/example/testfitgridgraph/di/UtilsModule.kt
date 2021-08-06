package com.example.testfitgridgraph.di
import com.example.testfitgridgraph.rx.AppRxSchedulers
import com.example.testfitgridgraph.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class UtilsModule {

    @Provides
    internal fun provideRxSchedulers(): RxSchedulers = AppRxSchedulers()


}
