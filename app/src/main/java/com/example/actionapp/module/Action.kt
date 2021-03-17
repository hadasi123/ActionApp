package com.example.actionapp.module

data class Action(val type: String,
                  val enabled: Boolean,
                  val priority: Int,
                  val valid_days: Array<Int>,
                  val cool_down: Double){
}
