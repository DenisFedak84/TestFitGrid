package com.example.testfitgridgraph.presenter

import com.example.testfitgridgraph.LaunchListQuery
import com.example.testfitgridgraph.db.LaunchModel
import com.example.testfitgridgraph.model.DetailRepository
import com.example.testfitgridgraph.navigation.Router
import com.example.testfitgridgraph.utils.LaunchMapper
import com.example.testfitgridgraph.view.DetailView
import moxy.InjectViewState
import javax.inject.Inject

@InjectViewState
class DetailPresenter @Inject internal constructor(
    private val router: Router,
    private val repository: DetailRepository,
    private val mapper: LaunchMapper
) : BasePresenter<DetailView>() {

    fun goToPreview() {
        router.openPreviewScreen()
    }

    fun getName(query: LaunchListQuery) {
        repository.getDataGraphQl(query)
            ?.subscribe({
                val name = it.data?.launches?.launches?.size.toString()
                saveList(mapper.graphQlToLaunchModel(it.data?.launches?.launches))
                viewState.showName(name)
            },
                { viewState.showName("Error") })
            ?.unsubscribeOnDestroy()
    }

    fun saveList(data :List<LaunchModel>){
        repository.saveListInDb(data).subscribe({
            viewState.showMessage("Saved in DB" + it.size)
        },{
            viewState.showMessage("DB error")
        }).unsubscribeOnDestroy()
    }

}