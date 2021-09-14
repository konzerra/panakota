package com.konzerra.panakota.presentation.navigation


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.konzerra.panakota.R
import com.konzerra.panakota.ui.theme.Blue500


@Composable
fun NavDrawer(){
    Column() {
        Header("Дьявол Сатанов", "+996 999 666 999")
    }
}
@Composable
private fun Header(name: String, contactInfo: String){

    Box(modifier = Modifier
        .fillMaxWidth()
        .background(color = Blue500)
        .shadow(3.dp)
    ){
        Row {
            Image(
                painterResource(id = R.drawable.ic_icon_panakota),
                contentDescription = "",
                contentScale = Crop,
                modifier = Modifier
                    .padding(5.dp))
            Text(text = "Panakota",
                fontSize = 30.sp,
                modifier = Modifier
                .padding( top = 16.dp, start = 16.dp, bottom = 16.dp)

            )
        }
    }
}
/*Column() {
    Text( text = name, modifier =
    Modifier
        .padding( top = 16.dp, start = 16.dp)
    )
    Text( text = contactInfo, modifier =
    Modifier
        .padding( top = 16.dp, start = 16.dp, bottom = 16.dp)
    )
}*/
@Composable
private fun DrawerOptions(){

}

