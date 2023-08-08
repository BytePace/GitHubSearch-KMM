import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import components.RepoTitle
import models.RepoDetails

@Composable
fun RepoDetailsScreen(
    details: RepoDetails,
    repoName: String,
    navigateBack: () -> Unit,
) {
    val scrollState = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = { RepoTitle(repoName) },
    ) { scaffoldPaddings ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(scaffoldPaddings)
                .verticalScroll(
                    state = scrollState
                )
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
                    .padding(top = 16.dp, bottom = 24.dp),
                textAlign = TextAlign.Center,
                fontSize = 20.sp,
                text = "Branch name: ${details.name}",
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.3f),
                    text = "Branch author",
                    fontSize = 16.sp,
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = details.branchAuthor
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = details.branchAuthorEmail
                    )
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxHeight()
                        .fillMaxWidth(0.3f),
                    text = "Branch committer",
                    fontSize = 16.sp,
                )

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                ) {
                    Text(
                        text = details.committer
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = details.committerEmail
                    )
                }
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row {
                Text(
                    text = "Last committed at:"
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = details.lastUpdatedAt.toString()
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row {
                Text(
                    text = "is Protected: ${details.isProtected}"
                )
            }
        }
    }
}