package com.leninzumba.asistentemant.repository


import com.leninzumba.asistentemant.model.Canchitas
import com.leninzumba.asistentemant.model.Maquinaria

import org.springframework.data.jpa.repository.JpaRepository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param


interface CanchitasRepository: JpaRepository <Canchitas, Long> {


    fun findById(id: Long?): Canchitas?

    //parametros para consultar
    @Query(nativeQuery = true)
    fun getlistNombre(@Param("nombre") nombre: String?): List<Canchitas>?

    @Query(nativeQuery = true)
    fun getlistHora(@Param("hora") hora: Int?): List<Canchitas>?

    @Query(nativeQuery = true)
    fun getlistCancha(@Param("cancha") cancha: String?): List<Canchitas>?
}