package com.konzerra.panakota.presentation.party

import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.domain.model.Party

data class PartyScreenState(
    val isLoading :Boolean = false,
    val party: Party? = null,
    val error : String = ""
)
