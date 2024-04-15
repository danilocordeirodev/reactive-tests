package com.xama.reacttests.controller

import com.xama.reacttests.model.Product
import com.xama.reacttests.model.SaveProduct
import com.xama.reacttests.service.ProductService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.UUID

@RestController
class SaveProductController(
    private val service: ProductService
) {
    @PostMapping("/api/v1")
    suspend fun save(@RequestBody saveProduct: SaveProduct): ResponseEntity<UUID> = service
        .save(Product(UUID.randomUUID(), saveProduct.name))
        .let { ResponseEntity(it, HttpStatus.CREATED) }
}