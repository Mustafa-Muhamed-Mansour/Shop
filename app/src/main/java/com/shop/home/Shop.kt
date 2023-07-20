package com.shop.home

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.navigation.NavHostController
import coil.compose.rememberImagePainter
import com.shop.model.ShopModel
import com.shop.route.RouteScreen
import ir.kaaveh.sdpcompose.sdp
import ir.kaaveh.sdpcompose.ssp

@Composable
fun ShopOfHome(shopViewModel: ShopViewModel, navController: NavHostController) {

    val context = LocalContext.current

    val shop = shopViewModel.shopData.collectAsState().value
    val error = shopViewModel.errorMessage.collectAsState().value

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        LazyColumn {

            if (shop.isNullOrEmpty()) {
                item {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .fillMaxSize()
                            .wrapContentSize(align = Alignment.Center)
                    )
                }
                Toast.makeText(context, error, Toast.LENGTH_SHORT).show()
            }

            shop.forEach { shop ->
                items(shop.dataShopResponse.data.size) {
                    ShopCardItem(
                        shop = shop.dataShopResponse.data[it],
                        navController = navController
                    )
                }
            }
        }
    }
}

@Composable
fun ShopCardItem(shop: ShopModel, navController: NavHostController) {


    Card(modifier = Modifier
        .clickable {
            clickOfCardToDetails(shop = shop, navController = navController)
        }
        .fillMaxWidth()
        .padding(5.sdp), elevation = 10.sdp) {
        Column(
            modifier = Modifier
                .padding(5.sdp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                modifier = Modifier
                    .size(150.sdp)
                    .padding(5.sdp)
                    .clip(RoundedCornerShape(10.sdp)),
                painter = rememberImagePainter(data = shop.image, builder = {
                    placeholder(com.shop.R.drawable.image_placeholder)
                    crossfade(2000)
                }),
                contentDescription = "Image Thumbnail"
            )

            Spacer(modifier = Modifier.height(5.sdp))

            Text(
                text = shop.name,
                fontSize = 20.ssp,
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.padding(5.sdp))

            Text(
                text = "${shop.price} $", fontSize = 17.ssp, color = Color.Black
            )

            Spacer(modifier = Modifier.padding(5.sdp))
        }
    }

}


fun clickOfCardToDetails(shop: ShopModel, navController: NavHostController?) {

    val shopping = ShopModel(shop.id, shop.image, shop.name, shop.description, shop.price)
    navController?.currentBackStackEntry?.savedStateHandle?.set(
        key = "shopping",
        value = shopping
    )
    navController?.navigate(route = RouteScreen.DETAIL_PAGE)

}



