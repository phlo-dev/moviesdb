package br.com.moviesv2.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import br.com.moviesv2.presentation.features.home.MoviesHomeScreen

const val MOVIES_HOME_ROUTE = "movies_home"
const val MOVIES_GRAPH_ROUTE = "movies_graph"

@Composable
fun MoviesNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    onBackClick: () -> Unit = { }
) {
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = MOVIES_GRAPH_ROUTE,
    ) {
        addHomeGraph(onBackClick)
    }
}

fun NavGraphBuilder.addHomeGraph(onBackClick: () -> Unit) {
    navigation(
        route = MOVIES_GRAPH_ROUTE,
        startDestination = MOVIES_HOME_ROUTE
    ) {
        composable(route = MOVIES_HOME_ROUTE) {
            MoviesHomeScreen(onBackClick = onBackClick)
        }
    }
}