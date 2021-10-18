package com.konzerra.panakota.presentation.commoncomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konzerra.panakota.R
import com.konzerra.panakota.ui.theme.Blue1000
import com.konzerra.panakota.ui.theme.Blue500
import com.konzerra.panakota.ui.theme.PanakotaTheme





@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PanakotaTheme {
       TopBarText("", "Bill")
    }
}
