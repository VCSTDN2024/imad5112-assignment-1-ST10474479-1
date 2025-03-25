package com.example.mealpreparation
//Kincade is a g
import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
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

        //Linked ID widgets to the variables
        mealText = findViewById(R.id.mealText)
        mealbtn = findViewById(R.id.Mealbtn)
        resetbtn = findViewById(R.id.resetbtn)
        showFood = findViewById(R.id.showFood)
        exitbtn = findViewById(R.id.exitbtn)

        //used a onclicklistener so when user presses button it generates the food suggestion, reset and exit
        mealbtn.setOnClickListener {
            handleMealbtnClick()
        }
        resetbtn.setOnClickListener { //reset the text on the textview
            handleResetbtnClick()
        }

        exitbtn.setOnClickListener { //exit the program
            finish()
        }
    }

    private fun handleResetbtnClick() {
        showFood.text = ""
    }


    //used a if statement to display that once a user enters time of day he display result will be the food based on the time of day input
    @SuppressLint("SetTextI18n")
    private fun handleMealbtnClick() {
        val mealInput = mealText.text.toString().trim()
            .replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() }
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

        }
    }

}
