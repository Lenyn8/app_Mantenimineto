
package com.leninzumba.asistentemant.service

import com.leninzumba.asistentemant.model.Maquinaria
import com.leninzumba.asistentemant.repository.AreasRepository
import com.leninzumba.asistentemant.repository.MaquinariaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class MaquinariaService {
    @Autowired
    lateinit var maquinariaRepository: MaquinariaRepository

    @Autowired
    lateinit var areasRepository: AreasRepository




    fun list (): List <Maquinaria>{
        return maquinariaRepository.findAll()

    }

    fun save(maquinaria: Maquinaria):Maquinaria{
        try {
            maquinaria.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Campo MAQUINARIA no debe ser vacio")

            areasRepository.findById(areasId)

            return maquinariaRepository.save(maquinaria)
        }

        catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }




    }

    fun update (maquinaria: Maquinaria):Maquinaria {
        maquinariaRepository.findById(maquinaria.id) ?: throw  Exception()

        return maquinariaRepository.save(maquinaria)
    }

    fun delete (id:Long): Boolean{
        maquinariaRepository.deleteById(id)
        return true
    }

    fun getById (id: Long?):Maquinaria?{
        return maquinariaRepository.findById(id)
    }

    fun updateName (maquinaria: Maquinaria):Maquinaria {
        try {


            val response = maquinariaRepository.findById(maquinaria.id)
                ?: throw Exception("El id ${maquinaria.id} en PLANTA no existe")
            response.apply {
                this.nombre = maquinaria.nombre
            }
            return maquinariaRepository.save(maquinaria)
        }
        catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }



    }





}