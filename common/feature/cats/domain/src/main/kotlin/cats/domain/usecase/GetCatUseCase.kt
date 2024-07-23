package cats.domain.usecase

import cats.domain.model.CatModel
import cats.domain.repository.CatRepository
import javax.inject.Inject

class GetCatUseCase @Inject constructor(
    private val repository: CatRepository
) {
    suspend fun execute(): CatModel = repository.getRandomCat()
}
