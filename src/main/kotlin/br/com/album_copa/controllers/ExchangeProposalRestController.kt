package br.com.album_copa.controllers

import br.com.album_copa.models.dtos.ExchangeProposalDTO
import br.com.album_copa.services.ExchangeProposalService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping(value = ["/exchange-proposal"])
class ExchangeProposalRestController(
    private val service: ExchangeProposalService
) {

    @PostMapping
    fun add(@RequestBody dto: ExchangeProposalDTO) = service.add(dto)

    @GetMapping
    fun getAll() = service.getAll()
}