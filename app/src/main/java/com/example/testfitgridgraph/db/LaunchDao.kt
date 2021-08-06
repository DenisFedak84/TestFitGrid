package com.example.testfitgridgraph.db

import androidx.room.*
import androidx.room.OnConflictStrategy.REPLACE
import io.reactivex.Flowable

@Dao
interface LaunchDao {

    @Query("SELECT * FROM launchModel")
    suspend fun getAll(): MutableList<LaunchModel>

    @Query("SELECT * FROM launchModel WHERE id = :id")
    fun getById(id: Long): LaunchModel

    @Delete
    suspend fun delete(launchModel: LaunchModel): Int

    @Query("DELETE FROM launchModel")
    suspend fun deleteAll(): Int

    @Insert(onConflict = REPLACE)
    suspend fun insert(vararg launchModel: LaunchModel): List<Long>

    @Update
    fun update(vararg launchModel: LaunchModel)

    @Insert(onConflict = REPLACE)
    @JvmSuppressWildcards
    abstract fun insertAll(data: List<LaunchModel>) : List<Long>

}