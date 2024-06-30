package com.example.littlelemon

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen() {

    var userName by rememberSaveable(){
        mutableStateOf("")
    }

    var password by rememberSaveable(){
        mutableStateOf("Hello")
    }
    val context =  LocalContext.current

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(
                id = R.drawable.littlelemonlogo
            ),
            contentDescription = "Logo Image",
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = userName,
            onValueChange = {userName = it},
            label = { Text(text = "Username") },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        TextField(
            value = password,
            onValueChange = {password = it},
            label = { Text(text = "Password") },
            modifier = Modifier.padding(vertical = 5.dp)
        )
        Button(
            onClick = { authCheck(context, userName = userName, password = password) },
            colors = ButtonDefaults.buttonColors(
                Color(0xFF495E57)
            ),
            modifier = Modifier.padding(vertical = 5.dp)
        ) {
            Text(
                text = "Login",
                color = Color(0xFFEDEFEE)
            )
        }
    }
}

fun authCheck(context:Context, userName: String, password: String){
    if(userName == "Darian" && password == "littleLemon"){
        Toast.makeText(context," Login successful",Toast.LENGTH_SHORT).show()
    }
    else{
        Toast.makeText(context," Invalid Credentials",Toast.LENGTH_SHORT).show()
    }
}

@Preview(showSystemUi = true)
@Composable
fun _preview() {
    LoginScreen()
}
