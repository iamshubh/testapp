package com.paytm.fragmentpoc.ui

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.paytm.fragmentpoc.R
import com.paytm.fragmentpoc.common.Constant
import com.paytm.fragmentpoc.viewmodel.MovieViewModel

class MovieFragment : Fragment() {

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel
    private lateinit var list: RecyclerView
    private var callback: Callback? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is Callback) {
            callback = activity as Callback
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)

        list = view?.findViewById(R.id.rvList)!!

        init()
    }

    fun init() {
        viewModel.getAllMovies()

        viewModel.movies.observe(viewLifecycleOwner) { result ->
            Log.d(Constant.TAG, "$result")
            //view?.findViewById<TextView>(R.id.text)?.text = result.toString()

            list.apply {
                layoutManager = LinearLayoutManager(activity)
                adapter = MovieAdapter(result.results, callback!!)
                setHasFixedSize(true)
            }
        }
    }

    interface Callback {
        fun showDetails(id: Int)
    }

}