package com.example.testfitgridgraph.di
import com.example.testfitgridgraph.di.activity.ActivityComponent
import com.example.testfitgridgraph.di.activity.ActivityModule
import com.example.testfitgridgraph.rx.NotesApi
import com.example.testfitgridgraph.rx.RxSchedulers
import com.example.testfitgridgraph.ui.DetailFragment
import com.example.testfitgridgraph.ui.PreviewFragment
import dagger.Component

@AppScope
@Component(modules = [NetworkModule::class, NavigationModule::class, AppContextModule::class, UtilsModule::class])
interface AppComponent {

    operator fun plus(activityModule: ActivityModule): ActivityComponent

    fun rxSchedulers(): RxSchedulers

    fun apiService(): NotesApi

    fun inject(fragment: DetailFragment)

    fun inject(fragment: PreviewFragment)

}
