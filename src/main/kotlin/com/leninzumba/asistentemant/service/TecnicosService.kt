
package com.leninzumba.asistentemant.service


import com.leninzumba.asistentemant.model.Tecnicos

import com.leninzumba.asistentemant.repository.TecnicosRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class TecnicosService {


    @Autowired
    lateinit var tecnicosRepository: TecnicosRepository
    fun list (): List <Tecnicos>{
        return tecnicosRepository.findAll()

    }

    fun save (tecnicos: Tecnicos): Tecnicos{
        try {
            tecnicos.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Campo TECNICOS no debe ser vacio")

            return tecnicosRepository.save(tecnicos)
        }

        catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }

    fun update (tecnicos: Tecnicos):Tecnicos {
        tecnicosRepository.findById(tecnicos.id) ?: throw  Exception()

        return tecnicosRepository.save(tecnicos)
    }

    fun updateName (tecnicos: Tecnicos): Tecnicos {
        try {


            val response = tecnicosRepository.findById(tecnicos.id)
                ?: throw Exception("El id ${tecnicos.id} en TECNICOS no existe")
            response.apply {
                this.nombre = tecnicos.nombre
            }
            return tecnicosRepository.save(tecnicos)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }


    }


    fun delete (id:Long): Boolean{
        tecnicosRepository.deleteById(id)
        return true
    }

    fun multiplicacion(coeficiente: Int, digito: Int): Int {
        val response = coeficiente * digito
        if (response >= 10)
            return response - 9
        return response

    }


    fun sumaValores (nui: String): Long {
        var sum: Long = 0
        for (i in 0..8) {
            val coeficiente = if (i % 2 == 0) 2 else 1
            sum += multiplicacion(coeficiente, Integer.parseInt(nui[i].toString()))
        }
        return sum
    }

    fun findDecenaSuperior(sum: Int): Int {//sum=20
        val division: Int = sum / 10 //2
        val decenaSuperior: Int = (division + 1) * 10
        var response: Int = decenaSuperior - sum
        if (decenaSuperior == 10)
            response = 0
        return response

    }

    fun ultimoDigito(cedula: String): Int {
        val ultimo = cedula.last().toString()
        val response = Integer.parseInt(ultimo)
        return response
    }


    fun validarTotal(cedula: String):Boolean{
        val suma=sumaValores(cedula).toInt()
        val resto=findDecenaSuperior(suma)
        val ultimoDigito=ultimoDigito(cedula)
        return resto ==ultimoDigito

    }





}