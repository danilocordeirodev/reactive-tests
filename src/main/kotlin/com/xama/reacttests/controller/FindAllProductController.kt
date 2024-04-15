package com.xama.reacttests.controller

import com.xama.reacttests.model.Product
import com.xama.reacttests.service.ProductService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class FindAllProductController(private val service: ProductService) {

    @GetMapping("/api/v1")
    suspend fun findAll() : List<Product> = service
        .findAll()
}