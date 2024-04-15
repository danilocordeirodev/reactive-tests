package com.xama.reacttests.controller

import com.xama.reacttests.model.Product
import com.xama.reacttests.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class GetProductController(private val service: ProductService) {
    @GetMapping("/api/v1/{id}")
    suspend fun get(@PathVariable id: UUID): ResponseEntity<Product> = service
        .get(id)
        .let { ResponseEntity(it, HttpStatus.OK) }

}