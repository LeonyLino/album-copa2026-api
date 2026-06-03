package br.com.album_copa.models

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.Table

@Entity
@Table(name = "tb_cards")
data class CardEntity(
    @Column(nullable = false, unique = true)
    var code: String,

    @Column(nullable = false)
    var name: String,

    @Column
    var team: String? = null,

    @Column
    var imageUrl: String? = null,

    @Column
    var qtd: Int? = null,

    @Column(nullable = true)
    var selection: String,

    @Column(nullable = false)
    var owned: Boolean = false,

    @Column(nullable = false)
    var repeated: Boolean = false,
) : GenericEntity()

