package com.example.testfitgridgraph.presenter


import com.example.testfitgridgraph.model.MainRepository
import com.example.testfitgridgraph.navigation.Router
import com.example.testfitgridgraph.utils.NotesMapper
import com.example.testfitgridgraph.view.MainView

import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class MainPresenter @Inject internal constructor(
    private val router: Router,
    private val repository: MainRepository,
    private val mapper: NotesMapper
) : BasePresenter<MainView>() {


    fun getName() {
//        viewState.showName("Den")
        repository.getDataRest()
            .doOnSubscribe { viewState.showProgress() }
            .doAfterTerminate { viewState.hideProgress() }
            .map {mapper.restEntityToNotes(it)}
            .subscribe({
                    var name = it.size.toString()
                viewState.showName(name)},
                { viewState.showName("Error") })
            .unsubscribeOnDestroy()
    }

    fun getUser(){
        repository.getRestUsers()
            .doOnSubscribe { viewState.showProgress() }
            .doAfterTerminate { viewState.hideProgress() }
            .map {it.data}
            .subscribe({
                var name = it.size.toString()
                viewState.showName(name)},
                { viewState.showName("Error") })
            .unsubscribeOnDestroy()
    }

    fun goToDetail() {
        router.goToDetailActivity()
    }


}