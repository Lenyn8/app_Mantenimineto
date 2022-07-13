package com.leninzumba.asistentemant.service

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class TecnicoServiceTest {

    @Autowired
    lateinit var tecnicosService: TecnicosService





    @Test
    fun multiplicacionWhenLessThanTen (){
        val response=tecnicosService.multiplicacion(1,7)
        Assertions.assertEquals(7,response)
    }

    @Test
    fun multiplicacionWhenMajorThanTen (){
        val response=tecnicosService.multiplicacion(2,7)
        Assertions.assertEquals(5,response)
    }

    @Test
    fun validarSumaNui(){
        val response=tecnicosService.sumaValores("0201207010")
        Assertions.assertEquals(14,response)
    }
    @Test
    fun validarDecenaSuperiorCuandoNoEsCero(){
        val response=tecnicosService.findDecenaSuperior(26)
        Assertions.assertEquals(4,response)
    }

    @Test
    fun validarDecenaSuperiorCuandoEsCero(){
        val response=tecnicosService.findDecenaSuperior(20)
        Assertions.assertEquals(10,response)
    }


    @Test
    fun validarCedulaValida(){
        val response=tecnicosService.findDecenaSuperior(20)
        Assertions.assertEquals(10,response)
    }
    @Test
    fun validarCedulaInValida(){
        val response=tecnicosService.findDecenaSuperior(20)
        Assertions.assertEquals(10,response)
    }

    @Test
    fun ultimoDigito (){
        val response=tecnicosService.ultimoDigito("0123654789")
        Assertions.assertEquals(9,response)
    }

    @Test
    fun ultimoDigitoNo (){
        val response=tecnicosService.ultimoDigito("0123654789")
        Assertions.assertEquals(9,response)
    }

    @Test
    fun ultimoDiigitoCedula (){
        val response=tecnicosService.validarTotal("0106430044")
        Assertions.assertEquals(true,response)
    }
    @Test
    fun ultimoDigitVali (){
        val response=tecnicosService.validarTotal("0106430048")
        Assertions.assertEquals(false,response)
    }

}
