package com.example.testfitgridgraph.model

import com.example.testfitgridgraph.models.StackOverflowModel
import com.example.testfitgridgraph.models.user.UserResponse
import com.example.testfitgridgraph.rx.NotesApi
import com.example.testfitgridgraph.rx.RxSchedulers
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val api: NotesApi,
    private val rxSchedulers: RxSchedulers
) {

    fun getDataRest(): Observable<StackOverflowModel> {
        return api.getNotes(2, 10)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

    fun getRestUsers(): Observable<UserResponse>{
        return api.getUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }

}