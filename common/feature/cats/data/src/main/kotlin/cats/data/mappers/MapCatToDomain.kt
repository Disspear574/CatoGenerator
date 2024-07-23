package cats.data.mappers

import cats.data.remote.dto.CatDto
import cats.domain.model.CatModel

fun CatDto.toDomain(): CatModel {
    val image = this.first().url
    return CatModel(
        image = image
    )
}
