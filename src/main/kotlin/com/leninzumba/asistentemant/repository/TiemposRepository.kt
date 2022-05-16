

package com.leninzumba.asistentemant.repository


import com.leninzumba.asistentemant.model.Tiempos

import org.springframework.data.jpa.repository.JpaRepository

interface TiemposRepository: JpaRepository <Tiempos, Long> {

    fun findById (id:Long?): Tiempos?



}