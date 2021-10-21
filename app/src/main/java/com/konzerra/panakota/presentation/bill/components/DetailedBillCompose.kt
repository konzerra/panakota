package com.konzerra.panakota.presentation.bill.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.R
import com.konzerra.panakota.domain.model.DetailedBill

@Composable
fun DetailedBillCompose(
    modifier: Modifier,
    bill: DetailedBill
){
    val constraints = setConstraints()
    ConstraintLayout(
        modifier = modifier,
        constraintSet = constraints
    ) {
        Text(
            text = bill.name,
            modifier = Modifier
                .layoutId("tvName")
                .padding(top = 16.dp, start = 16.dp, end = 16.dp))
        Text(
            text = bill.date,
            modifier = Modifier
                .layoutId("tvDate")
                .padding(start = 16.dp, top = 4.dp),
            style = MaterialTheme.typography.body2
        )
        Text(
            text = stringResource(id = R.string.voted),
            modifier = Modifier
                .layoutId("tvVoted")
                .padding(top = 12.dp, start = 16.dp),
            )
        Text(
            text  = "${stringResource(id = R.string.yes)}: ${bill.yes}   ${stringResource(id = R.string.no)}: ${bill.no}",
            modifier = Modifier
                .layoutId("tvVotedResults")
                .padding(top = 12.dp, end = 16.dp),
            maxLines = 2
        )
        Text(
            text = stringResource(id = R.string.link_to_doc) + ": " + bill.link,
            modifier = Modifier
                .layoutId("tvLink")
                .padding(top = 12.dp, start = 16.dp)
        )
    }
}
//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val tvName = createRefFor("tvName")
        val tvDate = createRefFor("tvDate")
        val tvVoted = createRefFor("tvVoted")
        val tvVotedResults = createRefFor("tvVotedResults")
        val tvLink = createRefFor("tvLink")
        constrain(tvName) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvDate) {
            top.linkTo(tvName.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvVoted) {
            top.linkTo(tvDate.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvVotedResults) {
            top.linkTo(tvDate.bottom)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvLink) {
            top.linkTo(tvVotedResults.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    return constraints
}