package com.example.testfitgridgraph.model

import android.annotation.SuppressLint
import com.apollographql.apollo.ApolloClient
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.fetcher.ApolloResponseFetchers
import com.apollographql.apollo.rx2.rxQuery
import com.example.testfitgridgraph.LaunchListQuery
import com.example.testfitgridgraph.LaunchListQuery.Data
import com.example.testfitgridgraph.db.LaunchDao
import com.example.testfitgridgraph.db.LaunchModel
import io.reactivex.Observable
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class DetailRepository @Inject constructor(
    private val client: ApolloClient,
    private val dao: LaunchDao
) {

    @SuppressLint("CheckResult")
    fun getDataGraphQl(query: LaunchListQuery): Observable<Response<Data>>? {
        return client.rxQuery(query) {
            responseFetcher(ApolloResponseFetchers.NETWORK_FIRST)
        }.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
//            .subscribe({
//                it
//            }, {
//
//            }, {
//                //on complete
//            })
    }

    fun saveListInDb(data: List<LaunchModel>): Single<List<Long>> {
        return Single.fromCallable { dao.insertAll(data) }
            .subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
    }


}