package br.com.moviesv2.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import br.com.moviesv2.navigation.MoviesNavHost
import br.com.moviesv2.ui.theme.MoviesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoviesTheme {
                MoviesContainer()
            }
        }
    }
}


@Composable
private fun ComponentActivity.MoviesContainer(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
) {
    MoviesTheme {
        Surface(
            modifier = modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.surface),
        ) {
            MoviesNavHost(
                modifier = Modifier.fillMaxSize(),
                onBackClick = onBackPressedDispatcher::onBackPressed,
                navController = navController,
            )
        }
    }
}