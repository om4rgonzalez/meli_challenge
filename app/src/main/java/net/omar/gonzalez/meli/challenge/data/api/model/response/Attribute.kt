package net.omar.gonzalez.meli.challenge.data.api.model.response

data class Attribute(
    val attribute_group_id: String,
    val attribute_group_name: String,
    val id: String,
    val name: String,
    val source: Long? = 0,
    val value_id: String,
    val value_name: String,
    val value_struct: net.omar.gonzalez.meli.challenge.data.api.model.response.ValueStruct,
    val value_type: String,
    val values: List<net.omar.gonzalez.meli.challenge.data.api.model.response.Value>
)