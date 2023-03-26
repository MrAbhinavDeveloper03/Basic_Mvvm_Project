package com.demo_by_abhinav.android_assignment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.demo_by_abhinav.android_assignment.model.Data_value
import com.demo_by_abhinav.android_assignment.databinding.AdapterMovieBinding
import com.squareup.picasso.Picasso

class MainAdapter : RecyclerView.Adapter<MainViewHolder>() {
    var movies = mutableListOf<Data_value>()
    fun setMovieList(movies: List<Data_value>) {
        this.movies = movies.toMutableList()
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = AdapterMovieBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }
    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {
        val movie = movies[position]
        holder.binding.name.text = "Name: "+movie.name
        holder.binding.realname.text = "Real Name: "+movie.realname
        holder.binding.team.text = "Team: "+movie.team
        holder.binding.createdby.text = "Created By:"+movie.createdby
        holder.binding.publisher.text = "Publisher: "+movie.publisher
        holder.binding.firstappearance.text = "First Appearance: "+movie.firstappearance
        holder.binding.bio.text = "Bio: "+movie.bio

//        Glide.with(Objects.requireNonNull(getContext())).load(profile_img)
//        .placeholder(R.drawable.unnatilog).signature(new ObjectKey(String.valueO
//        f(System.currentTimeMillis()))).into(user_img_card);

        Picasso.get().load(movie.imageurl).into(holder.binding.imageurl)
    }
    override fun getItemCount(): Int {
        return movies.size
    }
}
class MainViewHolder(val binding: AdapterMovieBinding) : RecyclerView.ViewHolder(binding.root) {
}