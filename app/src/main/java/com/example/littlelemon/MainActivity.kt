package com.example.littlelemon

import android.annotation.SuppressLint
import android.content.res.Configuration.ORIENTATION_LANDSCAPE
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.dp
import com.example.littlelemon.ui.theme.Pink80
import com.example.littlelemon.ui.theme.Purple80
import com.example.littlelemon.ui.theme.PurpleGrey80
import com.example.littlelemon.ui.theme.TopAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HomeScreen()
            //LoginScreen()
        }
    }
}

@Composable
fun AppScreen() {
    var count by rememberSaveable() {
        mutableStateOf(0)
    }
    counter(count, { count++ }, { count-- })
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen() {

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    ModalNavigationDrawer(drawerState = drawerState, drawerContent = {
        DrawerPanel(scope, drawerState)
    }) {
        Scaffold(
            topBar = { TopAppBar(scope, drawerState) }
        ) {
            Column(modifier = Modifier.padding(top = 100.dp)) {
                /*UpperPanel()
                LowerPanel()*/
                MenuContent(paddingValues = it)
            }
        }
    }
}

@Composable
fun MenuContent(paddingValues: PaddingValues) {
    val configuration = LocalConfiguration.current
    when(configuration.orientation){
        ORIENTATION_LANDSCAPE -> Column() {
            val menuPadding = 8.dp
            Row(modifier = Modifier.weight(0.5f)) {
                Text(
                    "Appetizers",
                    modifier = Modifier
                        .weight(0.25f)
                        .background(Purple80)
                        .padding(menuPadding)
                        .fillMaxHeight()
                )
                Text(
                    "Salads",
                    modifier = Modifier
                        .weight(0.25f)
                        .padding(menuPadding)
                        .fillMaxHeight()
                )
            }

            Row(modifier = Modifier.weight(0.5f)) {
                Text(
                    "Drinks",
                    modifier = Modifier
                        .weight(0.25f)
                        .background(Pink80)
                        .padding(menuPadding)
                        .fillMaxHeight()
                )
                Text(
                    "Mains",
                    modifier = Modifier
                        .weight(0.25f)
                        .background(PurpleGrey80)
                        .padding(menuPadding)
                        .fillMaxHeight()
                )
            }
        }
            else->     Surface(modifier = Modifier.padding(paddingValues)) {
                val menuPadding = 8.dp
                Column {
                    Text(
                        "Appetizers",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Purple80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Salads",
                        modifier = Modifier
                            .weight(0.25f)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Drinks",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(Pink80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                    Text(
                        "Mains",
                        modifier = Modifier
                            .weight(0.25f)
                            .background(PurpleGrey80)
                            .padding(menuPadding)
                            .fillMaxWidth()
                    )
                }
            }

    }
}


