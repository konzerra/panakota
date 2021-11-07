package com.konzerra.panakota.presentation.party

import androidx.lifecycle.ViewModel
import com.konzerra.panakota.domain.usecase.GetBillUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PartyViewModel @Inject constructor(
    private val getBillUseCase: GetBillUseCase,

): ViewModel(){

}