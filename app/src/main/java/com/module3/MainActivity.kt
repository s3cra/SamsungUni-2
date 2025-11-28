package com.module3

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import com.module3.ui.theme.Module3Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Module3Theme {
                Task1()
            }
        }
    }
}

data class ListItem(
    @DrawableRes val image: Int,
    val title: String,
    var description: MutableState<String>
)

@Composable
@Preview(showSystemUi = true)
fun Task1(){
    val cards = remember { mutableStateListOf(
        mutableStateOf(
            ListItem(R.drawable.ic_launcher_background, "title1", mutableStateOf("description1"))
        )
    ) }
    LazyColumn (modifier = Modifier.fillMaxWidth()) {
        items(items = cards){ item ->
            Card (modifier = Modifier.fillMaxWidth()
                .clickable{
                    item.value.description.value += "+"
                }) {
                Row (modifier = Modifier.fillMaxWidth()) {
                    Image( ImageVector.vectorResource(item.value.image), "image")

                    Column {
                        Text(item.value.title)
                        Text(item.value.description.value)
                    }
                }
            }
        }
    }
}