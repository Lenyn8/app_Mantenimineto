package com.leninzumba.asistentemant.service


import com.leninzumba.asistentemant.model.Canchitas
import com.leninzumba.asistentemant.repository.CanchitasRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


@Service
class CanchitasService{

    @Autowired

    lateinit var canchitasRepository: CanchitasRepository

    fun save(canchitas: Canchitas): Canchitas {
        try {
            canchitas.nombre?.takeIf { it.trim().isNotEmpty() }
                ?: throw Exception("El nombre no debe ser vacio")



            return canchitasRepository.save(canchitas)
        } catch (ex: Exception) {
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex)
        }
    }

    fun list ():List<Canchitas>{
        return canchitasRepository.findAll()
    }

    fun getByNombre (nombre: String?):List<Canchitas>?{
        return canchitasRepository.getlistNombre(nombre)
    }

    fun getByHora (hora: String?):List<Canchitas>?{
        return canchitasRepository.getlistHora(hora)
    }

    fun getByCancha (cancha: String?):List<Canchitas>?{
        return canchitasRepository.getlistCancha(cancha)
    }

    fun updateName(canchitas: Canchitas): Canchitas{
        try {
            val response = canchitasRepository.findById(canchitas.id)
                ?: throw Exception("El id ${canchitas.id} del docente no existe")
            response.apply {
                this.nombre = canchitas.nombre
            }
            return canchitasRepository.save(canchitas)
        }
        catch (ex: Exception){
            throw ResponseStatusException(
                HttpStatus.NOT_FOUND, ex.message, ex
            )
        }

    }
}