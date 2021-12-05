package com.konzerra.panakota.presentation.partylist.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.presentation.common_components.BillItem
import com.konzerra.panakota.presentation.common_components.party_item.PartyItem

@Composable
fun PartyListView(
    modifier: Modifier,
    partyList:List<Party>,
    onItemClicked: (String) -> Unit
){
        LazyColumn(modifier = modifier
            .padding(top = 16.dp)
        ){
            itemsIndexed( partyList ){ index, party ->
                PartyItem(party = party, onItemClick = {
                    onItemClicked(it)
                })
            }
        }
    }