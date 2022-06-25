package com.paytm.fragmentpoc.ui

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.paytm.fragmentpoc.R
import com.paytm.fragmentpoc.common.Constant
import com.phonepe.app.Results

class MovieAdapter(val movies: List<Results>, val callback: MovieFragment.Callback) :
    RecyclerView.Adapter<MovieAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val inflatedView = LayoutInflater.from(parent.context).inflate(R.layout.row_movie, parent, false)
        return MovieViewHolder(inflatedView)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount(): Int {
        return movies.size
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.title)
        val desc: TextView = itemView.findViewById(R.id.desc)
        val image: ImageView = itemView.findViewById(R.id.image)

        fun bind(model: Results) {
            title.text = model.title
            desc.text = model.overview
            itemView.setOnClickListener {
                Log.d(Constant.TAG, "$model")
                callback.showDetails(adapterPosition)
            }
            Glide.with(itemView.context)
               // .load("https://image.shutterstock.com/image-vector/online-cinema-art-movie-watching-600w-586719869.jpg")
                .load(android.R.drawable.presence_video_away)
                .circleCrop()
                .into(image)
        }
    }
}