package br.com.album_copa.configs

import com.cloudinary.Cloudinary
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CloudinaryConfig(
    @Value("\${cloudinary.cloud-name:default-cloud}") private val cloudName: String,
    @Value("\${cloudinary.api-key:default-key}") private val apiKey: String,
    @Value("\${cloudinary.api-secret:default-secret}") private val apiSecret: String
) {

    @Bean
    fun cloudinary(): Cloudinary {
        val config = mapOf(
            "cloud_name" to cloudName,
            "api_key" to apiKey,
            "api_secret" to apiSecret
        )
        return Cloudinary(config)
    }
}