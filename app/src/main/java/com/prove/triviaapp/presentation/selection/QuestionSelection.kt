package com.prove.triviaapp.presentation.selection

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prove.triviaapp.domain.question.QuestionCategory
import com.prove.triviaapp.domain.question.QuestionDifficulty
import com.prove.triviaapp.domain.question.QuestionType
import com.prove.triviaapp.presentation.ui.theme.TriviaAppTheme

@Composable
fun QuestionSelection(
    modifier: Modifier = Modifier
) {
    var expandedDifficulty by remember { mutableStateOf(false) }
    var selectedDifficulty by remember { mutableStateOf<QuestionDifficulty?>(null) }

    var expandedType by remember { mutableStateOf(false) }
    var selectedType by remember { mutableStateOf<QuestionType?>(null) }

    var expandedCategory by remember { mutableStateOf(false) }
    var selectedCategory by remember { mutableStateOf<QuestionCategory?>(null) }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
    ) {
        Text(
            text = "TriviaApp",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(16.dp)
        )
        Spacer(modifier = Modifier.height(40.dp))
        // Dropdown for difficulty
        Text(text = "Selecione a dificuldade")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .clickable { expandedDifficulty = true }
        ) {
            Text(
                text = selectedDifficulty?.difficulty ?: "Selecione...",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
        DropdownMenu(
            expanded = expandedDifficulty,
            onDismissRequest = { expandedDifficulty = false }
        ) {
            QuestionDifficulty.values().forEach { difficulty ->
                DropdownMenuItem(
                    text = {
                        Text(text = difficulty.difficulty)
                    },
                    onClick = {
                    selectedDifficulty = difficulty
                    expandedDifficulty = false
                })
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Dropdown for type
        Text(text = "Selecione o tipo")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .clickable { expandedType = true }
        ) {
            Text(
                text = selectedType?.type ?: "Selecione...",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
        DropdownMenu(
            expanded = expandedType,
            onDismissRequest = { expandedType = false }
        ) {
            QuestionType.entries.forEach { type ->
                DropdownMenuItem(
                    text = {
                        Text(text = type.type)
                    },
                    onClick = {
                    selectedType = type
                    expandedType = false
                })
            }
        }

        Spacer(modifier = Modifier.height(20.dp))
        // Dropdown for category
        Text(text = "Selecione a categoria")
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.LightGray)
                .clickable { expandedCategory = true }
        ) {
            Text(
                text = selectedCategory?.name ?: "Selecione...",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
            )
        }
        DropdownMenu(
            expanded = expandedCategory,
            onDismissRequest = { expandedCategory = false }
        ) {
            QuestionCategory.entries.forEach { category ->
                DropdownMenuItem(
                    text = { Text(text = category.name)},
                    onClick = {
                    selectedCategory = category
                    expandedCategory = false
                })
            }
        }
        
        Spacer(modifier = Modifier.weight(1f))
        Button(

            onClick = {

            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("Buscar Perguntas",
                fontSize = 20.sp)
        }
    }
}

@Preview(showBackground = true,showSystemUi = true)
@Composable
fun GreetingPreview2() {
    TriviaAppTheme {
        QuestionSelection(Modifier)
    }
}