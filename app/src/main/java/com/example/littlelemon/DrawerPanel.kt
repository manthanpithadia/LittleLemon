package com.example.littlelemon

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.DrawerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DrawerPanel(scope: CoroutineScope, drawerState: DrawerState) {
    Column(modifier = Modifier.background(color = Color.White)) {
        List(10) {
            Text(
                text = "Item #{$it}",
                modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
            )
        }
        IconButton(onClick = {
             scope.launch {
                 drawerState.close()
             }
        }) {
            Icon(imageVector = Icons.Default.ExitToApp, contentDescription = "Close Icon")
        }
    }
}
