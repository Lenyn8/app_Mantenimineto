package com.leninzumba.asistentemant.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class ProductServiceTest {
    @Autowired
    lateinit var productService: ProductServiceTest
    @Test
    fun multiplicacionWhenLessThanTen (){
        val response=productService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorThanTen (){
        val response=productService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }

    @Test
    fun validarSumaNui(){
        val response=productService.sumaValores("0301707030")
        Assertions.assertEquals(20,response)
    }
}
