package com.paytm.fragmentpoc.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.paytm.fragmentpoc.common.DependencyProvider
import com.phonepe.app.MovieResult

class MovieViewModel : ViewModel() {

    private val _movies = MutableLiveData<MovieResult>()
    val movies: LiveData<MovieResult> = _movies

    fun getAllMovies() { // TODO make suspend function
        _movies.postValue(DependencyProvider.getRepository().getMovies())
    }
}