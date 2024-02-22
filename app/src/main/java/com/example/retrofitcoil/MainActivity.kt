package com.example.retrofitcoil

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.retrofitcoil.ui.theme.RetrofitCoilTheme
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import coil.compose.AsyncImage
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.lifecycle.viewmodel.compose.viewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RetrofitCoilTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val viewModel = viewModel {MainViewModel()}
                    MainScreen(viewModel)
                }
            }
        }
    }
}


@Composable
fun MainScreen(viewModel: MainViewModel) {

    Column( horizontalAlignment = Alignment.CenterHorizontally) {

        Row (verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Absolute.Center)

        {
            Text(text = "NASA Image app",
                Modifier
                    .padding(4.dp)
                    .size(200.dp, 80.dp)
                    .border(width = 4.dp, color = Color.Black),
                fontSize = 30.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center)
        }
        Row {
            Text(text = "Welcome to the Nasa Image app. This app makes a network call to api.nasa.gov" +
                    " using the APOD endpoint. It returns five random images.",
                Modifier
                    .padding(1.dp)
                    .size(400.dp, 80.dp)
                    .border(width = 1.dp, color = Color.Black),
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center)
        }
        Row {
            Text(text = "Click the thumbnails to view a larger image, click away to close the view",
                Modifier
                    .padding(1.dp)
                    .size(400.dp, 60.dp)
                    .border(width = 2.dp, color = Color.Black),
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center)
        }
        Button(onClick = { viewModel.getPhotos() }) {
            Image(painter = painterResource(id = R.drawable.nasa_logo),
                contentDescription =" Nasa image icon",
                modifier = Modifier.size(40.dp))

            Text(text = "Refresh Images",
                fontSize = 20.sp,
                fontWeight = FontWeight.ExtraBold,
                textAlign = TextAlign.Center)
        }

        Row (verticalAlignment = Alignment.CenterVertically){

            Text(text = "Click the URL 1 thumbnail ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            ImageScreen(viewModel.uiState1)
        }
        Row (verticalAlignment = Alignment.CenterVertically){

            Text(text = "Click the URL 2 thumbnail ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            ImageScreen(viewModel.uiState2)
        }
        Row (verticalAlignment = Alignment.CenterVertically){

            Text(text = "Click the URL 3 thumbnail ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            ImageScreen(viewModel.uiState3)
        }
        Row (verticalAlignment = Alignment.CenterVertically){

            Text(text = "Click the URL 4 thumbnail ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            ImageScreen(viewModel.uiState4)
        }
        Row (verticalAlignment = Alignment.CenterVertically){

            Text(text = "Click the URL 5 thumbnail ",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold)

            ImageScreen(viewModel.uiState5)
        }

    }
    // Other UI components

}

@Composable
fun ResultScreen(photos: String, modifier: Modifier= Modifier) {
    Box(contentAlignment = Alignment.Center, modifier = modifier)
    {
        Text(text = photos)
    }
}

@Composable
fun AsyncImageLoader(imageUrl: String, modifier: Modifier = Modifier) {
    AsyncImage(
        model = imageUrl,
        contentDescription = "Loaded Image",
        contentScale = ContentScale.FillBounds,
        error = painterResource(id = R.drawable.loading_img),
        modifier = modifier
    )
}

@Composable
fun ImageScreen(imageUrl: String) {
    var showDialog by remember { mutableStateOf(false) }

    // Image that opens a dialog on click
    AsyncImageLoader(
        imageUrl = imageUrl,
        modifier = Modifier
            .clickable { showDialog = true }
            //.size(100.dp) // Thumbnail size
            .height(100.dp)
            .width(100.dp)
            .padding(5.dp)
    )

    // Dialog with larger image
    if (showDialog) {
        Dialog(onDismissRequest = { showDialog = false }) {
            AsyncImageLoader(
                imageUrl = imageUrl,
                modifier =
                Modifier
                    .height(400.dp)
                    .width(400.dp)
                    .padding(5.dp)// Larger size
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ResultScreenPreview() {
    RetrofitCoilTheme {
        ResultScreen(stringResource(id = R.string.placeholder_result))
    }
}