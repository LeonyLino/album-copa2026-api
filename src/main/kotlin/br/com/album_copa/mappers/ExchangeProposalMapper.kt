package br.com.album_copa.mappers

import br.com.album_copa.models.ExchangeProposalEntity
import br.com.album_copa.models.dtos.ExchangeProposalDTO


fun ExchangeProposalDTO.toEntity(): ExchangeProposalEntity = ExchangeProposalEntity(
    name = this.name,
    phoneNumber = this.phone,
    wanted = this.wanted,
    offered = this.offered,
)

fun ExchangeProposalEntity.toDto(): ExchangeProposalDTO = ExchangeProposalDTO(
    this.name,
    this.phoneNumber,
    this.wanted,
    this.offered,
)