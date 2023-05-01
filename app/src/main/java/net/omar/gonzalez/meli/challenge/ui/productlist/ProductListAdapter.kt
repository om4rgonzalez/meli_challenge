package net.omar.gonzalez.meli.challenge.ui.productlist
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.data.api.model.response.Result
import net.omar.gonzalez.meli.challenge.databinding.ItemProductListBinding
import net.omar.gonzalez.meli.core.extensions.loadImage

class ProductListAdapter(
    val context: Context,
    val products: List<Result>
) : RecyclerView.Adapter<ProductListAdapter.Holder>() {

    inner class Holder(binding: ItemProductListBinding) :
        RecyclerView.ViewHolder(binding.root) {
            val productImage = binding.productImage
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListAdapter.Holder {
        return Holder(
            ItemProductListBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = products.size

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val product = products[position]

        holder.productImage.loadImage(
            product.thumbnail,
            context,
            R.drawable.ic_broken_image
        )

    }
}