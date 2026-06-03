package br.com.album_copa.controllers

import br.com.album_copa.configs.security.jwt.JwtService
import br.com.album_copa.models.dtos.LoginRequest
import br.com.album_copa.models.dtos.LoginResponse
import org.springframework.security.authentication.AuthenticationManager
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthRestController(
    private val authenticationManager: AuthenticationManager,
    private val jwtService: JwtService,
) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        val auth = UsernamePasswordAuthenticationToken(
            request.email,
            request.password
        )

        val authenticated = authenticationManager.authenticate(auth)

        val principal = authenticated.principal
        val usernameStr: String = when (principal) {
            is UserDetails -> principal.username
            is String -> principal
            else -> principal?.toString() ?: ""
        }

        val token = jwtService.generateToken(request.email)

        return LoginResponse(token, usernameStr.split(" - ").getOrNull(1)?.toLongOrNull())
    }
}
