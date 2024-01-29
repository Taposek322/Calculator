package com.example.calculator

import androidx.annotation.StringRes

sealed class CalculatorsAction(
) {
    data class Number(val number: Int): CalculatorsAction()
    object Add:CalculatorsAction()
    object Sub:CalculatorsAction()
    object  Mul:CalculatorsAction()
    object  Div:CalculatorsAction()
    object  Real:CalculatorsAction()
    object Eval:CalculatorsAction()
    object Clear:CalculatorsAction()
    object Delete:CalculatorsAction()
    object LeftBracket:CalculatorsAction()
    object RightBracket:CalculatorsAction()
}