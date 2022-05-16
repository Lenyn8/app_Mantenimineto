

package com.leninzumba.asistentemant.model

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table (name= "tecnicos")

class Tecnicos {

    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Id
    @Column (updatable = false)
    var id: Long ? = null
    var nombre: String? = null
    var cedula: Long? = null




}