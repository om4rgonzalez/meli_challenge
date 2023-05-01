package net.omar.gonzalez.meli.challenge.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import net.omar.gonzalez.meli.challenge.BaseViewModelFactory


inline fun <reified T : ViewModel> Fragment.getViewModel(owner: ViewModelStoreOwner? = null, noinline creator: (() -> T)? = null): T {
    return if (creator == null)
        ViewModelProvider(owner ?: this).get(T::class.java)
    else
        ViewModelProvider(owner ?: this, BaseViewModelFactory(creator)).get(T::class.java)
}

inline fun <reified T : ViewModel> FragmentActivity.getViewModel(noinline creator: (() -> T)? = null): T {
        return if (creator == null)
            ViewModelProvider(this).get(T::class.java)
        else
            ViewModelProvider(this, BaseViewModelFactory(creator)).get(T::class.java)
    }