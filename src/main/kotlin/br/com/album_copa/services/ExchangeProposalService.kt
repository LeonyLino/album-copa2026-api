package br.com.album_copa.services

import br.com.album_copa.mappers.toDto
import br.com.album_copa.mappers.toEntity
import br.com.album_copa.models.ExchangeProposalEntity
import br.com.album_copa.models.dtos.ExchangeProposalDTO
import br.com.album_copa.repositories.ExchangeProposalRepository
import org.springframework.stereotype.Service

@Service
class ExchangeProposalService(
    private val exchangeProposalRepository: ExchangeProposalRepository
) {

    fun add(dto: ExchangeProposalDTO): ExchangeProposalEntity =
        exchangeProposalRepository.save(dto.toEntity())

    fun getAll(): List<ExchangeProposalDTO> =
        exchangeProposalRepository.findAll().map { it.toDto() }

}