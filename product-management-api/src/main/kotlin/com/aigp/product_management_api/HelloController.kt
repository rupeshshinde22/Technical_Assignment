package com.aigp.product_management_api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {

    @GetMapping("/he")
    fun hello(): String {
        return "Hello World!"
    }
}