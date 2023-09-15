package com.example.helloworld2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @Composable
    @Preview
    fun AppContent() {
        var isHello by remember { mutableStateOf(true) }
        var textFieldValue by remember { mutableStateOf(TextFieldValue("")) }

        Column {
            BasicTextField(
                value = textFieldValue,
                onValueChange = {
                    textFieldValue = it
                },
                modifier = Modifier.padding(16.dp)
            )
            Box(modifier = Modifier.weight(1f).padding(16.dp)) {
                Text(
                    text = when {
                        textFieldValue.text.isEmpty() -> {
                            if (isHello) "Hello World" else "Goodbye Darkness"
                        }
                        else -> "Hello ${textFieldValue.text}!"
                    },
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text("2", fontSize = 14.sp, color = Color.Black, modifier = Modifier.padding(top = 8.dp))
            }
            Button(onClick = {
                if (textFieldValue.text.isEmpty()) {
                    isHello = !isHello
                } else {
                    textFieldValue = TextFieldValue("")
                }
            }, modifier = Modifier.padding(16.dp)) {
                Text("Click me")
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                AppContent()
            }
        }
    }
}

