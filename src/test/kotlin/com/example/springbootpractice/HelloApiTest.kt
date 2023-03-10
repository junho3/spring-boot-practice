package com.example.springbootpractice

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.jdbc.core.JdbcTemplate

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
class HelloApiTest {
    @Test
    fun helloApi() {
        val restTemplate = TestRestTemplate()
        val parameter = "Spring"

        val response: ResponseEntity<String> =
            restTemplate.getForEntity("http://localhost:9090/app/hello?name={name}", String::class.java, parameter)

        assertThat(response.statusCode).isEqualTo(HttpStatus.OK)
        assertThat(response.headers.getFirst(HttpHeaders.CONTENT_TYPE)).startsWith(MediaType.TEXT_PLAIN_VALUE)
        assertThat(response.body).isEqualTo("*Hello ${parameter}*")
    }

    @Test
    fun failsHelloApi() {
        val restTemplate = TestRestTemplate()

        val response: ResponseEntity<String> =
            restTemplate.getForEntity("http://localhost:9090/app/hello?name=", String::class.java)

        assertThat(response.statusCode).isEqualTo(HttpStatus.INTERNAL_SERVER_ERROR)
    }
}
