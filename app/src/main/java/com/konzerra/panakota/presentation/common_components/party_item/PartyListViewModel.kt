package com.konzerra.panakota.presentation.common_components.party_item

import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.usecase.GetBillListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PartyListViewModel @Inject constructor(
    private val getBillListUseCase: GetBillListUseCase
): ViewModel() {

}