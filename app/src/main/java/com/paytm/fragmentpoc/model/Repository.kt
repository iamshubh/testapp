package com.paytm.fragmentpoc.model

import com.phonepe.app.MovieResult

class Repository(val dataSource: StaticDataSource) {

    fun getMovies(): MovieResult {
        return dataSource.getMovies()
    }
}