package com.example.shafy.dolabelkhedma.utils;

import android.content.Context;
import android.net.ConnectivityManager;

/**
 * Created by shafy on 20/03/2018.
 */

public class NetworksUtils {
    public static boolean isConnected(Context c) {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        return connectivityManager.getActiveNetworkInfo() != null;
    }
}
