package com.example.testfitgridgraph.di
import com.example.testfitgridgraph.navigation.Router
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder

import dagger.Module
import dagger.Provides



@Module
class NavigationModule {

    @Provides
    @AppScope
    fun provideCicerone(router: Router) = Cicerone.create(router)

    @Provides
    @AppScope
    fun provideNavigationHolder(cicerone: Cicerone<Router>): NavigatorHolder = cicerone.getNavigatorHolder()

    @Provides
    @AppScope
    fun provideRouter() = Router()
}