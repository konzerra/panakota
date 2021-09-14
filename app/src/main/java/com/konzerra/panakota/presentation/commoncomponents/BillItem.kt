package com.konzerra.panakota.presentation.commoncomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.ui.theme.Black500
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.Blue700

@Composable
fun BillItem(
    bill:DetailedBill,
    onItemClick: (DetailedBill) -> Unit
){
    Row(modifier = Modifier
        .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
        .background(Blue700)
        .clickable { onItemClick(bill) }
    ) {
        Box(modifier = Modifier
            .width(5.dp)
        )
        Box(modifier = Modifier
            .background(Blue500)
        ){
            Column() {
                Text(text = bill.name,
                    fontSize = 14.sp,
                    modifier = Modifier
                        .padding(10.dp)
                )
                Text(text = bill.date,
                    color = Black500,
                    fontSize = 10.sp,
                    modifier = Modifier
                        .padding(start = 10.dp, bottom = 10.dp)
                        .align(alignment = Alignment.Start)
                )
            }
        }
    }
}