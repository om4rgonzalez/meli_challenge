package net.omar.gonzalez.meli.challenge.ui.productdetail

import android.content.Context
import android.content.Intent
import android.graphics.Paint
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import androidx.viewpager2.widget.ViewPager2
import net.omar.gonzalez.meli.challenge.R
import net.omar.gonzalez.meli.challenge.data.api.model.Resource
import net.omar.gonzalez.meli.challenge.data.api.model.response.Attribute
import net.omar.gonzalez.meli.challenge.data.api.model.response.Picture
import net.omar.gonzalez.meli.challenge.data.api.model.response.Product
import net.omar.gonzalez.meli.challenge.databinding.ActivityProductDetailBinding
import net.omar.gonzalez.meli.challenge.repository.SearchRepository
import net.omar.gonzalez.meli.challenge.ui.base.BaseViewActivity
import net.omar.gonzalez.meli.challenge.ui.model.getViewType
import net.omar.gonzalez.meli.challenge.ui.search.SearchActivity
import net.omar.gonzalez.meli.challenge.utils.getViewModel
import net.omar.gonzalez.meli.core.extensions.stroke
import net.omar.gonzalez.meli.core.extensions.toMoneyFormat
import java.lang.Math.abs

class ProductDetailActivity: BaseViewActivity() {

    companion object {
        const val PRODUCT_ID =
            "net.omar.gonzalez.meli.challenge.ui.productlist.productid"

        fun getIntent(
            context: Context,
            productId: String
        ): Intent {
            val intent = Intent(context, ProductDetailActivity :: class.java).apply {
                putExtra(PRODUCT_ID, productId)
            }
            return intent
        }
    }

    private val NEW = "new"
    private val Q_MAX_FEATURES_TO_SHOW = 5


    private val viewModel: ProductDetailViewModel by lazy {
        getViewModel {
            ProductDetailViewModel(
                SearchRepository()
            )
        }
    }

    lateinit var binding: ActivityProductDetailBinding
    private lateinit var handler : Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProductDetailBinding.inflate(
            layoutInflater,
            baseBinding.baseContainer,
            true
        )
        binding.searchView.setupView(getViewType(true))
        handler = Handler(Looper.myLooper()!!)

        binding.slider.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                handler.removeCallbacks(runnable)
                handler.postDelayed(runnable , 2500)
            }
        })

        setupView()
        setupObservable()
    }

    override fun onPause() {
        super.onPause()

        handler.removeCallbacks(runnable)
    }

    override fun onResume() {
        super.onResume()

        handler.postDelayed(runnable , 2000)
    }

    private fun setupView() {
        binding.searchView.onEditTextClickListener {
            startActivity(
                SearchActivity.getIntent(
                    this,
                    getViewType(false)
                )
            )
            finish()
        }
    }

    private fun setupObservable() {
        intent.getStringExtra(PRODUCT_ID)?.let { productId ->
            showProgress(true)
            viewModel.getProductDetail(productId).observe(this) {response ->
                when(response) {
                    is Resource.Success -> {
                        loadValues(response.values)
                        showProgress(false)
                    }
                    else -> {
                        Log.d("DETAIL", "ERROR")
                    }
                }
            }
        }
    }

    private fun loadValues(product: Product) {
        with(binding) {
            productName.text = product.title
            productStatus.text = getString(
                R.string.product_status_selled,
                getProductStatus(product.condition),
                product.sold_quantity.toString()
            )

            product.original_price?.let { originalPrice ->
                oldPrice.text = getString(
                    R.string.old_price_text,
                    originalPrice.toString().toMoneyFormat()
                )
                oldPrice.stroke()
                oldPrice.isVisible = true
            }

            price.text = product.price.toString().toMoneyFormat()
            paymentMethods.isVisible = product.non_mercado_pago_payment_methods.isNotEmpty()
            quantityButton.text = getString(
                R.string.available_quantity_text_button,
                product.available_quantity.toString()
            )
            showFeatures(product.attributes.filterNot {
                    attribute -> attribute.value_id?.equals("-1") ?: false
            })

            sharedButton.setOnClickListener {
                startActivity(
                    Intent(Intent.ACTION_SEND).apply {
                        setType("text/plain")
                        putExtra(Intent.EXTRA_TEXT, product.permalink)
                    }
                )
            }
        }



        setupSlider(product.pictures)
    }

    private fun showFeatures(features: List<Attribute>) {
        var i = 0
        with(binding) {
            while (i < features.size && i < Q_MAX_FEATURES_TO_SHOW) {
                when(i) {
                    0 -> {
                        productDetailBullet1.visibility = View.VISIBLE
                        productDetailText1.text = getString(
                            R.string.item_description,
                            features[i].name,
                            features[i].value_name
                        )
                        productDetailText1.visibility = View.VISIBLE
                    }
                    1 -> {
                        productDetailBullet2.visibility = View.VISIBLE
                        productDetailText2.text = getString(
                            R.string.item_description,
                            features[i].name,
                            features[i].value_name
                        )
                        productDetailText2.visibility = View.VISIBLE
                    }
                    2 -> {
                        productDetailBullet3.visibility = View.VISIBLE
                        productDetailText3.text = getString(
                            R.string.item_description,
                            features[i].name,
                            features[i].value_name
                        )
                        productDetailText3.visibility = View.VISIBLE
                    }
                    3 -> {
                        productDetailBullet4.visibility = View.VISIBLE
                        productDetailText4.text = getString(
                            R.string.item_description,
                            features[i].name,
                            features[i].value_name
                        )
                        productDetailText4.visibility = View.VISIBLE
                    }
                    4 -> {
                        productDetailBullet5.visibility = View.VISIBLE
                        productDetailText5.text = getString(
                            R.string.item_description,
                            features[i].name,
                            features[i].value_name
                        )
                        productDetailText5.visibility = View.VISIBLE
                    }
                }
                i++
            }
        }
    }

    private fun setupSlider(pictures: List<Picture>) {

        binding.slider.let {slider ->
            slider.adapter = PicturesAdapter(
                pictures,
                this@ProductDetailActivity
            )

            slider.offscreenPageLimit = 1
            slider.clipToPadding = false
            slider.clipChildren = false
            slider.getChildAt(0).overScrollMode = RecyclerView.OVER_SCROLL_NEVER
        }

        setupTransformer()
    }

    private fun setupTransformer(){
        val transformer = CompositePageTransformer()
        transformer.addTransformer(MarginPageTransformer(40))
        transformer.addTransformer { page, position ->
            val r = 1 - abs(position)
            page.scaleY = 0.85f + r * 0.14f
        }

        binding.slider.setPageTransformer(transformer)
    }

    private fun showProgress(show: Boolean) {
        binding.loading.isVisible = show
    }

    private val runnable = Runnable {
        binding.slider.currentItem = binding.slider.currentItem + 1
    }

    private fun getProductStatus(condition: String): String = if (condition == NEW)
            getString(R.string.global_new)
    else
        getString(R.string.global_used)

}