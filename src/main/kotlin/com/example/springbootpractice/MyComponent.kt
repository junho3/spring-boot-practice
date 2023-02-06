package com.example.springbootpractice

import com.example.config.Config
import org.springframework.context.annotation.Import
import org.springframework.stereotype.Component

@Retention(AnnotationRetention.RUNTIME)
@Target(AnnotationTarget.TYPE, AnnotationTarget.CLASS)
@Component
@Import(Config::class)
annotation class MyComponent()
