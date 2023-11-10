package com.example.training.feature.intro.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.training.ui.Screens
import com.example.training.ui.theme.TrainingTheme

@Composable
fun IntroScreen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Hello World!", fontSize = 24.sp, color = Color.Red)
        Button(onClick = {
            navController.navigate(Screens.Second.route)
        }) {
            Text("go to next page")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TrainingTheme {
        IntroScreen(rememberNavController())
    }
}