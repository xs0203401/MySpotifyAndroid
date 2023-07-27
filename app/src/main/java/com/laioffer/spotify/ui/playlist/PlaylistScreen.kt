package com.laioffer.spotify.ui.playlist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.laioffer.spotify.R
import com.laioffer.spotify.datamodel.Album

@Composable
fun PlaylistScreen(playlistViewModel: PlaylistViewModel) {
    val playlistUiState by playlistViewModel.uiState.collectAsState()

    PlaylistScreenContent(
        playlistUiState = playlistUiState
    )
}

@Composable
private fun PlaylistScreenContent(
    playlistUiState: PlaylistUiState
) {
    Column(modifier = Modifier.padding(16.dp)) {
        Cover(album = playlistUiState.album, isFavorite =  playlistUiState.isFavorite)
    }
}

@Composable
private fun Cover(
    album: Album,
    isFavorite: Boolean
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Box(modifier = Modifier.fillMaxWidth()) {
            Icon(
                painter = painterResource(
                    id = if (isFavorite) {
                        R.drawable.ic_favorite_24
                    } else {
                        R.drawable.ic_unfavorite_24
                    }
                ),
                contentDescription = null,
                tint = if (isFavorite) Color.Green else Color.Gray,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(28.dp)
            )


        }
    }
}