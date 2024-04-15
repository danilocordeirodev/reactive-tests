package com.xama.reacttests

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.ComponentScan
import org.springframework.transaction.annotation.EnableTransactionManagement

@SpringBootApplication
@ComponentScan
@EnableTransactionManagement
class ReactTestsApplication

fun main(args: Array<String>) {
	runApplication<ReactTestsApplication>(*args)
}
