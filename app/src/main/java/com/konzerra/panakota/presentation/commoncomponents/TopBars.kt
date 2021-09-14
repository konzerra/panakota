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

@Composable
fun TopBarSearch(
    contentDescription: String,
    searchTitle:String,
    modifier: Modifier = Modifier
) {
    var textFieldState by remember {
        mutableStateOf("")
    }
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Blue500),
    ){
        Row() {
            Image(
                painterResource(R.drawable.ic_menu),
                contentDescription,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(start = 10.dp, top = 10.dp),
                contentScale = ContentScale.Fit
            )
            TextField(value = textFieldState,
                label = { Text(searchTitle, color = Blue1000) },
                colors = TextFieldDefaults.textFieldColors(
                    textColor = Blue1000,
                    backgroundColor = Color.Transparent,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent,
                    disabledIndicatorColor = Color.Transparent,
                ),
                onValueChange = {
                    textFieldState=it
                },
            )
        }
    }
}

@Composable
fun TopBarText(
    contentDescription: String,
    title:String,
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(56.dp)
            .background(Blue500),
    ){
        Row(modifier = Modifier.fillMaxHeight()) {
            Image(
                painterResource(R.drawable.ic_menu),
                contentDescription,
                modifier = Modifier
                    .height(40.dp)
                    .width(40.dp)
                    .padding(start = 10.dp, top = 10.dp, end = 10.dp),
                contentScale = ContentScale.Fit
            )
            Text(text = title,
                fontSize = 20.sp,
                modifier = Modifier
                    .align(alignment = Alignment.CenterVertically)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PanakotaTheme {
       TopBarText("", "Bill")
    }
}
