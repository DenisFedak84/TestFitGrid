package com.example.testfitgridgraph.rx

import com.example.testfitgridgraph.models.StackOverflowModel
import com.example.testfitgridgraph.models.user.UserResponse
import io.reactivex.Observable

import retrofit2.http.GET
import retrofit2.http.Query

interface NotesApi {

    @GET("https://gorest.co.in/2.2/answers?order=desc&sort=activity&site=stackoverflow")
    fun getNotes(@Query("page") pageNumber: Int,
                 @Query("pagesize") pageSize: Int): Observable<StackOverflowModel>

    @GET("/public/v1/users")
    fun getUsers(): Observable<UserResponse>
}
