package com.example.testfitgridgraph.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType


@StateStrategyType(AddToEndSingleStrategy::class)
interface MainView : BaseMvpView{

    fun getName()
    fun showName(name:String)
    fun showProgress()
    fun hideProgress()
}