package br.com.album_copa.controllers

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class SpaController {

    @RequestMapping(
        value = [
            "/album",
            "/dashboard",
            "/trade",
            "/login"
        ]
    )
    fun redirect(): String {
        return "forward:/index.html"
    }
}