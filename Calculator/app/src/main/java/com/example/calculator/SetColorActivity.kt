package com.example.calculator

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioGroup
import androidx.core.graphics.drawable.DrawableCompat
import android.graphics.drawable.Drawable
import android.widget.RadioButton
import android.widget.TextView
import androidx.lifecycle.ViewModelProvider

class SetColorActivity : AppCompatActivity() {
    private lateinit var colorModel: SetColorActivityViewModel


    private lateinit var message : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_set_color)
        colorModel = ViewModelProvider(this).get(SetColorActivityViewModel::class.java)

        Log.i("col", colorModel.checkedColor.toString())

        val colorsRG = findViewById<RadioGroup>(R.id.rg_colors)
        val confirmBTN = findViewById<Button>(R.id.btn_confirm)

        val lightRB = findViewById<RadioButton>(R.id.rb_light)
        val darkRB = findViewById<RadioButton>(R.id.rb_dark)
        val greenRB = findViewById<RadioButton>(R.id.rb_green)
        val blueRB = findViewById<RadioButton>(R.id.rb_blue)

        var checkedRB = colorsRG.checkedRadioButtonId
        colorModel.setCC(checkedRB)
        message = "light"


        confirmBTN.setOnClickListener() {
            Log.i("col", colorModel.checkedColor.toString())
            checkedRB = colorsRG.checkedRadioButtonId
            colorModel.setCC(checkedRB)
            Log.i("col", colorModel.checkedColor.toString())

            if (checkedRB == R.id.rb_light) {
                message = "light"
            } else if (checkedRB == R.id.rb_dark) {
                message = "dark"
            } else if (checkedRB == R.id.rb_green) {
                message = "green"
            }  else if (checkedRB == R.id.rb_blue) {
                message = "blue"
            }
            Log.i("mes", message)
        }

    }

    override fun finish() {
        val data = Intent()
        data.putExtra("message", message)
        setResult(Activity.RESULT_OK, data)
        super.finish()
    }
}