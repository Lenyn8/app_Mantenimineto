package com.leninzumba.asistentemant.service

fun multiplicacion (coeficiente: Int, digito: Int): Int{
    val response =coeficiente*digito
    if (response >= 10)
        return response - 9
    return response

}


fun sumaValores (nui: String): Long {
    var sum: Long=0
    for ( i in 0..8) {
        val coeficiente = if(i%2 ==0) 2 else 1
        sum  += multiplicacion(coeficiente,Integer.parseInt(nui[i].toString()) )
    }
    return sum
}

fun findDecenaSuperior (sum: Long): Long { // buscar la decena superior

    return 1
}