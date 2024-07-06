package com.example.littlelemon

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.littlelemon.Fragments.HomeScreen
import com.example.littlelemon.Fragments.LocationScreen
import com.example.littlelemon.Fragments.MenuScreen
import com.example.littlelemon.nav.Destinations
import com.example.littlelemon.nav.Home
import com.example.littlelemon.nav.Location
import com.example.littlelemon.nav.Menu

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp() {
    val navController = rememberNavController()
    Scaffold(bottomBar = { MyBottomAppBar(navController = navController) }) {
        Box(modifier = Modifier.padding(it)) {
            NavHost(navController = navController, startDestination = Home.route) {
                composable(Menu.route){
                    MenuScreen()
                }
                composable(Home.route){
                    HomeScreen()
                }
                composable(Location.route){
                    LocationScreen()
                }
            }
        }
    }


}

@Composable
fun MyBottomAppBar(navController: NavController) {
    val destinationList = listOf<Destinations>(Menu, Home, Location)
    val selectedIndex = rememberSaveable() {
        mutableStateOf(1)
    }
    NavigationBar {
        destinationList.forEachIndexed { index, destinations ->
            NavigationBarItem(
                label = { Text(text = destinations.title) },
                selected = index == selectedIndex.value,
                onClick = {
                    selectedIndex.value = index
                    navController.navigate(destinationList[index].route) {
                        popUpTo(Home.route)
                        launchSingleTop = true
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(id = destinationList[index].icon),
                        contentDescription = ""
                    )
                })
        }
    }
}


