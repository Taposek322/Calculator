package com.example.calculator.ui.theme

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.CalculatorViewModel
import com.example.calculator.CalculatorViewModelFactory
import com.example.calculator.CalculatorsAction
import com.example.calculator.R

private const val TAG = "CalculatorUI"

@Preview
@Composable
fun CalculatorUI()
{
    val calculatorViewModel = viewModel<CalculatorViewModel>(
        factory = CalculatorViewModelFactory(LocalContext.current)
    )

    var state = calculatorViewModel.state

    val buttonSpace = 8.dp

    CalculatorTheme {
        // A surface container using the 'background' color from the theme
        var appColor: Color
        var textColor: Color
        if(isSystemInDarkTheme()){
            appColor = Color.Black
            textColor = Color.White
        }else{
            appColor = Color.White
            textColor = Color.Black
        }
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .background(color = appColor)
                .padding(16.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = appColor),
                verticalArrangement = Arrangement.spacedBy(buttonSpace)
            ) {

                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(2f)
                        .padding(vertical = 10.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                        if (state.evaluation.isNotBlank()) {
                            Row(
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = state.evaluation,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .weight(1.5f),
                                    textAlign = TextAlign.End,
                                    fontSize = 75.sp,
                                    letterSpacing = 5.sp,
                                    lineHeight = 75.sp,
                                    fontWeight = FontWeight.Light,
                                    color = textColor
                                )
                            }
                        }
                        if (state.result.isNotBlank()) {
                            Log.d(TAG,"In result if. Result=${state.result}")
                            Row(
                                verticalAlignment = Alignment.Bottom
                            ) {
                                Text(
                                    text = state.result,
                                    modifier = Modifier
                                        .fillMaxWidth(),
                                    textAlign = TextAlign.End,
                                    fontSize = 50.sp,
                                    letterSpacing = 5.sp,
                                    lineHeight = 50.sp,
                                    fontWeight = FontWeight.Light,
                                    color = Color.Gray
                                )
                            }
                        }
                }
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpace)

                ){
                    CalculatorButton(
                        symbol = R.string.button_left_bracket,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.LeftBracket)
                    }
                    CalculatorButton(
                        symbol = R.string.button_right_bracket,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.RightBracket)
                    }
                    CalculatorButton(
                        symbol = R.string.button_clear,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Clear)
                    }
                    CalculatorButton(
                        symbol = R.string.button_delete,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Delete)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpace)

                ){
                    CalculatorButton(
                        symbol = R.string.button_7,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(7))
                    }
                    CalculatorButton(
                        symbol = R.string.button_8,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(8))
                    }
                    CalculatorButton(
                        symbol = R.string.button_9,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(9))
                    }
                    CalculatorButton(
                        symbol = R.string.button_mul,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Mul)

                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpace)

                ){
                    CalculatorButton(
                        symbol = R.string.button_4,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(4))
                    }
                    CalculatorButton(
                        symbol = R.string.button_5,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(5))
                    }
                    CalculatorButton(
                        symbol = R.string.button_6,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(6))
                    }
                    CalculatorButton(
                        symbol = R.string.button_sub,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Sub)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpace)

                ){
                    CalculatorButton(
                        symbol = R.string.button_1,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(1))
                    }
                    CalculatorButton(
                        symbol = R.string.button_2,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(2))
                    }
                    CalculatorButton(
                        symbol = R.string.button_3,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(3))
                    }
                    CalculatorButton(
                        symbol = R.string.button_sum,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Add)
                    }
                }

                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(buttonSpace)
                ){
                    CalculatorButton(
                        symbol = R.string.button_real,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Real)
                    }
                    CalculatorButton(
                        symbol = R.string.button_0,
                        backgroundColor = appColor,
                        textColor = textColor,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Number(0))

                    }
                    CalculatorButton(
                        symbol = R.string.button_eval,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Eval)
                    }
                    CalculatorButton(
                        symbol = R.string.button_div,
                        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
                        textColor = MaterialTheme.colorScheme.onSecondaryContainer,
                        modifier = Modifier
                            .aspectRatio(1f)
                            .weight(0.7f)
                    ) {
                        calculatorViewModel.onAction(CalculatorsAction.Div)
                    }
                }
            }
        }
    }
}