package br.com.album_copa.controllers

import br.com.album_copa.models.dtos.CardRequest
import br.com.album_copa.models.dtos.CardResponse
import br.com.album_copa.services.CardService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.data.domain.Page
import org.springframework.data.domain.PageRequest
import org.springframework.web.bind.annotation.PathVariable

@RestController
@RequestMapping("/cards")
class CardRestController(
    val service: CardService
) {

    @PostMapping
    fun add(@RequestBody request: CardRequest) =
        service.save(request)


    @PostMapping("saveAll")
    fun addAll(@RequestBody cards: List<CardRequest>) =
        service.saveAll(cards)

    @GetMapping
    fun getAll(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "20") size: Int
    ): Page<CardResponse> = service.getAll(PageRequest.of(page, size))

    @GetMapping("/not-owned")
    fun getNotOwned(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "20") size: Int
    ): Page<CardResponse> = service.getAllIsOwnedFalse(PageRequest.of(page, size))

    @GetMapping("{code}/not-owned")
    fun getByCodeNotOwned(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "20") size: Int,
        @PathVariable code: String,
    ): Page<CardResponse> = service.getAllByCodeAndOwnedIsFalse(code, PageRequest.of(page, size))

    @GetMapping("/repeated")
    fun getAllRepeated(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "20") size: Int
    ): Page<CardResponse> = service.getAllByRepeatedIsTrue(PageRequest.of(page, size))

    @GetMapping("{code}/repeated")
    fun getByCodeRepeated(
        @RequestParam(value = "page", defaultValue = "0") page: Int,
        @RequestParam(value = "size", defaultValue = "20") size: Int,
        @PathVariable code: String,
    ): Page<CardResponse> = service.getAllByCodeAndRepeatedTrue(code, PageRequest.of(page, size))

    @GetMapping("/count")
    fun count() = service.getCountOwned()


}