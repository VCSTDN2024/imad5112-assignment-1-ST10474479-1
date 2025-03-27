package com.example.mealpreparation
//Kincade is a g
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import java.util.Locale

class MainActivity : AppCompatActivity() {
    //Declared variable for the xml widgets
    private lateinit var mealText: EditText
    private lateinit var mealbtn: Button
    private lateinit var resetbtn: Button
    private lateinit var showFood: TextView
    private lateinit var exitbtn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)


        //Linked ID widgets to the variables
        mealText = findViewById(R.id.mealText)
        mealbtn = findViewById(R.id.Mealbtn)
        resetbtn = findViewById(R.id.resetbtn)
        showFood = findViewById(R.id.showFood)
        exitbtn = findViewById(R.id.exitbtn)

        //used a onclicklistener so when user presses button it generates the food suggestion, reset and exit
        mealbtn.setOnClickListener {
            handleMealBtnClick()
        }
        resetbtn.setOnClickListener { //reset the text on the textview
            handleResetBtnClick()
        }

        exitbtn.setOnClickListener { //exit the program
            finish()
        }
    }

    private fun handleResetBtnClick() {
        showFood.text = ""
    }


    //used a if statement to display that once a user enters time of day he display result will be the food based on the time of day input
    /// @SuppressLint("SetTextI18n")
    private fun handleMealBtnClick() {
        val mealInput = mealText.text.toString().trim().lowercase()
        //**.replaceFirstChar {
        //  if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
        if (mealInput.isEmpty()) {
            showFood.text = "Enter the time of day(Morning, Afternoon,etc)"
            return
        }
        when (mealInput) {
            "Morning" -> showFood.text = "Pancakes, Waffles, Fruit salad, Muesli"
            "Mid-Morning" -> showFood.text = "Protein bar"
            "Afternoon" -> showFood.text =
                "Club sandwich, Chicken Caesor salad, Kota, Hake and chips"

            "Mid - Afternoon" -> showFood.text = "Crsips, Sweets, Biscuits"
            "Dinner" -> showFood.text = "Pap with gravy, Chicken Alfredo pasta, Lasagna"
            "After Dinner snack" -> showFood.text = "malva pudding, ice cream"

            //else statement is for an error handler to inform the user that they have input a wrong value and that they should input the correct value
            else -> {
                    showFood.text = "Please enter a valid time of day"
                    Toast.makeText(this, "Please add the appropriate value", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }



