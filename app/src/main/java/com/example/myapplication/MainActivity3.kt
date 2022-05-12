package com.example.myapplication

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Spinner
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main3.*

class MainActivity3 : AppCompatActivity() {

    lateinit var meetingAdapter: MeetingAdapter

    fun hideAddMeeting(){
        idParticipant.visibility = View.INVISIBLE
        var monthSpinner: Spinner = findViewById(R.id.idMonth)
        monthSpinner.visibility = View.INVISIBLE
        var daySpinner: Spinner = findViewById(R.id.idDay)
        daySpinner.visibility = View.INVISIBLE
        var yearSpinner: Spinner = findViewById(R.id.idYear)
        yearSpinner.visibility = View.INVISIBLE
        var hourSpinner: Spinner = findViewById(R.id.idTimeHr)
        hourSpinner.visibility = View.INVISIBLE
        var minSpinner: Spinner = findViewById(R.id.idTimeMin)
        minSpinner.visibility = View.INVISIBLE
        var factorSpinner: Spinner = findViewById(R.id.idTimeFactor)
        factorSpinner.visibility = View.INVISIBLE
        idPlace.visibility = View.INVISIBLE
        idAdditional.visibility = View.INVISIBLE
        idPriority.visibility = View.INVISIBLE
        idRecyclerView.visibility = View.VISIBLE

    }

    fun showAddMeeting(){
        idParticipant.visibility = View.VISIBLE
        var monthSpinner: Spinner = findViewById(R.id.idMonth)
        monthSpinner.visibility = View.VISIBLE
        var daySpinner: Spinner = findViewById(R.id.idDay)
        daySpinner.visibility = View.VISIBLE
        var yearSpinner: Spinner = findViewById(R.id.idYear)
        yearSpinner.visibility = View.VISIBLE
        var hourSpinner: Spinner = findViewById(R.id.idTimeHr)
        hourSpinner.visibility = View.VISIBLE
        var minSpinner: Spinner = findViewById(R.id.idTimeMin)
        minSpinner.visibility = View.VISIBLE
        var factorSpinner: Spinner = findViewById(R.id.idTimeFactor)
        factorSpinner.visibility = View.VISIBLE
        idPlace.visibility = View.VISIBLE
        idAdditional.visibility = View.VISIBLE
        idPriority.visibility = View.VISIBLE
        idRecyclerView.visibility = View.INVISIBLE

    }

    fun isValidPhoneNumber():Boolean{
        var isValid: Boolean = false
        if(idAdditional.text.length == 10){
            isValid = true
        }
        return isValid
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        meetingAdapter = MeetingAdapter(mutableListOf())

        idRecyclerView.adapter = meetingAdapter

        idRecyclerView.layoutManager = LinearLayoutManager(this)


        val submitBtn = findViewById<Button>(R.id.idSubmitBtn)
        submitBtn.setOnClickListener {


            var who = idParticipant.text.toString()

            var monthSpinner: Spinner = findViewById(R.id.idMonth)
            var month = monthSpinner.selectedItem.toString()
            var daySpinner: Spinner = findViewById(R.id.idDay)
            var day = daySpinner.selectedItem.toString()
            var yearSpinner: Spinner = findViewById(R.id.idYear)
            var year = yearSpinner.selectedItem.toString()
            var date = "$month/$day/$year"
            var hourSpinner: Spinner = findViewById(R.id.idTimeHr)
            var hour = hourSpinner.selectedItem.toString()
            var minSpinner: Spinner = findViewById(R.id.idTimeMin)
            var min = minSpinner.selectedItem.toString()
            var factorSpinner: Spinner = findViewById(R.id.idTimeFactor)
            var factor = factorSpinner.selectedItem.toString()
            var time = "$hour:$min $factor"
            var location = idPlace.text.toString()
            var additional = idAdditional.text.toString()
            var priority = idPriority.isChecked



            if (submitBtn.text == "Add New"){
                submitBtn.text = "Submit"
                showAddMeeting()
            }
            else {

                if(isValidPhoneNumber()) {
                    val meetingWho = Meeting(who, date, time, location, additional, priority)
                    meetingAdapter.addMeeting(meetingWho)

                    idParticipant.text.clear()
                    idPlace.text.clear()
                    idAdditional.text.clear()
                    idPriority.isChecked = false

                    hideAddMeeting()

                    submitBtn.text = "Add New"
                }
                else{
                    idAdditional.text.clear()
                    idAdditional.hint = "Incorrect Phone number"
                    idAdditional.setHintTextColor(Color.parseColor("#FF0000"))
                }
            }
        }



    }
}