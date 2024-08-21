package com.example.database_test_v2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.database_test_v2.data.Word
import com.example.database_test_v2.model.WordViewModel
import com.example.database_test_v2.ui.theme.Database_test_V2Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel:WordViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Database_test_V2Theme {
                WordDataEntry(viewModel)


            }
        }
    }
}

@Composable
fun WordDataEntry(viewModel: WordViewModel) {
    var id:Int = 1
    var text by remember{ mutableStateOf("") }

    //   val viewModel: StudentViewModel = viewModel(factory = StudentViewModel.factory)
    Column(verticalArrangement = Arrangement.Center, modifier = Modifier.padding(top = 60.dp, start = 20.dp, end = 20.dp, bottom = 20.dp)) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            keyboardActions = KeyboardActions.Default,
            textStyle = TextStyle(color = Color.Black, fontWeight = FontWeight.Bold)
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))


        Button(onClick = { viewModel.insert(Word(id,text))}) {
            Text(text = "Submit")
        }
    }
}

