package com.example.springbootpractice

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.TestPropertySource
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.transaction.annotation.Transactional
import javax.sql.DataSource

@IntegrationTest
class DataSourceTest {
    @Autowired
    lateinit var dataSource: DataSource
    @Test
    fun connect() {
        val connection = dataSource.connection
        connection.close()
    }
}
