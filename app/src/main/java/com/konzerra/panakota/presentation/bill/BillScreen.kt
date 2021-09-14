package com.konzerra.panakota.presentation.bill

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.konzerra.panakota.R
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.presentation.bill.components.DetailedBillCompose
import com.konzerra.panakota.presentation.commoncomponents.TopBarText
import com.konzerra.panakota.ui.theme.Blue500

@Composable
fun BillScreen(
    viewModel: BillViewModel = hiltViewModel(),
    billId:String
){
    viewModel.setBillId(billId)
    val state = viewModel.state.value
    state.bill?.let{
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item{
                TopBarText( contentDescription = "icon", title = "Bill")
                DetailedBillCompose(state.bill)
            }
        }
    }
    if(state.error.isNotBlank()) {
        Text(
            text = state.error,
            color = MaterialTheme.colors.error,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)

        )
    }
}

