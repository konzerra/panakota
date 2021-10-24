package com.konzerra.panakota.presentation.bill

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import com.konzerra.panakota.presentation.bill.components.BillTabs
import com.konzerra.panakota.presentation.bill.components.DetailedBillCompose
import com.konzerra.panakota.presentation.common_components.topbars.TopBarText

@Composable
fun BillScreen(
    billId:String,
    openDrawer: (Unit) -> Unit,
    viewModel: BillViewModel = hiltViewModel(),

){
    viewModel.setBillId(billId)
    val state = viewModel.state.value
    state.bill?.let{ 
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item{
                TopBarText(
                    modifier = Modifier.layoutId("topBar"),
                    title = "Bill",
                    onMenuClicked = {
                        openDrawer(Unit)
                    }
                )
                DetailedBillCompose(
                    modifier = Modifier,
                    bill = state.bill
                )
                BillTabs(
                    modifier = Modifier
                        .layoutId("billTabs")
                        .padding(start = 16.dp , end = 16.dp)
                    ,
                    currentTab = viewModel.currentTab.value,
                    updateCurrentTab = {
                    viewModel.setCurrentTab(it)
                    Log.w("currentTab", "Now!")
                })
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
//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val detailedBill = createRefFor("detailedBill")
        val billTabs = createRefFor("billTabs")
        val deputyListView = createRefFor("deputyListView")
        val buttonAddAll = createRefFor("buttonAddAll")
        constrain(detailedBill) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(billTabs) {
            top.linkTo(detailedBill.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(deputyListView) {
            top.linkTo(billTabs.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(buttonAddAll) {
            top.linkTo(billTabs.bottom)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }

    }
    return constraints
}

