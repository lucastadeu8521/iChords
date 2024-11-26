package com.example.lessonsapp


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView

class CarouselAdapter(private val imageResIds: List<Int>) :
    RecyclerView.Adapter<CarouselAdapter.CarouselViewHolder>() {


    inner class CarouselViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val carouselImage: AppCompatImageView = view.findViewById(R.id.carouselImage)

        fun bind(imageResId: Int) {

            carouselImage.setImageResource(imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarouselViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.image_carousel, parent, false)
        return CarouselViewHolder(view)
    }

    override fun onBindViewHolder(holder: CarouselViewHolder, position: Int) {
        holder.bind(imageResIds[position])
    }

    override fun getItemCount(): Int = imageResIds.size
}
