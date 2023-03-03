package com.stadiummate

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.AndroidView
import com.google.firebase.auth.FirebaseAuth
import com.stadiummate.ui.theme.StadiumMateTheme

class HomeActivity : ComponentActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StadiumMateTheme {
                StadiumMateApp()
            }
        }
        auth = FirebaseAuth.getInstance()
    }
}

@Composable
fun MatchCardOne(
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(248.dp)
                .height(136.dp)
        ) {
            Text(
                "18th Match, Group B. ICC T20 World Cup",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(192.dp)
            ) {
                Image(
                    painterResource(id = R.mipmap.ic_ind),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(56.dp)
                )
                Text(
                    text = "India",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(192.dp)
            ) {
                Image(
                    painterResource(id = R.mipmap.ic_aus),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(56.dp)
                )
                Text(
                    text = "Australia",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
fun MatchCardTwo(
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Column(
            modifier = Modifier
                .width(248.dp)
                .height(136.dp)
        ) {
            Text(
                "19th Match, Group B. ICC T20 World Cup",
                style = MaterialTheme.typography.caption,
                modifier = Modifier.padding(horizontal = 4.dp, vertical = 2.dp)
            )
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(192.dp)
            ) {
                Image(
                    painterResource(id = R.mipmap.ic_zim),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(55.dp)
                        .padding(5.dp)
                )
                Text(
                    text = "Zimbabwe",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.width(192.dp)
            ) {
                Image(
                    painterResource(id = R.mipmap.ic_africa),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(55.dp)
                        .padding(5.dp)
                )
                Text(
                    text = "South Africa",
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
            }
        }
    }
}

@Composable
fun MatchCards(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        item { MatchCardOne() }
        item { MatchCardTwo() }
    }
}

@Composable
fun VideoCard(
    @DrawableRes drawable: Int,
    modifier: Modifier = Modifier
) {
    Card(shape = MaterialTheme.shapes.small, modifier = modifier) {
        Image(
            painterResource(id = drawable),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .width(297.dp)
                .height(152.dp)
        )
    }
}

@Composable
fun VideoCards(
    modifier: Modifier = Modifier
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        item { VideoCard(drawable = R.mipmap.ic_video_one) }
        item { VideoCard(R.mipmap.ic_video_two) }
    }
}

@Composable
fun UpdateCard(
    @DrawableRes drawable: Int,
    @StringRes caption: Int,
    @StringRes title: Int,
    @StringRes text: Int,
    modifier: Modifier = Modifier
) {
    Card(
        shape = MaterialTheme.shapes.small,
        modifier = modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .width(352.dp)
                .height(80.dp)
        ) {
            Image(
                painter = painterResource(drawable),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .width(108.dp)
                    .height(80.dp)
                    .padding(8.dp)
            )
            Column(modifier = Modifier.padding(horizontal = 8.dp)) {
                Text(
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.ExtraLight,
                        fontSize = 8.sp
                    ),
                    text = stringResource(caption)
                )
                Text(
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Bold,
                        fontSize = 10.sp
                    ),
                    text = stringResource(title)
                )
                Text(
                    style = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = 8.sp
                    ),
                    text = stringResource(text)
                )
            }
        }
    }
}

@Composable
fun UpdateCards(
    modifier: Modifier = Modifier
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 16.dp),
        modifier = modifier
    ) {
        item {
            UpdateCard(
                drawable = R.mipmap.ic_updates_image,
                caption = R.string.update_one_caption,
                title = R.string.update_one_title,
                text = R.string.update_one_text
            )
        }
        item {
            UpdateCard(
                drawable = R.mipmap.ic_updates_two,
                caption = R.string.update_two_caption,
                title = R.string.update_two_title,
                text = R.string.update_two_text
            )
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
            title = "Matches",
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            MatchCards()
        }
        Spacer(Modifier.height(16.dp))
        HomeSection(
            title = "Videos",
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            VideoCards()
        }
        Spacer(Modifier.height(16.dp))
        HomeSection(
            title = "Updates",
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            UpdateCards()
        }
        Spacer(Modifier.height(16.dp))
    }
}

@Composable
private fun StadiumMateTopAppBar(
    modifier: Modifier = Modifier,
) {
    TopAppBar(
        backgroundColor = Color(0xFF7267CB),
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
    val context = LocalContext.current
    BottomNavigation(
        backgroundColor = Color(0xFF7267CB),
        modifier = modifier,
        contentColor = Color.White,
    ) {
        BottomNavigationItem(
            label = { Text("Feed") },
            selected = true,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.feed),
                    contentDescription = null, Modifier.size(25.dp)
                )
            }
        )
        BottomNavigationItem(
            label = { Text("Watch Along") },
            selected = false,
            onClick = { /*TODO*/ },
            icon = {
                Icon(
                    painterResource(id = R.drawable.watch_party),
                    contentDescription = null, Modifier.size(25.dp)
                )
            }
        )
        BottomNavigationItem(
            label = { Text("Voice Party") },
            selected = false,
            onClick = { context.startActivity(Intent(context, VoicePartyActivity::class.java)) },
            icon = {
                Icon(
                    painterResource(id = R.drawable.mic),
                    contentDescription = null, Modifier.size(25.dp)
                )
            }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun BottomPreview() {
    StadiumMateApp()
}

@Composable
private fun FloatingButton(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    FloatingActionButton(
        onClick = { context.startActivity(Intent(context, MatchModeActivity::class.java)) },
        shape = CircleShape,
        backgroundColor = Color(0xFF7267CB),
        contentColor = Color.White,
        modifier = modifier
    ) {
        Icon(painterResource(id = R.drawable.match_mode), contentDescription = null)
    }
}


@Composable
private fun StadiumMateApp() {
    StadiumMateTheme {
        Scaffold(
            topBar = { StadiumMateTopAppBar() },
            bottomBar = { StadiumMateBottomNavigation() },
            floatingActionButton = { FloatingButton() },
        ) { padding ->
            HomeScreen(Modifier.padding(padding))
        }
    }
}

//@Composable
//fun BottomMatchCard(
//    modifier: Modifier = Modifier
//) {
//    Surface(
//        shape = MaterialTheme.shapes.small,
//        modifier = modifier
//            .width(248.dp)
//            .height(20.dp),
//        color = Color(0xFF7267CB)
//    ) {
//
//        Row(
//            modifier = Modifier.padding(horizontal = 10.dp)
//        ) {
////                Button(
////                    onClick = { /*TODO*/ },
////                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White)
////                ) {
////                    Text("Points Table")
////                }
////                Button(
////                    onClick = { /*TODO*/ },
////                    colors = ButtonDefaults.buttonColors(backgroundColor = Color.White),
////                    modifier = Modifier.padding(horizontal = 2.dp)
////                ) {
////                    Text("Schedule")
////                }
//            Text("Points Table", color = Color.White)
//            Text(
//                "Schedule",
//                modifier = Modifier.padding(horizontal = 16.dp),
//                color = Color.White
//            )
//        }
//    }
//}