package net.omar.gonzalez.meli.challenge.data.api.model.response

data class SaleTerm(
    val id: String,
    val name: String,
    val value_id: String,
    val value_name: String,
    val value_struct: net.omar.gonzalez.meli.challenge.data.api.model.response.ValueStruct,
    val value_type: String,
    val values: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Value>
)