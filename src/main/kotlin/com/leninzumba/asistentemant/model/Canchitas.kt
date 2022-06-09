package com.leninzumba.asistentemant.model



import javax.persistence.*

@Entity
@Table(name= "canchitas")
class Canchitas {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(updatable = false)
    var id: Long? = null
    var nombre: String? = null
    var hora: Long? = null
    var cancha: String? = null


}