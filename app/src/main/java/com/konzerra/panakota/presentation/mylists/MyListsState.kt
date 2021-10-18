package com.konzerra.panakota.presentation.mylists

import com.konzerra.panakota.domain.model.Deputy

data class MyListsState(
    val isLoading : Boolean = false,
    val list: List<Deputy> = emptyList(),
    val error: String = ""
)
