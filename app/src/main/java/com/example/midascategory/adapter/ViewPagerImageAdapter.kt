package com.example.midascategory.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midascategory.R
import com.example.midascategory.model.ImageGallery


class ViewPagerImageAdapter(private val mList: List<ImageGallery>) :
    RecyclerView.Adapter<ViewPagerImageAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.images_holder, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]




        /*println(itemsViewModel.file)*/

        Glide.with(holder.imageview).load(itemsViewModel.file)
            .error(R.drawable.ic_launcher_background)
            .into(holder.imageview)


    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        var imageview: ImageView = itemView.findViewById(R.id.imgView)

    }
}