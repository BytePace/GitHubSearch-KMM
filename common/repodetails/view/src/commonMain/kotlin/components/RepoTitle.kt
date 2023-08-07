package components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
internal fun RepoTitle(repoName: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(vertical = 8.dp)
    ) {
        // Title
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            text = repoName,
            textAlign = TextAlign.Center,
            fontSize = 22.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        // Subtitle
        Text(
            modifier = Modifier
                .wrapContentHeight()
                .fillMaxWidth(),
            text = "repo name",
            textAlign = TextAlign.Center,
            fontSize = 16.sp,
        )
    }
}
