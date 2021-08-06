package com.example.testfitgridgraph.ui

import android.os.Bundle
import com.example.testfitgridgraph.R
import com.example.testfitgridgraph.navigation.Router
import com.github.terrakok.cicerone.Navigator
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class DetailActivity : BaseActivity() {

    @Inject
    lateinit var router: Router

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getActivityComponent().inject(this)
        setContentView(R.layout.activity_detail)

        router.openDetailScreen()
    }


    override fun initNavigator(): Navigator {
        return AppNavigator(this, R.id.detail_container)
    }
}