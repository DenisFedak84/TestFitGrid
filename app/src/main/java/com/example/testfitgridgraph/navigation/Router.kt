package com.example.testfitgridgraph.navigation

import com.example.testfitgridgraph.Screens
import com.github.terrakok.cicerone.Router


class Router: Router() {

//    fun openSplashScreen() {
//        newRootScreen(Screens.SplashScreen())
//    }
//
//    fun openHeroListScreen() {
//        newRootScreen(Screens.HeroesListScreen())
//    }
//
//    fun openHeroDetailsScreen(hero: Hero) {
//        navigateTo(Screens.HeroDetailsScreen(hero))
//    }

    fun goToDetailActivity(){
        navigateTo(Screens.Detail())
    }

    fun openDetailScreen() {
       newRootScreen(Screens.showDetailFragment())
    }

    fun openPreviewScreen() {
        replaceScreen(Screens.showPreviewFragment())
    }

    fun closeDetailActivity() {
        exit()
    }
}
