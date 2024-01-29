package com.example.calculator

data class CalculatorState(
     val evaluation: String = "",
     val result: String = "",
     val interResult: String = ""
) {
     fun changeEval(evaluation: String):CalculatorState{
          return copy(
               evaluation = evaluation
          )
     }
     fun changeResult(result: String):CalculatorState{
          return copy(
               result = result
          )
     }
     fun changeInterResult(interResult: String):CalculatorState{
          return copy(
               interResult = interResult
          )
     }

     fun changeBoth(evaluation: String,result: String):CalculatorState{
          return copy(
               evaluation = evaluation,
               result = result
          )
     }
}