package com.example.testfitgridgraph.ui

import com.example.testfitgridgraph.di.activity.ActivityComponent
import moxy.MvpAppCompatFragment

open class BaseFragment :  MvpAppCompatFragment() {

    protected val activityComponent: ActivityComponent
        get() = baseActivity.getActivityComponent()

    protected val baseActivity: BaseActivity
        get() = requireActivity() as BaseActivity

    /**
     * @return true if handled in this method
     */
    fun onBackPressed(): Boolean {
        return false
    }
}