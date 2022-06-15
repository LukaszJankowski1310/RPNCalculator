package com.example.calculator

import android.text.BoringLayout
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {

    var color : String = "green"


    var isDot : Boolean = false
    var numToDisplay : String = "0"
    var number : Float = 0.0F
    var stackNumbers : MutableList<Float> = mutableListOf()

    var undoClick : Boolean = false
    var operationDone : Boolean = false
    var numberAlreadyPushed : Boolean = false


    var prevStackNumbers : MutableList<Float> = mutableListOf()
    var prevNumToDisplay : String = "0"
    var prevNumber : Float = 0.0F
    var prevIsDot : Boolean = false

    var changeColor : Boolean = true

    fun zmienChangeColor() {
        changeColor = !changeColor
    }


    fun swapLists(list1 : MutableList<Float>, list2 : MutableList<Float> ) {
        list1.clear()
        for (i in 0 until list2.size) {
            list1.add(list2[i])
        }
    }

    fun handleNumberButtons(numStr : String) {

        if (operationDone || numberAlreadyPushed) {
            isDot = false
            numToDisplay = "0"
            number = 0.0F
            operationDone = false
            numberAlreadyPushed = false
        }

        if (numStr == "0" && numToDisplay == "0") return
        if (numToDisplay.length >= 15) return

        if (numToDisplay == "0" && numStr != "0") {
            numToDisplay = numStr
            number = numToDisplay.toFloat()
        } else {
            numToDisplay += numStr
            number = numToDisplay.toFloat()
        }
    }

    fun handleDotButton() {
        if (operationDone || numberAlreadyPushed) {
            numToDisplay = "0."
            number = 0F
            isDot = true
            operationDone = false
            numberAlreadyPushed = false
        }

        if (!isDot) {
            numToDisplay += "."
            isDot = true
        }

    }

    fun handleExpButton() {

        prevNumToDisplay = numToDisplay
        prevIsDot = isDot
        prevNumber = number
        undoClick = true

        isDot = false
        numToDisplay = "0"
        number = 0.0F
        operationDone = false
        numberAlreadyPushed = false
    }

    fun handleNegationButton() {
        if (number > 0) {
            numToDisplay = "-$numToDisplay"
            number = numToDisplay.toFloat()
        } else if (number < 0) {
            Log.i("MyTag", numToDisplay)
            numToDisplay = numToDisplay.replace("-", "")
            number = numToDisplay.toFloat()
        }
    }

    fun handleClearArrowButton() {

        if (operationDone || numberAlreadyPushed) {
            isDot = false
            numToDisplay = "0"
            number = 0.0F
            operationDone = false
            numberAlreadyPushed = false
        }


        if (number >= 0) {
            if (numToDisplay.length <= 1) {
                numToDisplay = "0"
            } else {
                numToDisplay = numToDisplay.substring(0, numToDisplay.length - 1)
            }
        } else {
            if (numToDisplay.length <= 2) {
                numToDisplay = "0"
            } else {
                numToDisplay = numToDisplay.substring(0, numToDisplay.length - 1)
            }
        }
        number = numToDisplay.toFloat()
    }

    fun handleEnterButton() {

        if (numToDisplay == "Error") {
            return
        }



        prevNumToDisplay = numToDisplay
        prevIsDot = isDot
        prevNumber = number
        swapLists(prevStackNumbers, stackNumbers)
        undoClick = true
        stackNumbers.add(0,number)
        numberAlreadyPushed = true


        Log.i("MyTag", stackNumbers.toString())

    }

    fun handleAcButton() {

        prevNumToDisplay = numToDisplay
        prevIsDot = isDot
        prevNumber = number
        swapLists(prevStackNumbers, stackNumbers)
        undoClick = true

        isDot = false
        numToDisplay = "0"
        number = 0.0F
        stackNumbers.clear()
        operationDone  = false
        numberAlreadyPushed = false
    }

    fun handleDropButton() {

        if (stackNumbers.size > 0) {
            prevNumToDisplay = numToDisplay
            prevIsDot = isDot
            prevNumber = number
            swapLists(prevStackNumbers, stackNumbers)
            undoClick = true

            stackNumbers.removeAt(0)
            operationDone  = false
            numberAlreadyPushed = false

        }
    }

    fun handleSwapButton() {
        if (stackNumbers.size >= 1) {

            prevNumToDisplay = numToDisplay
            prevIsDot = isDot
            prevNumber = number
            swapLists(prevStackNumbers, stackNumbers)
            undoClick = true

            val buffor = stackNumbers[0]
            stackNumbers[0] = number
            number = buffor
            numToDisplay = number.toString()

            operationDone  = false
            numberAlreadyPushed = false

        }
    }

    fun handleUndoButton() {
        if (undoClick) {
            isDot = prevIsDot
            numToDisplay = prevNumToDisplay
            number = prevNumber
            swapLists(stackNumbers, prevStackNumbers)
        }
        undoClick = false
    }

    fun handleOperationButtons(operation : String) {

        if (stackNumbers.size > 0) {

            prevIsDot = isDot
            prevNumToDisplay = numToDisplay
            prevNumber  = number
            swapLists( prevStackNumbers, stackNumbers)

            var result : Float = 0F
            if (operation == "+") {
                result = stackNumbers[0] + number
                numToDisplay = result.toString()
            } else if (operation == "-") {
                result = stackNumbers[0] - number
                numToDisplay = result.toString()
            } else if (operation == "/") {
               if (number == 0F) {
                   numToDisplay = "Error"

                   isDot = false
                   number = 0.0F
                   operationDone = true
                   undoClick = true
                   if (stackNumbers.size > 0) {
                       stackNumbers.clear()
                   }
                   return


               } else {
                   result = stackNumbers[0] / number
                   numToDisplay = result.toString()
               }
            } else if (operation == "x") {
                result = stackNumbers[0] * number
                numToDisplay = result.toString()
            }
            number = result

            stackNumbers.removeAt(0)
            operationDone = true
            undoClick = true
        }

    }

}