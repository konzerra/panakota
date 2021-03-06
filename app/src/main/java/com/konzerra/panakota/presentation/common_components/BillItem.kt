package com.konzerra.panakota.presentation.common_components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.ui.theme.*

@Composable
fun BillItem(
    bill:DetailedBill,
    onItemClick: (String) -> Unit
){
    Card(modifier = Modifier,
        //elevation =  4.dp,
        shape = RoundedCornerShape(0.dp),
    ){
        Row(modifier = Modifier
            .padding(start = 16.dp, end = 16.dp, bottom = 10.dp)
            .fillMaxWidth()
            .background( Wood700)
            .clickable { onItemClick(bill.id) }
        ) {
            Box(modifier = Modifier
                .width(6.dp)
                .height(IntrinsicSize.Max)
            )
            Box(modifier = Modifier
                .background(Gray300)
                .fillMaxWidth()
            ){
                Column() {
                    Text(text = bill.name,
                        modifier = Modifier
                            .padding(start = 13.dp, top = 10.dp, end = 10.dp,)
                    )
                    Text(text = bill.date,
                        color = Black500,
                        style = MaterialTheme.typography.body2,
                        modifier = Modifier
                            .padding(start = 13.dp, bottom = 10.dp, top = 5.dp)
                            .align(alignment = Alignment.Start)
                    )
                }
            }
        }
    }

}