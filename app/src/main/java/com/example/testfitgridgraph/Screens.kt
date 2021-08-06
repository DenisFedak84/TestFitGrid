package com.example.testfitgridgraph

import android.content.Intent
import com.example.testfitgridgraph.ui.DetailActivity
import com.example.testfitgridgraph.ui.DetailFragment
import com.example.testfitgridgraph.ui.PreviewFragment
import com.github.terrakok.cicerone.androidx.ActivityScreen
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {

    fun Detail() = ActivityScreen {
        Intent(it, DetailActivity::class.java)
    }

    fun showDetailFragment() = FragmentScreen {
        DetailFragment()
    }

    fun showPreviewFragment() =FragmentScreen {
        PreviewFragment()
    }
}