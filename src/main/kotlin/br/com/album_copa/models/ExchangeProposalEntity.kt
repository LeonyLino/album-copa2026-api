package br.com.album_copa.models

import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_exchange_proposals")
data class ExchangeProposalEntity(
    var name: String,
    var phoneNumber: String,
    var wanted: String,
    var offered: String,
) : GenericEntity() {}
