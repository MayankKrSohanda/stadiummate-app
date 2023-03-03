package com.stadiummate

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
private fun ThirdUmpireCard(
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
            .width(343.dp)
            .height(388.dp)
            .padding(horizontal = 16.dp)
    ) {
        Column(modifier = Modifier.fillMaxSize(1f)) {
            Text(
                text = "233 votes",
                style = MaterialTheme.typography.caption.copy(fontSize = 14.sp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp)
            )
            Image(
                painterResource(id = R.drawable.third_umpire),
                contentDescription = null,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 2.dp)
                    .width(313.dp)
                    .height(192.dp)
            )
            Text(
                text = "Over 13.3",
                style = MaterialTheme.typography.caption.copy(fontSize = 14.sp),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )
            Text(
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 22.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                text = "Rohit Sharma took DRS"
            )
            Text(
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Light,
                    fontSize = 14.sp
                ),
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 2.dp),
                text = "Rohit appealed for DRS after umpire gave not out to Steve Smith"
            )
            Text(
                text = "Decision Pending",
                color = Color.Red,
                style = TextStyle(
                    fontFamily = FontFamily.Default,
                    fontWeight = FontWeight.Medium,
                    fontSize = 20.sp
                ),
                modifier = Modifier.padding(horizontal = 77.dp, vertical = 6.dp)
            )
        }
    }
    Row(modifier = Modifier.padding(horizontal = 35.dp, vertical = 6.dp), ) {
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(133.dp)
                .height(40.dp)
                .padding(horizontal = 4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF50BB25))
        ) {
            Text(text = "Not Out", color = Color.White)
        }
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .width(133.dp)
                .height(40.dp)
                .padding(horizontal = 4.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFFDC3546))
        ) {
            Text(text = "Out", color = Color.White)
        }
    }
}

@Composable
private fun HomeSection(
    title: String,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Column(modifier) {
        Text(
            text = title,
            style = MaterialTheme.typography.h5,
            color = Color(0xFF7267CB),
            modifier = Modifier
                .paddingFromBaseline(top = 40.dp, bottom = 8.dp)
                .padding(horizontal = 16.dp)
        )
        content()
    }
}

@Composable
private fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Spacer(Modifier.height(16.dp))
        HomeSection(
            title = "Third Umpire Mode",
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            ThirdUmpireCard()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Preview(showBackground = true)
@Composable
private fun ThirdUmpirePreview() {
    ThirdUmpireCard()
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