package com.example.testfitgridgraph.models

data class StackOverflowModel(
    val items: List<ItemStackOverflow>,
    val has_more: Boolean,
    val backoff: Int,
    val quota_max: Int,
    val quota_remaining: Int
)