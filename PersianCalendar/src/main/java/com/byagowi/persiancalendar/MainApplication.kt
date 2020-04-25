package com.byagowi.persiancalendar

import android.app.Application
import android.content.Context
import android.text.TextUtils
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.byagowi.persiancalendar.utils.initUtils

class MainApplication : MultiDexApplication() {
    private var mRequestQueue: RequestQueue? = null

    override fun onCreate() {
        super.onCreate()
        MainApplication.instance = this

        ReleaseDebugDifference.mainApplication(this)
        initUtils(applicationContext)




    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    ///////////////
//////////////////////////////////
    val requestQueue: RequestQueue?
        get() {
            if (mRequestQueue == null) {
                mRequestQueue = Volley.newRequestQueue(applicationContext)
            }
            return mRequestQueue
        }

    fun <T> addToRequestQueue(
        req: Request<T>,
        tag: String?
    ) {
        req.tag = if (TextUtils.isEmpty(tag)) TAG else tag
        requestQueue!!.add(req)
    }

    fun <T> addToRequestQueue(req: Request<T>) {
        req.tag = TAG
        requestQueue!!.add(req)
    }

    fun cancelPendingRequests(tag: Any?) {
        if (mRequestQueue != null) {
            mRequestQueue!!.cancelAll(tag)
        }
    }

    companion object {
        var instance: MainApplication? = null
            private set
        val TAG = MainApplication::class.java.simpleName
        fun getResourceString(resId: Int): String {
            return instance!!.getString(resId)
        }

    }

}