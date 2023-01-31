package com.example.springbootpractice

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/hello")
    fun hello(name: String): String {
        return "hello : $name"
    }
}
