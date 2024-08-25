package com.example.database_test_v2

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.rounded.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Share
import androidx.compose.material.icons.rounded.ArrowBack
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionLocalContext
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalFoundationApi::class)
@Composable
fun HomeScreen(onButtonClicked: ()->Unit){
        Scaffold(
            topBar = {
                TopAppBar(
                        colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.primaryContainer,
                        titleContentColor = MaterialTheme.colorScheme.primary,
                    ),
                    title = {
                        Text("Mentors Eduserv")
                    },
                   navigationIcon = {
                       IconButton(onClick = { /*TODO*/ }, modifier = Modifier.width(100.dp)) {
                           Icon(imageVector = Icons.AutoMirrored.Rounded.ArrowBack, contentDescription = "Back Button", modifier = Modifier.padding(start = 10.dp, end = 20.dp).width(100.dp).height(20.dp))

                       }

                                    },
                )
            },
            bottomBar = {
               NavigationBar(
                   modifier = Modifier.height(50.dp),
                   containerColor = MaterialTheme.colorScheme.surfaceVariant,
               ) {
                   NavigationBarItem(
                       selected = true,
                       onClick = { /*TODO*/ },
                       icon = {Icon(
                           imageVector = Icons.Default.Home,
                           contentDescription = null
                       )},
                       label = {Text("Home")}
                   )
                   NavigationBarItem(
                       selected = true,
                       onClick = { /*TODO*/ },
                       icon = {Icon(
                           imageVector = Icons.Default.Share,
                           contentDescription = null
                       )},
                       label = {Text("Share")}
                   )

               }
            },
            floatingActionButton = {
                FloatingActionButton(onClick = { onButtonClicked() }) {
                    Icon(Icons.Default.Add, contentDescription = "Add")
                }
            }
        ) { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding),
                verticalArrangement = Arrangement.spacedBy(16.dp),
            ) {

                Text(
                    modifier = Modifier.padding(8.dp),
                    text =
                    """
                    This is an example of a scaffold. It uses the Scaffold composable's parameters to create a screen with a simple top app bar, bottom app bar, and floating action button.

                    It also contains some basic inner content, such as this text.

                    You have pressed the floating action button  times.
                """.trimIndent(),
                )

                LazyRow( modifier = Modifier.fillMaxWidth(),verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(16.dp)) {

                   items(500){
                       index ->
                       Text(text = "Item: $index",modifier = Modifier
                           .fillMaxWidth()
                           .padding(8.dp)
                           .size(80.dp)
                           .border(
                               width = 3.dp,
                               color = Color.Gray,
                               shape = RoundedCornerShape(5.dp)
                           ), fontSize = 25.sp)
                                  }
                }



            }
        }
    }


@Composable
@Preview(showBackground = true)
fun HomeScreenPreview(){
    HomeScreen(onButtonClicked = {})
}