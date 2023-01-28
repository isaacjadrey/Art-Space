package com.training.artspace

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.training.artspace.ui.theme.ArtSpaceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ArtSpaceTheme {
                ArtSpaceScreen()
            }
        }
    }
}

@Composable
fun ArtSpaceScreen() {

    var currentState by remember {
        mutableStateOf(1)
    }

    Surface(
        modifier = Modifier,
        color = MaterialTheme.colorScheme.background
    ) {
        when (currentState) {
            1 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art1,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_1_title,
                        nameID = R.string.artist_1_name,
                        yearId = R.string.art_work_1_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 6 },
                        onForward = { currentState = 2 }
                    )
                }
            }
            2 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art2,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_2_title,
                        nameID = R.string.artist_2_name,
                        yearId = R.string.art_work_2_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 1 },
                        onForward = { currentState = 3 })
                }
            }
            3 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art3,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_3_title,
                        nameID = R.string.artist_3_name,
                        yearId = R.string.art_work_3_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 2 },
                        onForward = { currentState = 4 })
                }
            }
            4 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art4,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_4_title,
                        nameID = R.string.artist_4_name,
                        yearId = R.string.art_work_4_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 3 },
                        onForward = { currentState = 5 })
                }
            }
            5 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art5,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_5_title,
                        nameID = R.string.artist_5_name,
                        yearId = R.string.art_work_5_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 4 },
                        onForward = { currentState = 6 })
                }
            }
            6 -> {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp)
                ) {
                    ArtWorkWall(
                        resourceDrawable = R.drawable.art6,
                        contentDescription = R.string.art_work_content_desc
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    ArtDescriptor(
                        titleId = R.string.art_work_6_title,
                        nameID = R.string.artist_6_name,
                        yearId = R.string.art_work_6_year
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    DisplayController(
                        onBackward = { currentState = 5 },
                        onForward = { currentState = 1 })
                }
            }
        }
    }
}

@Composable
fun ArtWorkWall(
    resourceDrawable: Int,
    contentDescription: Int
) {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(500.dp)
            .border(
                BorderStroke(2.dp, Color.Gray)
            ),
        shadowElevation = 10.dp
    ) {
        Image(
            painter = painterResource(
                id = resourceDrawable
            ),
            contentDescription = stringResource(id = contentDescription),
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .padding(20.dp)
        )
    }
}

@Composable
fun ArtDescriptor(
    titleId: Int,
    nameID: Int,
    yearId: Int
) {
    Surface(
        shadowElevation = 10.dp
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(text = stringResource(id = titleId), fontSize = 18.sp)
            Row {
                Text(
                    text = stringResource(id = nameID),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(text = stringResource(id = yearId), fontSize = 16.sp)
            }
        }
    }
}

@Composable
fun DisplayController(
    onBackward: () -> Unit,
    onForward: () -> Unit
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.Bottom
    ) {
        Button(onClick = onBackward) {
            Text(
                text = stringResource(id = R.string.previous),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp)
            )
        }
        Button(
            onClick = onForward
        ) {
            Text(
                text = stringResource(id = R.string.next),
                textAlign = TextAlign.Center,
                modifier = Modifier.width(100.dp)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ArtSpaceTheme {
        ArtSpaceScreen()
    }
}