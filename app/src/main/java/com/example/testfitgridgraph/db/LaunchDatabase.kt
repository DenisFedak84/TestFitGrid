package com.example.testfitgridgraph.db

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [LaunchModel::class], version = 1)
abstract class LaunchDatabase : RoomDatabase() {
    abstract fun launchDao(): LaunchDao
}