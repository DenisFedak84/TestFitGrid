package com.example.testfitgridgraph.ui

import android.os.Bundle
import android.view.View
import com.example.testfitgridgraph.R
import com.example.testfitgridgraph.presenter.MainPresenter
import com.example.testfitgridgraph.view.MainView

import com.github.terrakok.cicerone.androidx.AppNavigator
import kotlinx.android.synthetic.main.activity_main.*
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject


class MainActivity : BaseActivity(), MainView {

    @Inject
    @InjectPresenter
    lateinit var presenter: MainPresenter

    @ProvidePresenter
    fun providePresenter(): MainPresenter = presenter


    override fun onCreate(savedInstanceState: Bundle?) {
        getActivityComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btnName.setOnClickListener { getName() }
        btnDetail.setOnClickListener { presenter.goToDetail() }
    }

    override fun initNavigator(): AppNavigator {
        return AppNavigator(this, -1)
    }

    override fun getName() {
        presenter.getUser()
    }

    override fun showName(name: String) {
        nameView.text = name
    }

    override fun showProgress() {
        progressView.visibility = View.VISIBLE
        mainContainerView.visibility = View.GONE
    }

    override fun hideProgress() {
        progressView.visibility = View.GONE
        mainContainerView.visibility = View.VISIBLE
    }


}