package com.example.testfitgridgraph.ui


import android.os.Bundle
import com.example.testfitgridgraph.App
import com.example.testfitgridgraph.di.activity.ActivityComponent
import com.example.testfitgridgraph.di.activity.ActivityModule
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.NavigatorHolder
import moxy.MvpAppCompatActivity
import javax.inject.Inject

abstract class BaseActivity : MvpAppCompatActivity() {
    @Inject
    lateinit var navigatorHolder: NavigatorHolder

    private var activityComponent: ActivityComponent? = null

    fun getActivityComponent(): ActivityComponent {
        return activityComponent ?: createComponent()
            .also { activityComponent = it }
    }

    private fun createComponent() = (application as App).appComponent.plus(ActivityModule(this))

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getActivityComponent().inject(this)
    }

    override fun onResume() {
        super.onResume()
        navigatorHolder.setNavigator(initNavigator())
    }

    abstract fun initNavigator(): Navigator

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }
}