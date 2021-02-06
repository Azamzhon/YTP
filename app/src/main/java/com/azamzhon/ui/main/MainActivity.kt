package com.azamzhon.ui.main

import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.NavHostFragment
import com.azamzhon.R
import com.azamzhon.core.BaseActivity
import com.azamzhon.extentions.getConnectivityManager
import com.azamzhon.extentions.isInternetConnected
import com.azamzhon.ui.playlist.PlaylistAdapter

const val API = "AIzaSyDr7WJvkOUCrqvY6dsVmV9hjCpxG-EYbiI"

class MainActivity : BaseActivity(R.layout.activity_main) {

    lateinit var adapter : PlaylistAdapter

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)
        checkForInternet()
    }

    private fun checkForInternet() {
        if (!isInternetConnected(getConnectivityManager(baseContext))){
            val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
            val navController = navHostFragment.navController
            navController.navigate(R.id.action_playlistFragment_to_noInternetFragment)
        }
    }
}