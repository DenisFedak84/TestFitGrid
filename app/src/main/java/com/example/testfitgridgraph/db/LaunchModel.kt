package com.example.testfitgridgraph.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class LaunchModel(
    @PrimaryKey(autoGenerate = true) var id: Long? = null,
    @ColumnInfo(name = "site") val site: String
) {

}
