package com.example.calculator

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.graphics.drawable.Drawable
import android.os.Bundle
import android.provider.CalendarContract
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.DrawableCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.graphics.Color

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainActivityViewModel
 //   private lateinit var colorModel: SetColorActivityViewModel
    private lateinit var message : String


    @SuppressLint("NotifyDataSetChanged", "ResourceAsColor")
    private lateinit var btn_nr0 : Button
    private lateinit var btn_nr1 : Button
    private lateinit var btn_nr2 : Button
    private lateinit var btn_nr3 : Button
    private lateinit var btn_nr4 : Button
    private lateinit var btn_nr5 : Button
    private lateinit var btn_nr6 : Button
    private lateinit var btn_nr7 : Button
    private lateinit var btn_nr8 : Button
    private lateinit var btn_nr9 : Button

    private lateinit var btn_clear_arrow : Button
    private lateinit var btn_dot : Button
    private lateinit var btn_negation : Button
    private lateinit var btn_ENTER : Button

    private lateinit var btn_AC : Button
    private lateinit var btn_UNDO : Button
    private lateinit var btn_EXP : Button
    private lateinit var btn_DROP : Button
    private lateinit var btn_SWAP : Button
    private lateinit var btn_settings : Button

    private lateinit var btn_addition : Button
    private lateinit var btn_multiplication : Button
    private lateinit var btn_division : Button
    private lateinit var btn_subtraction : Button

    private lateinit var numToDisplayTV : TextView
    private lateinit var stackRV : RecyclerView
    private lateinit var buttons : Array<Button>

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
   //     colorModel = ViewModelProvider(this).get(SetColorActivityViewModel::class.java)
        // display

         numToDisplayTV = findViewById<TextView>(R.id.tv_numToDisplay)
        // numbers

         btn_nr0 = findViewById<Button>(R.id.btn_nr0)
         btn_nr1 = findViewById<Button>(R.id.btn_nr1)
         btn_nr2 = findViewById<Button>(R.id.btn_nr2)
         btn_nr3 = findViewById<Button>(R.id.btn_nr3)
         btn_nr4 = findViewById<Button>(R.id.btn_nr4)
         btn_nr5 = findViewById<Button>(R.id.btn_nr5)
         btn_nr6 = findViewById<Button>(R.id.btn_nr6)
         btn_nr7 = findViewById<Button>(R.id.btn_nr7)
         btn_nr8 = findViewById<Button>(R.id.btn_nr8)
         btn_nr9 = findViewById<Button>(R.id.btn_nr9)

        // buttons

         btn_clear_arrow = findViewById<Button>(R.id.btn_clear_arrow)
         btn_dot = findViewById<Button>(R.id.btn_dot)
         btn_negation = findViewById<Button>(R.id.btn_negation)
         btn_ENTER = findViewById<Button>(R.id.btn_enter)


         btn_AC = findViewById<Button>(R.id.btn_AC)
         btn_UNDO = findViewById<Button>(R.id.btn_UNDO)
         btn_EXP = findViewById<Button>(R.id.btn_EXP)
         btn_DROP = findViewById<Button>(R.id.btn_DROP)
         btn_SWAP = findViewById<Button>(R.id.btn_SWAP)
         btn_settings = findViewById<Button>(R.id.btn_settings)

        // operations

         btn_addition = findViewById<Button>(R.id.btn_addition)
         btn_multiplication = findViewById<Button>(R.id.btn_multiplication)
         btn_division = findViewById<Button>(R.id.btn_division)
         btn_subtraction = findViewById<Button>(R.id.btn_subtraction)

        // stack

        stackRV = findViewById<RecyclerView>(R.id.rv_stack)
        val stackAdapter = StackAdapter(viewModel.stackNumbers)
        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.reverseLayout = true

        stackRV.layoutManager = linearLayoutManager
        stackRV.adapter = stackAdapter


        message = "light"


         buttons = arrayOf(btn_nr0, btn_nr1, btn_nr2,
            btn_nr3, btn_nr4, btn_nr5, btn_nr6, btn_nr7, btn_nr8,
            btn_nr9, btn_clear_arrow, btn_dot, btn_negation, btn_ENTER,
            btn_AC, btn_UNDO, btn_EXP, btn_DROP,btn_SWAP, btn_settings,
            btn_addition, btn_multiplication, btn_division, btn_subtraction
        )

