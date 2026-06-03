package br.com.album_copa.repositories

import br.com.album_copa.models.CardEntity
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository: JpaRepository<CardEntity, Long> {
}