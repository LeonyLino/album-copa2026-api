package br.com.album_copa.repositories

import br.com.album_copa.models.CardEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository

interface CardRepository : JpaRepository<CardEntity, Long> {

    fun findByOwnedIsFalse(pageable: Pageable): Page<CardEntity>
}