package com.stadiummate

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.stadiummate.ui.theme.StadiumMateTheme

class MatchModeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StadiumMateApp()
        }
    }
}

@Composable
private fun StadiumMateTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        backgroundColor = Color(0xFFDC3546),
        contentColor = Color.White,
        modifier = modifier
    ) {
        Box(modifier = modifier.fillMaxSize(1f)) {
            Icon(
                painterResource(id = R.drawable.subtract),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(32.dp)
                    .align(Alignment.CenterStart)
            )
            Text(text = "Match Mode", modifier = Modifier.align(Alignment.Center))
            Surface(
                shape = RoundedCornerShape(16.dp),
                modifier = Modifier
                    .align(Alignment.CenterEnd)
                    .padding(horizontal = 8.dp)
            ) {
                Text(
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Light,
                        fontSize = 12.sp
                    ),
                    text = "233 FanCoin     ",
                    modifier = Modifier
                        .padding(4.dp)
                        .align(Alignment.Center)
                )
                Image(
                    painterResource(id = R.mipmap.ic_star),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .padding(4.dp)
                        .size(15.dp)
                        .clip(CircleShape)
                        .align(Alignment.CenterEnd)
                )
            }
        }
    }
}

@Composable
private fun StadiumMateBottomNavigation(
    modifier: Modifier = Modifier
) {
    BottomNavigation(
        backgroundColor = Color(0xFFDC3546),
        modifier = modifier,
        contentColor = Color.White,
    ) {
        BottomNavigationItem(
            label = { Text("Engagements") },
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.watch_party),
                    contentDescription = null, Modifier.size(25.dp)
                )
            }
        )
        BottomNavigationItem(
            label = { Text("Moments") },
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.nft_icon),
                    contentDescription = null, Modifier.size(25.dp)
                )
            }
        )
    }
}

@Composable
private fun FloatingButton(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { context.startActivity(Intent(context, HomeActivity::class.java)) },
        shape = CircleShape,
        backgroundColor = Color(0xFFDC3546),
        modifier = modifier
    ) {
        Icon(painterResource(id = R.drawable.feed), contentDescription = null)
    }
}

@Composable
private fun StadiumMateApp() {
    StadiumMateTheme {
        Scaffold(
            topBar = { StadiumMateTopAppBar() },
            bottomBar = { StadiumMateBottomNavigation() },
            floatingActionButton = { FloatingButton() }
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewApp() {
    StadiumMateApp()
}