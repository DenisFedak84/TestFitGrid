package com.example.testfitgridgraph.di.activity

import com.example.testfitgridgraph.ui.BaseActivity
import com.example.testfitgridgraph.ui.DetailActivity
import com.example.testfitgridgraph.ui.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent(modules = [ActivityModule::class])
interface ActivityComponent {

//    operator fun plus(module: SplashModule): SplashComponent
//    operator fun plus(module: HeroesModule): HeroesComponent
//    operator fun plus(module: HeroDetailsModule): HeroDetailsComponent

    fun inject(baseActivity: BaseActivity)
    fun inject(baseActivity: MainActivity)
    fun inject(baseActivity: DetailActivity)

}
