package net.omar.gonzalez.meli.challenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import net.omar.gonzalez.meli.challenge.databinding.ActivitySplashBinding
import net.omar.gonzalez.meli.challenge.ui.MainSearchActivity

class SplashActivity : AppCompatActivity() {
    private val binding: ActivitySplashBinding by lazy {
        ActivitySplashBinding.inflate(layoutInflater)
    }
    lateinit var handler: Handler

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        executeAnimation()
    }

    private fun executeAnimation() {
        val animation: Animation = AnimationUtils.loadAnimation(this, R.anim.splash_anim)
        val animationText: Animation = AnimationUtils.loadAnimation(this, R.anim.animation_text)
        binding.imgSplash.animation = animation
        binding.textSplash.animation = animationText
        handler = Handler()
        handler.postDelayed({
            goToNext()
        } , 3000) // here we're delaying to startActivity after 3seconds
    }

    private fun goToNext() {
        startActivity(
            MainSearchActivity.getIntent(this)
        )
        finish()
    }
}