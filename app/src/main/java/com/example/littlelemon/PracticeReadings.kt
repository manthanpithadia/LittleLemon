package com.example.littlelemon

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Practice(){
    var counter by remember { mutableStateOf(0) }
    var longCounter by remember { mutableStateOf(0) }
    Text(text = "Clicks: " + counter.toString() + "Long: " + longCounter.toString(),
        modifier = Modifier.combinedClickable(onClick = {counter++}, onLongClick = {longCounter++}))

}

@Preview()
@Composable
fun preview(){
    Practice()
}