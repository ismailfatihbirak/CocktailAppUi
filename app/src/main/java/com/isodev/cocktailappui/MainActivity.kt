package com.isodev.cocktailappui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.util.lerp
import com.isodev.cocktailappui.ui.theme.CocktailAppUiTheme
import kotlin.math.absoluteValue

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CocktailAppUiTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MainScreen(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun MainScreen(modifier: Modifier = Modifier) {
    val categoryList = listOf(
        CategoryData(R.drawable.image1, "Cocktails", "50 mixes"),
        CategoryData(R.drawable.image2, "Mocktails", "39 mixes"),
        CategoryData(R.drawable.image3, "Shakes", "48 mixes"),
        CategoryData(R.drawable.image1, "Cocktails", "50 mixes"),
        CategoryData(R.drawable.image2, "Mocktails", "39 mixes"),
        CategoryData(R.drawable.image3, "Shakes", "48 mixes"),
    )
    Column(modifier = modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {}) {
                Image(painter = painterResource(R.drawable.top_icon), contentDescription = null)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.drinko_logo), contentDescription = null)
                Image(painter = painterResource(R.drawable.o), contentDescription = null)
            }
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.profile_image),
                    contentDescription = null
                )
            }
        }

        Image(
            painter = painterResource(R.drawable.i_want_learn_text),
            contentDescription = null,
            modifier = Modifier.padding(start = 26.dp, end = 26.dp)
        )
        SearchView("", {}, modifier = Modifier.padding(16.dp))
        SeeAllButton(R.drawable.categories, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        CategoriesLazy(categoryItem = categoryList)
        SeeAllButton(R.drawable.recent_mixes, modifier = Modifier.padding(top = 16.dp, bottom = 16.dp))
        Pager(modifier = Modifier
            .padding(bottom = 32.dp)
            .offset(x = (-64).dp)
            .fillMaxSize())
    }
}

@Composable
fun SearchView(
    query: String,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .height(40.dp)
            .shadow(
                elevation = 2.dp,
                shape = RoundedCornerShape(8.dp),
                clip = false
            )
            .background(Color.White, shape = RoundedCornerShape(8.dp))
            .padding(horizontal = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            contentAlignment = Alignment.CenterStart
        ) {
            if (query.isEmpty()) {
                Text(
                    text = "Search",
                    fontSize = 15.sp,
                    color = Color.Gray
                )
            }
            BasicTextField(
                value = query,
                onValueChange = onQueryChange,
                singleLine = true,
                textStyle = TextStyle(fontSize = 12.sp, color = Color.Black),
                modifier = Modifier.fillMaxWidth()
            )
        }
        Icon(
            imageVector = Icons.Default.Search,
            contentDescription = "Search Icon",
            tint = Color.Gray,
            modifier = Modifier.padding(end = 8.dp)
        )
    }
}


@Composable
fun CategoriesLazy(modifier: Modifier = Modifier, categoryItem: List<CategoryData>) {
    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = modifier
    ) {
        items(categoryItem) {
            Card(
                colors = CardColors(
                    containerColor = Color(0xFFFEF9E4),
                    contentColor = Color.Unspecified,
                    disabledContentColor = Color.Unspecified,
                    disabledContainerColor = Color.Unspecified,
                ),
                modifier = Modifier.size(width = 103.dp, height = 134.dp)
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxSize()
                ) {
                    Image(
                        painter = painterResource(it.image),
                        contentDescription = null,
                        modifier = Modifier.size(width = 71.dp, height = 66.dp)
                    )
                    Text(
                        text = it.cocktailName,
                        fontSize = 16.sp,
                        color = Color(0xFF1E2742)
                    )
                    Text(
                        text = it.cocktailMixes,
                        color = Color(0xFFFB7D8A),
                        fontSize = 13.sp
                    )
                }
            }
        }
    }
}


data class CategoryData(
    val image: Int,
    val cocktailName: String,
    val cocktailMixes: String,
)

