package com.laioffer.spotify.ui.home
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.laioffer.spotify.R
import com.laioffer.spotify.datamodel.Section

@Composable
fun HomeScreen(viewModel: HomeViewModel) {
    val uiState by viewModel.uiState.collectAsState()
    HomeScreenContent(uiState)
}
@Composable
fun HomeScreenContent(uiState: HomeUiState) {
    LazyColumn(modifier = Modifier.padding(16.dp)) {
        item {
            HomeScreenHeader()
        }

        when {
            uiState.isLoading -> {
                item {
                    LoadingSection(stringResource(id = R.string.screen_loading))
                }
            }
            else ->  {
                items(uiState.feed) { item ->
                    AlbumSection(section = item)
                }
            }
        }
    }
}

@Composable
private fun AlbumSection(section: Section) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Text(
            text = section.sectionTitle,
            style = MaterialTheme.typography.h5.copy(fontWeight = FontWeight.Bold),
            color = Color.White
        )
    }

}

@Composable
private fun LoadingSection(text: String) {
    Row(modifier = Modifier.padding(vertical = 8.dp)) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = Color.White
        )
    }
}
@Composable
fun HomeScreenHeader() {
    Column {
        Text(
            text = stringResource(id = R.string.menu_home),
            style = MaterialTheme.typography.h4,
            color = Color.White
        )
        Spacer(modifier = Modifier.height(16.dp))
    }
}