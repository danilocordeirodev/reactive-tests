package com.xama.reacttests.service

import com.xama.reacttests.model.Product
import com.xama.reacttests.repository.ProductRepository
import kotlinx.coroutines.flow.toList
import org.springframework.cache.annotation.Cacheable
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class ProductService(
    private val repository: ProductRepository
) {
    suspend fun findAll(): List<Product> = repository
        .findAll()
        .toList()


    suspend fun save(product: Product): UUID {
        return repository
            .save(product)
    }

    @Cacheable("productsCache", key = "#id")
    suspend fun get(id: UUID): Product? = repository
        .get(id)
}