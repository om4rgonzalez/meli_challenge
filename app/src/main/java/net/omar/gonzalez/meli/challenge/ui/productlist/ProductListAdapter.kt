package net.omar.gonzalez.meli.challenge.ui.productlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.data.api.model.response.Result
import net.omar.gonzalez.meli.challenge.databinding.ItemProductListBinding
import net.omar.gonzalez.meli.core.extensions.loadImage
import net.omar.gonzalez.meli.core.extensions.toMoneyFormat
import kotlin.math.roundToInt

class ProductListAdapter(
    val context: Context,
    val products: List<Result>
) : RecyclerView.Adapter<ProductListAdapter.Holder>() {

    private var onItemClick: ((Result) -> Unit)? = null

    inner class Holder(binding: ItemProductListBinding) : RecyclerView.ViewHolder(binding.root) {
        val productImage = binding.productImage
        val productName = binding.productName
        val highlightedItem = binding.highlightItem
        val productPrice = binding.productPrice
        val discountText = binding.discountText
        val productPriceDetail = binding.productPriceDetail
        val freeShipText = binding.freeShipText
        val extraDetailText = binding.extraDetailText
        val container = binding.container
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

        with(holder) {
            productImage.loadImage(
                product.thumbnail,
                context,
                R.drawable.ic_broken_image
            )

            productName.text = product.title

            productPrice.text = product.price.toString().toMoneyFormat()

            freeShipText.isVisible = product.shipping.free_shipping

            product.original_price?.let { originalPrice ->
                discountText.text = context.getString(
                    R.string.discount_text,
                    getDiscount(
                        originalPrice.toString().toDouble(),
                        product.price
                    )
                )
                discountText.isVisible = true
            }

            product.seller?.let { seller ->
                extraDetailText.text = context.getString(
                    R.string.seller_by,
                    seller.nickname
                )
                extraDetailText.isVisible = true
            }

            container.setOnClickListener {
                onItemClick?.invoke(product)
            }
        }
    }

    private fun getDiscount(originalPrice: Double, actualPrice: Double): String =
        (((originalPrice - actualPrice) / originalPrice) * 100).roundToInt().toString()

    fun setOnItemClickListener(onItemClick: ((Result) -> Unit)? = null) {
        this.onItemClick = onItemClick
    }

}