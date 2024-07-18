package cats.domain.repository

import cats.domain.model.CatModel

interface CatRepository {
    suspend fun getRandomCat(): CatModel

    suspend fun generateNewCat()
}