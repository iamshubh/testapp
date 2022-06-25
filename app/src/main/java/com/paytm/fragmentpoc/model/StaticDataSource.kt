package com.paytm.fragmentpoc.model

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.paytm.fragmentpoc.common.Constant
import com.phonepe.app.MovieResult

class StaticDataSource(private val context: Context) {

    fun getMovies() : MovieResult {
        val gson = Gson()
        val result : MovieResult = gson.fromJson(readFromAsset(), MovieResult::class.java)
        return result
    }

    private fun readFromAsset(): String {
        val fileName = "movie.json"
        val bufferReader = context.assets.open(fileName).bufferedReader()
        val data = bufferReader.use {
            it.readText()
        }
        Log.d(Constant.TAG, "readFromAsset$data")
        return data
    }
 }