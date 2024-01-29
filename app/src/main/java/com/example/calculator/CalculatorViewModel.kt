package com.example.calculator

import android.content.Context
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import net.objecthunter.exp4j.ExpressionBuilder

private const val TAG = "CalculatorViewModel"

class CalculatorViewModel(private val context: Context):ViewModel() {

    var state by mutableStateOf(CalculatorState())

    fun onAction(action:CalculatorsAction){
        when(action){
            is CalculatorsAction.Number -> actionNumber(action.number)
            is CalculatorsAction.Add -> actionAdd()
            is CalculatorsAction.Sub -> actionSub()
            is CalculatorsAction.Mul -> actionMul()
            is CalculatorsAction.Div -> actionDiv()
            is CalculatorsAction.Eval -> actionEval()
            is CalculatorsAction.Real -> actionReal()
            is CalculatorsAction.Clear -> actionClear()
            is CalculatorsAction.Delete -> actionDelete()
            is CalculatorsAction.LeftBracket -> actionLeftBracket()
            is CalculatorsAction.RightBracket -> actionRightBracket()
        }
    }

    private fun actionNumber(num: Int){
        if(state.evaluation=="0" && num!=0){
            actionClear()
        }
        state=state.changeEval(state.evaluation+num.toString())
        actionEvalRes()
    }

    private fun actionAdd(){
        if(state.evaluation.isNotBlank()) {
            var savedeval = state.evaluation
            val lastSymb = savedeval[savedeval.length - 1]
            if (lastSymb != '.') {
                if (!lastSymb.isDigit()) {
                    savedeval = savedeval.dropLast(1)
                }
                state = state.changeEval("$savedeval+")
            }
        }
    }

    private fun actionSub(){
        if(state.evaluation.isNotBlank()){
            var savedeval = state.evaluation
            val lastSymb = savedeval[savedeval.length-1]
            if(lastSymb!='.' && !lastSymb.isDigit()){
                 savedeval = savedeval.dropLast(1)
            }
            state=state.changeEval("$savedeval-")
        }else{
            state = state.changeEval("-")
        }

    }

    private fun actionMul(){
        if(state.evaluation.isNotBlank()) {
            var savedeval = state.evaluation
            val lastSymb = savedeval[savedeval.length - 1]
            if (lastSymb != '.') {
                if (!lastSymb.isDigit()) {
                    savedeval = savedeval.dropLast(1)
                }
                state = state.changeEval("$savedeval*")
            }
        }
    }

    private fun actionDiv(){
        if(state.evaluation.isNotBlank()) {
            var savedeval = state.evaluation
            val lastSymb = savedeval[savedeval.length - 1]
            if ( lastSymb != '.') {
                if (!lastSymb.isDigit()) {
                    savedeval = savedeval.dropLast(1)
                }
                state = state.changeEval("$savedeval/")
            }
        }
    }

    private fun actionEval(){
        if(state.result!=context.getString(R.string.eval_error)){
            state = state.changeBoth(evaluation = state.result,result = "")
        }
    }

    private fun actionEvalRes(){
        try {
            if (state.evaluation.isNotBlank()) {
                val leftBracketCount = state.evaluation.count { char -> char == '(' }
                val rightBracketCount = state.evaluation.count { char -> char == ')' }
                if (leftBracketCount == rightBracketCount) {
                    var res = ExpressionBuilder(state.evaluation).build().evaluate()
                    if (res == res.toInt().toDouble()) {
                        state = state.changeResult(result = res.toInt().toString())
                    } else {
                        state = state.changeResult(result = res.toString())
                    }
                } else {
                    state = state.changeResult(result = context.getString(R.string.eval_error))
                }
            }
        }catch (e:Exception){
            state = state.changeResult("Error")
        }
    }

    private fun actionReal(){
        if(state.evaluation.isNotBlank()) {
            var savedeval = state.evaluation
            val lastSymb = savedeval[savedeval.length - 1]
            if (lastSymb != '+' && lastSymb != '-' && lastSymb != '*' && lastSymb != '/' && lastSymb != '.') {
                state = state.changeEval(state.evaluation + ".")
            }
        }
    }


    private fun actionClear() {
        state=state.changeBoth(evaluation = "", result = "")
    }
    private fun actionDelete() {
        if(state.evaluation.isNotBlank()) {
            state = state.changeEval(state.evaluation.dropLast(1))
            actionEvalRes()
        }
    }

    private fun actionLeftBracket() {
        state = state.changeEval(state.evaluation+"(")
    }

    private fun actionRightBracket() {
        state = state.changeEval(state.evaluation+")")
    }

}

class CalculatorViewModelFactory(
    private val context: Context
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CalculatorViewModel(context) as T
    }
}