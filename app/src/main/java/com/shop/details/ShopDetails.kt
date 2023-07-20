package com.shop.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.shop.model.ShopModel
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun ShopOfDetails(
    navController: NavHostController
) {

    val result = navController.previousBackStackEntry?.savedStateHandle?.get<ShopModel>("shopping")

    Column(
        modifier = Modifier
            .background(Color.White)
            .padding(10.sdp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.sdp),
            painter = rememberImagePainter(
                data = result?.image
            ),
            contentDescription = "Image Details"
        )

        Spacer(modifier = Modifier.height(5.sdp))

        Text(
            text = "${result?.name}",
            fontSize = 23.ssp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(5.sdp))


        Text(
            modifier = Modifier
                .align(Alignment.Start),
            text = "Price: ${result?.price} $",
            fontSize = 20.ssp
        )

        Spacer(modifier = Modifier.height(10.sdp))


        Text(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .verticalScroll(rememberScrollState()),
            text = "${result?.description}",
            fontSize = 17.ssp,
            textAlign = TextAlign.Center
        )

    }
}