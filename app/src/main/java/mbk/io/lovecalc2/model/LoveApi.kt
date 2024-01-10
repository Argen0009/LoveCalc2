package mbk.io.lovecalc2.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface LoveApi {
    @GET("getPercentage")
    fun getLovePerc(
        @Query("fname") firstName: String,
        @Query("sname") secondName: String,
        @Header("X-RapidAPI-Key") key: String = "b222fac56cmsh96f7b06dc232303p1a0d69jsna405e07edfd4",
        @Header("X-RapidAPI-Host")host: String = "love-calculator.p.rapidapi.com"
    ) :Call<LoveModel>
}
