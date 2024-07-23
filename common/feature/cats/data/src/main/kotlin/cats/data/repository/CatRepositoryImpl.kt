package cats.data.repository

import cats.data.mappers.toDomain
import cats.data.remote.CatsApi
import cats.domain.model.CatModel
import cats.domain.repository.CatRepository
import javax.inject.Inject

class CatRepositoryImpl @Inject constructor(
    private val api: CatsApi
) : CatRepository {
    override suspend fun getRandomCat(): CatModel = api.getRandomCat().toDomain()

    override suspend fun generateNewCat() {
        getRandomCat()
    }
}
