package com.svetikov.kotlinreactivespring

import java.util.*

data class Mess(
        val id:String = UUID.randomUUID().toString(),
        val message:String
)