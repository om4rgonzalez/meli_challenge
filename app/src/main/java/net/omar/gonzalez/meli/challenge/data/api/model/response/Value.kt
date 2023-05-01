package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Value(
    val id: String,
    val name: String,
    val results: Int,
    val path_from_root: List<net.omar.gonzalez.meli.challenge.data.api.model.response.PathFromRoot>? = null,
    val struct: net.omar.gonzalez.meli.challenge.data.api.model.response.Struct? = null
)