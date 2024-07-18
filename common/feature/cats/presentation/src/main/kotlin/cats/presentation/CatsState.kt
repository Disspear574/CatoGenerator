package cats.presentation

import androidx.compose.runtime.Immutable
import cats.domain.model.CatModel

@Immutable
data class CatsState(
    val cat: CatModel? = null,
    val error: String? = null
)