package net.omar.gonzalez.meli.challenge.ui.productdetail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.data.api.model.response.Picture
import net.omar.gonzalez.meli.challenge.databinding.ActivityProductDetailBinding
import net.omar.gonzalez.meli.challenge.databinding.ItemPictureBinding
import net.omar.gonzalez.meli.core.extensions.loadImage

class PicturesAdapter(
    private val pictureList: List<Picture>,
    private val context: Context
) : RecyclerView.Adapter<PicturesAdapter.Holder>() {

    inner class Holder(binding: ItemPictureBinding) : RecyclerView.ViewHolder(binding.root) {
        val picture = binding.picture
        val counter = binding.sliderCounter
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder = Holder(
            ItemPictureBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun getItemCount(): Int = pictureList.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.picture.loadImage(
            pictureList[position].secure_url ,
            context,
            R.drawable.ic_photo_camera
        )

        holder.counter.text = context.getString(
            R.string.slider_counter,
            (position + 1).toString(),
            itemCount.toString()
        )
    }
}