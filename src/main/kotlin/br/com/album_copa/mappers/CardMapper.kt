package br.com.album_copa.mappers

import br.com.album_copa.models.CardEntity
import br.com.album_copa.models.dtos.CardRequest
import br.com.album_copa.models.dtos.CardResponse

fun CardEntity.toDTO(): CardResponse = CardResponse(
    id = this.id,
    code = this.code,
    name = this.name,
    team = this.team,
    imageUrl = this.imageUrl,
    qtd = this.qtd,
    selection = this.selection,
    owned = this.owned,
    repeated = this.repeated,
)

fun CardRequest.toEntity(): CardEntity = CardEntity(
    code = this.code,
    name = this.name,
    team = this.team,
    imageUrl = this.imageUrl,
    qtd = this.qtd ?: 0,
    selection = this.selection,
    owned = this.owned ?: false,
    repeated = this.repeated ?: false,
)

fun CardRequest.updateEntity(entity: CardEntity): CardEntity {
    entity.code = this.code
    entity.name = this.name
    entity.team = this.team
    entity.imageUrl = this.imageUrl
    entity.qtd = this.qtd
    entity.selection = this.selection
    entity.owned = this.owned ?: false
    entity.repeated = this.repeated ?: false
    return entity
}

fun CardEntity.toResponse(): CardResponse = CardResponse(
    id = this.id,
    code = this.code,
    name = this.name,
    team = this.team,
    imageUrl = this.imageUrl,
    qtd = this.qtd,
    selection = this.selection,
    owned = this.owned,
    repeated = this.repeated,
)

