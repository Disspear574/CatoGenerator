package cats.presentation.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp

@Suppress("MagicNumber")
@Composable
internal fun RowScope.CatButton(title: String, image: ImageVector, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = Modifier.weight(0.4f),
        content = {
            Icon(imageVector = image, contentDescription = null)
            Spacer(modifier = Modifier.width(5.dp))
            Text(text = title)
        }

    )
}
