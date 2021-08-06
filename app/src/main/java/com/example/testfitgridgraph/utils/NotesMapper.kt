package com.example.testfitgridgraph.utils

import com.example.testfitgridgraph.models.NotesModel
import com.example.testfitgridgraph.models.StackOverflowModel
import javax.inject.Inject

class NotesMapper @Inject constructor() {

    fun restEntityToNotes(restEntity: StackOverflowModel?): MutableList<NotesModel> {
        return (restEntity?.items?.map {
            NotesModel(
                it.question_id,
                it.owner.display_name,
                it.owner.link
            )
        } ?: mutableListOf()) as MutableList<NotesModel>
    }
}