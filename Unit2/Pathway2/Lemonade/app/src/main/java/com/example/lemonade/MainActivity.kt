package com.example.lemonade

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.lemonade.ui.theme.LemonadeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonadeTheme {
                LemonadeTheme {
                    LemonApp()
                }
            }
        }
    }
}

@Composable
fun LemonApp() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        var order = 1
        when (order) {
            1 -> LemonTextAndImage(
                textLabelId = R.string.lemon_select,
                drawableId = R.drawable.lemon_tree,
                descriptionId = R.string.lemon_tree_content_description,
                onImageClick = { order++ })
            2 -> LemonTextAndImage(
                textLabelId = R.string.lemon_squeeze,
                drawableId = R.drawable.lemon_squeeze,
                descriptionId = R.string.lemon_content_description,
                onImageClick = { order++ })
            3 -> LemonTextAndImage(
                textLabelId = R.string.lemon_drink,
                drawableId = R.drawable.lemon_drink,
                descriptionId = R.string.lemonade_content_description,
                onImageClick = { order++ })
            4 -> LemonTextAndImage(
                textLabelId = R.string.lemon_empty_glass,
                drawableId = R.drawable.lemon_restart,
                descriptionId = R.string.empty_glass_content_description,
                onImageClick = { order = 1 })
        }
    }
}

@Composable
fun LemonTextAndImage(
    textLabelId: Int,
    drawableId: Int,
    descriptionId: Int,
    onImageClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier.fillMaxSize()
    ) {
        Text(
            text = stringResource(id = textLabelId),
            fontSize = 18.sp
        )
        Spacer(modifier = Modifier.height(16.dp))
        Image(
            painter = painterResource(id = drawableId),
            contentDescription = stringResource(id = descriptionId),
            modifier = Modifier
                .wrapContentSize()
                .clickable(
                    onClick = onImageClick
                )
                .border(
                    BorderStroke(2.dp, Color(105, 205, 216)),
                    shape = RoundedCornerShape(4.dp)
                )
                .padding(16.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LemonadeTheme {
        LemonApp()
    }
}