@Composable
fun SeeAllButton(image: Int,modifier: Modifier) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(start = 18.dp, end = 18.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(painter = painterResource(image), contentDescription = null)
        OutlinedButton(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.outlinedButtonColors(
                contentColor = Color(0xFFFB7D8A)
            ),
            border = BorderStroke(1.dp, Color(0xFFFB7D8A).copy(alpha = 0.25f)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier.size(width = 75.dp, height = 27.dp),
            contentPadding = PaddingValues(0.dp)
        ) {
            Text(text = "See All", color = Color(0xFFFB7D8A), fontSize = 14.sp)
        }
    }

}

@Composable
fun LayeredCardDesign(
    modifier: Modifier,
    offsetY: Float
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier.fillMaxWidth()
    ) {
        Box(
            modifier = Modifier
                .offset(y = offsetY.dp)
                .size(width = 160.dp, height = 246.dp)
                .background(color = Color(0xFFF9E0E2), shape = RoundedCornerShape(16.dp))
        )
        Box(
            modifier = Modifier
                .offset(y = (offsetY / 2).dp)
                .size(width = 204.dp, height = 289.dp)
                .background(color = Color(0xFFFCBABA), shape = RoundedCornerShape(16.dp))
        )
        Box(
            modifier = Modifier
                .size(width = 248.dp, height = 334.dp)
                .background(color = Color(0xFFFB7D8A), shape = RoundedCornerShape(16.dp))
        ) {
            Column(
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(start = 14.dp, top = 18.dp),
                verticalArrangement = Arrangement.spacedBy(-17.dp)
            ) {
                Text(
                    "BLUE", fontSize = 47.sp, color = Color.White, fontFamily = FontFamily(
                        Font(R.font.anton, FontWeight.Normal),
                    )
                )
                Text(
                    "MOON",
                    fontSize = 47.sp,
                    color = Color.White.copy(alpha = 0.5f),
                    fontFamily = FontFamily(
                        Font(R.font.anton, FontWeight.Normal),
                    )
                )
            }
            Column(
                modifier = Modifier.align(Alignment.BottomStart),
                verticalArrangement = Arrangement.spacedBy(20.dp),
                horizontalAlignment = Alignment.Start
            ) {
                Row(
                    verticalAlignment = Alignment.Bottom,
                    modifier = Modifier.padding(start = 8.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.drink_image),
                        contentDescription = ""
                    )
                    Text(
                        "Mocktail",
                        fontSize = 20.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.raleway_semibold))
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 13.dp)
                ) {
                    Image(painter = painterResource(R.drawable.time_image), contentDescription = "")
                    Text(
                        "20 min",
                        modifier = Modifier.padding(start = 5.dp),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.raleway))
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 14.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.heart_image),
                        contentDescription = ""
                    )
                    Text(
                        "534",
                        modifier = Modifier.padding(start = 6.dp),
                        fontSize = 16.sp,
                        color = Color.White,
                        fontFamily = FontFamily(Font(R.font.raleway, FontWeight.Normal))
                    )
                }
                Spacer(modifier = Modifier.height(12.dp))

            }
            Column(
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(bottom = 20.dp, end = 16.dp),
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    "Easy",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .offset(x = (-8).dp),
                    fontSize = 16.sp,
                    color = Color.White,
                    fontFamily = FontFamily(Font(R.font.raleway, FontWeight.Normal))
                )
                Image(painter = painterResource(R.drawable.four_star), contentDescription = "")
            }
            Image(
                painter = painterResource(R.drawable.blue_moon_image),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 35.dp, y = (5).dp)
            )
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Pager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(pageCount = { 4 })

    HorizontalPager(
        state = pagerState,
        contentPadding = PaddingValues(horizontal = 75.dp),
    ) { page ->
        val pageOffset = (
                (pagerState.currentPage - page) + pagerState.currentPageOffsetFraction
                ).absoluteValue

        val offsetY = lerp(
            start = 80f,
            stop = 0f,
            fraction = pageOffset.coerceIn(0f, 1f)
        )

        val scale = lerp(
            start = 0.75f,
            stop = 1f,
            fraction = 1f - pageOffset.coerceIn(0f, 1f)
        )

        LayeredCardDesign(
            modifier = modifier
                .graphicsLayer {
                    scaleX = scale
                    scaleY = scale
                },
            offsetY = offsetY
        )
    }
}