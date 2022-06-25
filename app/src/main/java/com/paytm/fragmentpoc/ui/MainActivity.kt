package com.paytm.fragmentpoc.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.paytm.fragmentpoc.R

class MainActivity : AppCompatActivity(), MovieFragment.Callback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<MovieFragment>(R.id.fragment_container_view)
            }
        }
    }

    // ton show details
    fun showDetails() {

    }

    override fun showDetails(id: Int) {

        val frag = MovieDetailsFragment.newInstance(id)
        val tranx = supportFragmentManager.beginTransaction()
        tranx.add(R.id.fragment_container_view, frag)
        tranx.commitAllowingStateLoss()
    }
}