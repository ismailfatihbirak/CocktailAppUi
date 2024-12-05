package com.isodev.cocktailappui.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.isodev.cocktailappui.data.model.CocktailCategoryModel

@Composable
fun CategoriesLazy(
    modifier: Modifier = Modifier,
    categoryItem: List<CocktailCategoryModel>
) {
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
                        painter = painterResource(it.cocktailImage),
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