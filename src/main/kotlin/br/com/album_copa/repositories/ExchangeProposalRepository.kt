package br.com.album_copa.repositories

import br.com.album_copa.models.ExchangeProposalEntity
import org.springframework.data.jpa.repository.JpaRepository

interface ExchangeProposalRepository : JpaRepository<ExchangeProposalEntity, Long> {
}