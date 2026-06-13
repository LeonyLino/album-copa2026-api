package br.com.album_copa.services

import br.com.album_copa.mappers.toEntity
import br.com.album_copa.mappers.toResponse
import br.com.album_copa.models.dtos.CardRequest
import br.com.album_copa.models.dtos.CardResponse
import br.com.album_copa.repositories.CardRepository
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.data.domain.Sort
import org.springframework.stereotype.Service

@Service
class CardService(
    val repository: CardRepository
) {

    fun save(request: CardRequest) =
        repository.save(request.toEntity())


    fun saveAll(cards: List<CardRequest>) =
        repository.saveAll(cards.map { it.toEntity() })


    fun getAll(pageable: Pageable): Page<CardResponse> = repository.findAll(pageable).map { it.toResponse() }

    fun getAllSorted(pageable: Pageable): Page<CardResponse> =
        repository.findAll(
            PageRequest.of(
                pageable.pageNumber,
                pageable.pageSize,
                Sort.by("selection").ascending()
            )
        ).map { it.toResponse() }

    fun getAllIsOwnedFalse(pageable: Pageable): Page<CardResponse> =
        repository.findByOwnedIsFalse(pageable)?.map { it.toResponse() } ?: Page.empty()

    fun getAllByRepeatedIsTrue(pageable: Pageable): Page<CardResponse> =
        repository.findByRepeatedIsTrue(pageable)?.map { it.toResponse() } ?: Page.empty()

    fun getAllByCodeAndRepeatedTrue(code: String, page: Pageable): Page<CardResponse> =
        repository.findByCodeContainingAndRepeatedIsTrue(code, page)?.map { it.toResponse() } ?: Page.empty()

    fun getAllByCodeAndOwnedIsFalse(code: String, page: Pageable): Page<CardResponse> =
        repository.findByCodeContainingAndOwnedIsFalse(code, page)?.map { it.toResponse() } ?: Page.empty()

    fun getCountOwned(): Int = repository.countByOwnedIsTrue()

    fun setFlagOwnedTrue(cardId: Long) {
        val entity = repository.findById(cardId)
        entity.ifPresent {
            it.owned = !it.owned
            repository.save(it)
        }
    }

    fun setFlagRepeatedTrue(cardId: Long) {
        val entity = repository.findById(cardId)
        entity.ifPresent {
            it.repeated = !it.repeated
            repository.save(it)
        }
    }
}