//        val btn = findViewById<Button>(R.id.button)
//
//        var buttonDrawable: Drawable = btn.getBackground()
//        buttonDrawable = DrawableCompat.wrap(buttonDrawable)
//
//        var pink = Color.rgb(255, 0, 140)
//
//        DrawableCompat.setTint(buttonDrawable, pink)
//        btn.setBackground(buttonDrawable)


        fun setNumbersListener() {

            btn_nr0.setOnClickListener() {
                viewModel.handleNumberButtons(btn_nr0.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }

            btn_nr1.setOnClickListener(){
               // press(btn_nr1)
                viewModel.handleNumberButtons(btn_nr1.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay

            }
            btn_nr2.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr2.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr3.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr3.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr4.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr4.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr5.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr5.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr6.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr6.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr7.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr7.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr8.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr8.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
            btn_nr9.setOnClickListener(){
                viewModel.handleNumberButtons(btn_nr9.text.toString())
                numToDisplayTV.text = viewModel.numToDisplay
            }
        }
        setNumbersListener()

        btn_dot.setOnClickListener() {
            viewModel.handleDotButton()
            numToDisplayTV.text = viewModel.numToDisplay
        }
        btn_EXP.setOnClickListener() {
            viewModel.handleExpButton()
            numToDisplayTV.text = viewModel.numToDisplay
        }
        btn_negation.setOnClickListener() {
            viewModel.handleNegationButton()
            numToDisplayTV.text = viewModel.numToDisplay
        }
        btn_clear_arrow.setOnClickListener() {
            viewModel.handleClearArrowButton()
            numToDisplayTV.text = viewModel.numToDisplay
        }
        btn_ENTER.setOnClickListener(){
            viewModel.handleEnterButton()
            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_AC.setOnClickListener() {
            Log.i("MyTag", "ac")
            viewModel.handleAcButton()
            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_SWAP.setOnClickListener() {
            viewModel.handleSwapButton()
            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_UNDO.setOnClickListener() {
            viewModel.handleUndoButton()
            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_DROP.setOnClickListener() {
            viewModel.handleDropButton()
            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_addition.setOnClickListener() {
         //   viewModel.handleAdditionButton()
            viewModel.handleOperationButtons(btn_addition.text.toString())

            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_division.setOnClickListener() {
            viewModel.handleOperationButtons(btn_division.text.toString())

            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_subtraction.setOnClickListener() {
            viewModel.handleOperationButtons(btn_subtraction.text.toString())

            numToDisplayTV.text = viewModel.numToDisplay
            stackAdapter.notifyDataSetChanged()
        }
        btn_multiplication.setOnClickListener() {
            viewModel.handleOperationButtons(btn_multiplication.text.toString())

            numToDisplayTV.text = viewModel.numToDisplay

        }
        btn_settings.setOnClickListener() {
            val setColorActivityIntent = Intent(this, SetColorActivity::class.java)
            startActivityForResult(setColorActivityIntent, 1000)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if ((requestCode==1000) && (resultCode==Activity.RESULT_OK)) {
            if (data != null) {
                if (data.hasExtra("message")) {
                    message = data.extras?.getString("message").toString()
                }
            }
        }

    }

    override fun onResume() {
        super.onResume()
        Log.i("mes", message)
        if (message == "green"){
           buttons.forEach {
               var buttonDrawable: Drawable = it.getBackground()
               buttonDrawable = DrawableCompat.wrap(buttonDrawable)
                var green = Color.rgb(0, 160, 0)
               DrawableCompat.setTint(buttonDrawable, green)
               it.setTextColor(Color.rgb(255, 255, 255))
           }
            numToDisplayTV.setBackgroundResource(R.color.light)
            stackRV.setBackgroundResource(R.color.light)

        }
        else if (message == "dark"){
            buttons.forEach {
                var buttonDrawable: Drawable = it.getBackground()
                buttonDrawable = DrawableCompat.wrap(buttonDrawable)
                var dark = Color.rgb(25, 37, 54)
                DrawableCompat.setTint(buttonDrawable, dark)
                it.setBackground(buttonDrawable)
                it.setTextColor(Color.rgb(255, 255, 255))
            }
            numToDisplayTV.setBackgroundResource(R.color.light)
            stackRV.setBackgroundResource(R.color.light)
        }
        else if (message == "light") {
            buttons.forEach {
                var buttonDrawable: Drawable = it.getBackground()
                buttonDrawable = DrawableCompat.wrap(buttonDrawable)
                var light = Color.rgb(221, 223, 223)
                DrawableCompat.setTint(buttonDrawable, light)
                it.setBackground(buttonDrawable)
                it.setTextColor(Color.rgb(0, 0, 0))
            }

            numToDisplayTV.setBackgroundResource(R.color.light)
            stackRV.setBackgroundResource(R.color.light)


        }
        else if (message == "blue") {
            buttons.forEach {
                var buttonDrawable: Drawable = it.getBackground()
                buttonDrawable = DrawableCompat.wrap(buttonDrawable)
                var blue = Color.rgb(50, 60, 224)
                DrawableCompat.setTint(buttonDrawable, blue)
                it.setBackground(buttonDrawable)
                it.setTextColor(Color.rgb(255, 255, 255))
            }

            numToDisplayTV.setBackgroundResource(R.color.light)
            stackRV.setBackgroundResource(R.color.light)

        }

    }
}



