package net.omar.gonzalez.meli.challenge.ui.model

import android.os.Parcelable
import net.omar.gonzalez.meli.challenge.R
import kotlinx.parcelize.Parcelize

@Parcelize
sealed class SearchCustomModel(
    val showSearchButton: Boolean = true,
    val showBackButton: Boolean = false,
    val showDeleteButton: Boolean = false,
    val backGroundColor: Int = R.color.colorApp
) : Parcelable {

    object MainView: SearchCustomModel()

    object SearchView: SearchCustomModel(
        showBackButton = true,
        showSearchButton = false,
        showDeleteButton = true,
        backGroundColor = R.color.white
    )
}

fun getViewType(isMain: Boolean): SearchCustomModel {
    return when (isMain) {
        true -> SearchCustomModel.MainView
        false -> SearchCustomModel.SearchView
    }
}