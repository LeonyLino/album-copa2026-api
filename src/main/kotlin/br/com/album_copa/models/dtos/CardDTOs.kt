package br.com.album_copa.models.dtos

data class CardRequest(
    val code: String,
    val name: String,
    val team: String?,
    val imageUrl: String?,
    val qtd: Int?,
    val selection: String,
    val owned: Boolean? = null,
    val repeated: Boolean? = null,
)

data class CardResponse(
    val id: Long?,
    val code: String,
    val name: String,
    val team: String?,
    val imageUrl: String?,
    val qtd: Int?,
    val selection: String,
    val owned: Boolean,
    val repeated: Boolean,
)

