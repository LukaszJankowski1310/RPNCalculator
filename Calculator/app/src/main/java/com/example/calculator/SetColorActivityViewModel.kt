package com.example.calculator

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel


class SetColorActivityViewModel : ViewModel() {
    var checkedColor  = 0

    fun setCC(color : Int) {
        checkedColor = color
    }
}