package com.example.midascategory.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.midascategory.R
import com.example.midascategory.model.ImageGallery
import com.example.midascategory.model.ProductData
import com.example.midascategory.model.ResponseData


class ViewPagerTabAdapter(private val mList: List<ProductData>) :
    RecyclerView.Adapter<ViewPagerTabAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.webview, parent, false)


        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val itemsViewModel = mList[position]



        itemsViewModel.content?.let { holder.webview.loadData(it, "text/html", "UTF-8") };


    }

    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {


        var webview: WebView = itemView.findViewById(R.id.web)

    }
}