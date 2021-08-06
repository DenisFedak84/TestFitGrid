package com.example.testfitgridgraph.presenter

import com.example.testfitgridgraph.navigation.Router
import com.example.testfitgridgraph.view.PreviewView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class PreviewPresenter @Inject internal constructor(
    private val router: Router
) : BasePresenter<PreviewView>() {

    fun closeAll() {
        router.closeDetailActivity()
    }

}