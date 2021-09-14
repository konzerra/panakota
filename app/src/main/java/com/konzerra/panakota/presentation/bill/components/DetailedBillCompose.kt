package com.konzerra.panakota.presentation.bill.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
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
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp)) {
        Column(modifier = Modifier
            .fillMaxWidth()
            .background(Blue500)) {
            Text(text = bill.name,
                modifier = Modifier
                    .padding(top = 16.dp, start = 16.dp, end = 16.dp))
            Text(text = bill.date,
                modifier = Modifier
                    .padding(start = 16.dp, top = 8.dp),
                style = MaterialTheme.typography.body2
            )
            Row() {
                Text(text = stringResource(id = R.string.initiators),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                )

                Text(text = buildString {
                    for( item in bill.initiators)  {
                        append("$item,")
                    }
                },
                    modifier = Modifier
                        .padding(start= 16.dp, top = 16.dp, end = 16.dp),
                    maxLines = 2
                )
            }
            Row() {
                Text(text = stringResource(id = R.string.voted),
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                )

                Text(text  = "${stringResource(id = R.string.yes)}: ${bill.yes}   ${stringResource(id = R.string.no)}: ${bill.no}",
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, end = 16.dp),
                    maxLines = 2
                )
            }
            Row() {
                Text(text = stringResource(id = R.string.link_to_doc) + ": " + bill.link,
                    modifier = Modifier
                        .padding(top = 16.dp, start = 16.dp)
                )

                TextButton(onClick = { /*TODO*/ }) {
                    Text(stringResource(id = R.string.look))
                }
            }
        }
    }
}