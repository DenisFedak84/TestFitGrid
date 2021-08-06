package com.example.testfitgridgraph.models



data class ItemStackOverflow(
    val owner: OwnerStackOverflow,
    val is_accepted: Boolean,
    val score: Int,
    val last_activity_date: Int,
    val creation_date: Int,
    val answer_id: Int,
    val question_id: Int
)
