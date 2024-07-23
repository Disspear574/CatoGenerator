package cats.data.remote

import cats.data.remote.dto.CatDto
import retrofit2.http.GET

const val BASE_URL = "https://api.thecatapi.com/"

interface CatsApi {

    @GET("/v1/images/search")
    suspend fun getRandomCat(): CatDto
}
