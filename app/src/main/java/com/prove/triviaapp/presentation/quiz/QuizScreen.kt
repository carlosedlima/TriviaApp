package com.prove.triviaapp.presentation.quiz

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.prove.triviaapp.domain.question.Question
import com.prove.triviaapp.domain.question.QuestionCategory
import com.prove.triviaapp.domain.question.QuestionDifficulty
import com.prove.triviaapp.domain.question.QuestionType
import com.prove.triviaapp.presentation.ui.theme.TriviaAppTheme

@Composable
fun QuestionScreen(
    question: Question,
    onAnswerSelected: (Boolean?) -> Unit,
) {
    when (question.type) {
        QuestionType.multiple -> {
            MultipleChoiceQuestionScreen(
                question.question,
                question.incorrect_answers,
                onAnswerSelected = { answer ->
                    onAnswerSelected(answer == question.correct_answer)
                }
            )
        }
        QuestionType.boolean -> {
            TrueOrFalseQuestionScreen(
                question.question,
                onAnswerSelected = { answer ->
                    onAnswerSelected(answer == question.correct_answer)
                }
            )
        }
    }
}


@Composable
fun MultipleChoiceQuestionScreen(
    question: String,
    options: List<String>,
    onAnswerSelected: (String) -> Unit
) {
    var selectedOption by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        options.forEach { option ->
            Row(
                modifier = Modifier
                    .padding(bottom = 8.dp)
                    .clickable {
                        selectedOption = option
                    }
                    .align(Alignment.Start)
            ) {
                RadioButton(
                    selected = option == selectedOption,
                    onClick = { selectedOption = option }
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(text = option)
            }
        }
        Button(
            onClick = {
                selectedOption?.let {
                    onAnswerSelected(it)
                }
            },
            enabled = selectedOption != null
        ) {
            Text("Confirmar Resposta")
        }
    }
}


@Composable
fun TrueOrFalseQuestionScreen(question: String, onAnswerSelected: (String) -> Unit) {
    var selectedAnswer by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = question,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(bottom = 8.dp)
        ) {
            Button(onClick = { selectedAnswer = "true" }) {
                Text("Verdadeiro")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { selectedAnswer = "false" }) {
                Text("Falso")
            }
        }
        Button(
            onClick = { selectedAnswer?.let { onAnswerSelected(it) } },
            enabled = true
        ) {
            Text("Próxima Pergunta")
        }
    }
}




@Preview(showBackground = true,showSystemUi = true)
@Composable
fun QuestionScreenPreview() {
    val question = Question(
        question = "Qual é a capital do Brasil?",
        type = QuestionType.multiple,
        incorrect_answers = listOf("Rio de Janeiro", "São Paulo","Brasilia", "Belo Horizonte"),
        correct_answer = "Brasília",
        difficulty = QuestionDifficulty.Hard,
        category = QuestionCategory.Geography
    )

    TriviaAppTheme {
        QuestionScreen(
            question = question,
            onAnswerSelected = { },
        )
    }
}