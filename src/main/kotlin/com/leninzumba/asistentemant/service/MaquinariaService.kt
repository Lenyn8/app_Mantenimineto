
package com.leninzumba.asistentemant.service

import com.leninzumba.asistentemant.dto.ChangeNombre
import com.leninzumba.asistentemant.model.Maquinaria
import com.leninzumba.asistentemant.model.Tiempos
import com.leninzumba.asistentemant.repository.AreasRepository

import com.leninzumba.asistentemant.repository.MaquinariaRepository
import com.leninzumba.asistentemant.repository.TecnicosRepository
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
    @Autowired
    lateinit var tecnicosRepository: TecnicosRepository
    fun list (): List <Maquinaria>{
        return maquinariaRepository.findAll()

    }



    fun save(maquinaria: Maquinaria):Maquinaria{
        try {
            maquinaria.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("Campo MAQUINARIA no debe ser vacio")

            areasRepository.findById(maquinaria.areasId)
                ?: throw Exception("Campo MAQUINARIA no debe ser vacio")
            tecnicosRepository.findById(maquinaria.tecnicosId)
                ?: throw Exception("Campo MAQUINARIA no debe ser vacio")

            return maquinariaRepository.save(maquinaria)
        }

        catch (ex : Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }




    }

    fun updateOtherNombre (changeNombre: ChangeNombre): String?{
     val rowsUpdate=maquinariaRepository.setOtherNombre(changeNombre.nombre, changeNombre.nuevoNombre)

        return "${rowsUpdate} rows updated"
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
     //parametro de consulta
    fun getByModelo (modelo: Long): List<Maquinaria>? {
        return maquinariaRepository.getlistModelo(modelo)
    }
    fun getByNombre (nombre: String): List<Maquinaria>? {
        return maquinariaRepository. getlistNombre(nombre)
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

    fun validateSerialNumber (serial:String?): Boolean?{

        serial.takeIf { !it?.trim().isNullOrEmpty() }
            ?: throw Exception()

        if (serial?.substring(0, 3).equals("786"))
            return true

        return false




    }





}