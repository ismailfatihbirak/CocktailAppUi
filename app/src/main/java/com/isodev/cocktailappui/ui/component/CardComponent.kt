package com.isodev.cocktailappui.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isodev.cocktailappui.R

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
                        painter = painterResource(R.drawable.icon_cocktail),
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
                    Image(painter = painterResource(R.drawable.icon_time), contentDescription = "")
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
                        painter = painterResource(R.drawable.icon_heart),
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
                Image(painter = painterResource(R.drawable.icon_cocktail_star), contentDescription = "")
            }
            Image(
                painter = painterResource(R.drawable.image_blue_moon),
                contentDescription = "",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .offset(x = 35.dp, y = (5).dp)
            )
        }
    }
}