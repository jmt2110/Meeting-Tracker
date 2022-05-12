package com.example.myapplication


data class Meeting constructor(
    var who: String,
    var date: String,
    var time: String,
    var location: String,
    var additional: String,
    var priority: Boolean

) {
}