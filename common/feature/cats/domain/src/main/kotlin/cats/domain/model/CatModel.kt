package cats.domain.model

import javax.annotation.concurrent.Immutable

@Immutable
data class CatModel(
    val image: String,
)
