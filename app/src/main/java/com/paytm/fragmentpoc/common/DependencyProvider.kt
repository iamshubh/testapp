package com.paytm.fragmentpoc.common

import android.app.Application
import android.content.Context
import com.paytm.fragmentpoc.model.Repository
import com.paytm.fragmentpoc.model.StaticDataSource

object DependencyProvider {

    private var mAppContext: Context? = null
    private val application: Context
        get() = mAppContext!!

    private var repository: Repository? = null // add lazy

    fun inject(application: Application) {
        mAppContext = application
    }

    fun getRepository(): Repository {
        if (repository == null) {
            val dataSource = StaticDataSource(application)
            repository = Repository(dataSource)
        }
        return repository!!
    }

}