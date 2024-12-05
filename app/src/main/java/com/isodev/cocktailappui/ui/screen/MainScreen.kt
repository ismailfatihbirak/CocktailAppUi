package com.isodev.cocktailappui.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isodev.cocktailappui.R
import com.isodev.cocktailappui.data.model.CocktailCategoryModel
import com.isodev.cocktailappui.ui.component.CategoriesLazy
import com.isodev.cocktailappui.ui.component.SearchView
import com.isodev.cocktailappui.ui.component.SeeAllRow
import com.isodev.cocktailappui.ui.navigation.Pager


@Composable
fun MainScreen() {
    val context = LocalContext.current

    val categoryList = listOf(
        CocktailCategoryModel("Cocktails", R.drawable.image_cocktail1, "50 mixes"),
        CocktailCategoryModel("Mocktails", R.drawable.image_cocktail2, "39 mixes"),
        CocktailCategoryModel("Shakes", R.drawable.image_cocktail3, "48 mixes"),
        CocktailCategoryModel("Cocktails", R.drawable.image_cocktail1, "50 mixes"),
        CocktailCategoryModel("Mocktails", R.drawable.image_cocktail2, "39 mixes"),
        CocktailCategoryModel("Shakes", R.drawable.image_cocktail3, "48 mixes"),
    )
    Column(modifier = Modifier.background(Color.White)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight()
                .padding(start = 12.dp, end = 12.dp, top = 12.dp, bottom = 40.dp),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            IconButton(onClick = {}) {
                Image(painter = painterResource(R.drawable.icon_drawer), contentDescription = null)
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Image(painter = painterResource(R.drawable.image_logo_drink), contentDescription = null)
                Image(painter = painterResource(R.drawable.image_logo_o), contentDescription = null)
            }
            IconButton(onClick = {}) {
                Image(
                    painter = painterResource(R.drawable.image_profile),
                    contentDescription = null
                )
            }
        }

        Text(
            text = "I want to learn...",
            style = TextStyle(
                fontSize = 24.sp,
                color = Color.Black,
                fontFamily = FontFamily(Font(R.font.raleway_semibold))
            ),
            modifier = Modifier.padding(start = 26.dp, end = 26.dp)
        )
        SearchView("", {}, modifier = Modifier.padding(16.dp))
        SeeAllRow(
            context.getString(R.string.categories),
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        CategoriesLazy(categoryItem = categoryList)
        SeeAllRow(
            context.getString(R.string.recent_mixes),
            modifier = Modifier.padding(top = 16.dp, bottom = 16.dp)
        )
        Pager(
            modifier = Modifier
                .padding(bottom = 32.dp)
                .offset(x = (-64).dp)
                .fillMaxSize()
        )
    }
}