

package com.leninzumba.asistentemant.repository


import com.leninzumba.asistentemant.model.Tecnicos

import org.springframework.data.jpa.repository.JpaRepository

interface TecnicosRepository: JpaRepository <Tecnicos, Long> {

    fun findById (id:Long?): Tecnicos?



}