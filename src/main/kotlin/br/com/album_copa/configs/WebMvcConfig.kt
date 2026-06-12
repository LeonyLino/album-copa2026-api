package br.com.album_copa.configs

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class WebConfig : WebMvcConfigurer {

    companion object {
        const val INDEX_HTML_FORWARD = "forward:/index.html"
    }

    override fun addViewControllers(registry: ViewControllerRegistry) {

        registry.addViewController("/").setViewName(INDEX_HTML_FORWARD)

        registry.addViewController("/album").setViewName(INDEX_HTML_FORWARD)
        registry.addViewController("/trade/**").setViewName(INDEX_HTML_FORWARD)
        registry.addViewController("/login").setViewName(INDEX_HTML_FORWARD)

        registry.addViewController("/{spring:[^\\.]*}")
            .setViewName(INDEX_HTML_FORWARD)

        registry.addViewController("/**/{spring:[^\\.]*}")
            .setViewName(INDEX_HTML_FORWARD)
    }
}