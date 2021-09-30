package com.konzerra.panakota.presentation.bill.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.R
import com.konzerra.panakota.domain.model.DetailedBill
import com.konzerra.panakota.ui.theme.Blue500

@Composable
fun DetailedBillCompose(bill: DetailedBill){
    Column() {
        Text(text = bill.name,
            modifier = Modifier
                .padding(top = 16.dp, start = 16.dp, end = 16.dp))
        Text(text = bill.date,
            modifier = Modifier
                .padding(start = 16.dp, top = 4.dp),
            style = MaterialTheme.typography.body2
        )
        Row(modifier = Modifier.fillMaxWidth()) {
            Text(text = stringResource(id = R.string.voted),
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp),

            )
            Row(horizontalArrangement = Arrangement.End){
                Text(text  = "${stringResource(id = R.string.yes)}: ${bill.yes}   ${stringResource(id = R.string.no)}: ${bill.no}",
                    modifier = Modifier
                        .padding(top = 12.dp, end = 16.dp),
                    maxLines = 2
                )
            }

        }
        Row() {
            Text(text = stringResource(id = R.string.link_to_doc) + ": " + bill.link,
                modifier = Modifier
                    .padding(top = 12.dp, start = 16.dp)
            )
        }
    }

}