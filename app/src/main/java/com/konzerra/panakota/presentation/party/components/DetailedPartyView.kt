package com.konzerra.panakota.presentation.partylist.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import com.konzerra.panakota.R
import com.konzerra.panakota.domain.model.Party
import com.konzerra.panakota.ui.theme.White

@Composable
fun DetailedPartyView(
    party: Party,
    modifier: Modifier
){
    val constraints = setConstraints()
    ConstraintLayout(
        modifier = modifier,
        constraintSet = constraints
    ) {
        Text(
            modifier = Modifier
                .layoutId("tvName")
                .padding(),
            text = party.name,
            fontSize = 14.sp
        )
        Text(
            modifier = Modifier
                .layoutId("tvDate")
                .padding(),
            text = party.date
        )
        Text(
            modifier = Modifier
                .layoutId("tvIdeology")
                .padding(),
            text = "Political Ideology"
        )
        Text(
            modifier = Modifier
                .layoutId("tvCurrentIdeology")
                .padding(),
            text = party.ideology
        )
        Text(
            modifier = Modifier
                .layoutId("tvLeader")
                .padding(),
            text = "Leader"
        )
        Text(
            modifier = Modifier
                .layoutId("tvCurrentLeader")
                .padding(),
            text = party.leader
        )
        Image(
            painterResource(R.drawable.ic_account),
            "",
            modifier = Modifier
                .layoutId("ivPartyLogo")
                .padding(end = 16.dp, top = 16.dp)
                .height(40.dp)
                .width(40.dp),
            contentScale = ContentScale.Fit,
        )
    }
}
//constraints
private fun setConstraints(): ConstraintSet {
    val constraints = ConstraintSet {
        val tvName = createRefFor("tvName")
        val tvDate = createRefFor("tvDate")
        val tvIdeology = createRefFor("tvIdeology")
        val tvCurrentIdeology = createRefFor("tvCurrentIdeology")
        val tvLeader = createRefFor("tvLeader")
        val tvCurrentLeader = createRefFor("tvCurrentLeader")
        val ivPartyLogo = createRefFor("ivPartyLogo")
        constrain(tvName) {
            top.linkTo(parent.top)
            start.linkTo(parent.start)
            end.linkTo(ivPartyLogo.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(tvDate) {
            top.linkTo(tvName.bottom)
            start.linkTo(parent.start)
            end.linkTo(ivPartyLogo.start)
            width = Dimension.fillToConstraints
            height = Dimension.wrapContent
        }
        constrain(tvIdeology) {
            top.linkTo(tvDate.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvCurrentIdeology) {
            top.linkTo(tvIdeology.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvLeader) {
            top.linkTo(tvCurrentIdeology.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(tvCurrentLeader) {
            top.linkTo(tvLeader.bottom)
            start.linkTo(parent.start)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
        constrain(ivPartyLogo) {
            top.linkTo(parent.top)
            end.linkTo(parent.end)
            width = Dimension.wrapContent
            height = Dimension.wrapContent
        }
    }
    return constraints
}