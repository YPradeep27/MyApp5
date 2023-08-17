package com.app.myapplication5.utilities.extensions

import android.app.NotificationManager
import android.content.Context
import android.net.ConnectivityManager
import android.widget.Toast

fun Context.isNetworkActive(): Boolean
{
    val connectivityManager = getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val activeNetwork = connectivityManager.activeNetworkInfo
    return activeNetwork != null && activeNetwork.isConnected
}

fun Context.isNetworkActiveWithMessage(): Boolean
{
    val isActive = isNetworkActive()

    if (!isActive) {
        Toast.makeText(applicationContext , "No Internet Connection" , Toast.LENGTH_LONG).show()
    }

    return isActive
}

fun Context.clearNotifications() {
    (getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager).cancelAll()
}