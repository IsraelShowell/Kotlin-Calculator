package com.ishowell.myfirstkotlinapp

/*
# Creator: Israel Showell
# Start Date: 6/6/2024
# End Date: 6/6/2024
# Project: Basic Calculator Application
# Version: 1.00

# Description:
This is a basic calculator made in the Android development language, Kotlin!
This project provided me with basic knowledge on how to structure an Android app, and I plan on building off from here!

# Practiced Skills:
- Kotlin Development
- Android Development
- UI/UX Design

I followed a great tutorial from @Easy Tuto!
https://www.youtube.com/@EasyTuto1
*/

//Various libraries used to create this project.
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import org.w3c.dom.Text


//This is the main activity
//It can also handle onclick events
class MainActivity : AppCompatActivity() , View.OnClickListener{

    //Creates variables for the 4 buttons
    lateinit var btnAdd : Button
    lateinit var btnSub : Button
    lateinit var btnMul : Button
    lateinit var btnDiv : Button

    //Creates variables for the 2 edit text fields
    //Creates a variable for the textview field
    lateinit var etA : EditText
    lateinit var etB : EditText
    lateinit var ResultTV : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Sets the layout to the activity_main.
        setContentView(R.layout.activity_main)

        //Assigns the variables to their correct buttons and text fields
        btnAdd = findViewById(R.id.btn_add)
        btnSub = findViewById(R.id.btn_sub)
        btnMul = findViewById(R.id.btn_mul)
        btnDiv = findViewById(R.id.btn_div)
        etA = findViewById(R.id.et_a)
        etB = findViewById(R.id.et_b)
        ResultTV = findViewById(R.id.ResultTV)


        //This code allows the buttons to detect when they have been pressed
        btnAdd.setOnClickListener(this)
        btnSub.setOnClickListener(this)
        btnMul.setOnClickListener(this)
        btnDiv.setOnClickListener(this)

    }

    //This overrides the onClick function so that I can use the function as I need
    override fun onClick(v: View?) {
        //Changes the text from the input fields to a string, and then changes it into a double
        var a = etA.text.toString().toDouble()
        var b = etB.text.toString().toDouble()
        var result = 0.0

        //This is a switch case in Kotlin
        //The ? allows v to be NULL safe
        //So when v isn't null, it checks if the id is for add, sub, etc.
        when(v?.id){
            //Add "function"
            R.id.btn_add -> {
                result = a+b
            }
            //Sub "function"
            R.id.btn_sub -> {
                result = a-b
            }
            //Mul "function"
            R.id.btn_mul -> {
                result = a*b
            }
            //Div "function"
            //The program seems to handle the division by 0 error itself
            R.id.btn_div -> {
                result = a/b
            }
        }
        //After doing the computation, we save the result and sent it to the UI
        //The $ allows us to send in the variable result
        ResultTV.text = "The result is $result"
    }
}