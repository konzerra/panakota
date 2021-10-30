package com.konzerra.panakota.presentation.partylist

import com.konzerra.panakota.domain.model.Party

data class PartyListState(
    val isLoading :Boolean = false,
    val partyList : List<Party> = emptyList(),
    val error : String = ""
)