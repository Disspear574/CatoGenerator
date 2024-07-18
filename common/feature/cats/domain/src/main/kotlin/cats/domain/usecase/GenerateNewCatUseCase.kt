package cats.domain.usecase

import cats.domain.repository.CatRepository
import javax.inject.Inject

class GenerateNewCatUseCase @Inject constructor(
    private val repository: CatRepository
) {
    suspend fun execute() = repository.generateNewCat()
}