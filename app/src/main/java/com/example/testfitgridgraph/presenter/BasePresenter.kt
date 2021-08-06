package com.example.testfitgridgraph.presenter


import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import moxy.MvpPresenter
import moxy.MvpView

abstract class BasePresenter <View : MvpView> : MvpPresenter<View>(){

    private val disposables = CompositeDisposable()


    protected fun Disposable.unsubscribeOnDestroy(): Disposable {
        disposables.add(this)
        return this
    }

    override fun onDestroy() {
        disposables.dispose()
        super.onDestroy()
    }
}