package com.example.testfitgridgraph.view

import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface DetailView : BaseMvpView{
    fun getName()
    fun showName(name:String)
    fun showMessage(msg:String)
}