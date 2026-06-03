package br.com.album_copa.models.dtos

data class LoginRequest(
    val email: String,
    val password: String,
)

data class LoginResponse(
    val token: String,
    val customerId: Long?,
)
