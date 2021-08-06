package com.example.testfitgridgraph.utils

import com.example.testfitgridgraph.LaunchListQuery
import com.example.testfitgridgraph.db.LaunchModel
import javax.inject.Inject

class LaunchMapper @Inject constructor() {

    fun graphQlToLaunchModel(launches: List<LaunchListQuery.Launch?>?):List<LaunchModel>{
        return launches?.map {LaunchModel(null,it!!.site!!)} ?: emptyList()
    }
}