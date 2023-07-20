package com.shop.navgraph

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.shop.details.ShopOfDetails
import com.shop.home.ShopOfHome
import com.shop.home.ShopViewModel
import com.shop.route.RouteScreen

@Composable
fun NavGraphOfPage(shopViewModel: ShopViewModel, navController: NavHostController) {


    NavHost(navController = navController, startDestination = RouteScreen.HOME_PAGE, builder = {
        composable(route = RouteScreen.HOME_PAGE) {
            ShopOfHome(shopViewModel = shopViewModel, navController = navController)
        }
        composable(route = RouteScreen.DETAIL_PAGE) {
            ShopOfDetails(navController)
        }
    })

}