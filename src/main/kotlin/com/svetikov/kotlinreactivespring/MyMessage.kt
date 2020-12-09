package com.svetikov.kotlinreactivespring

import java.util.*

data class MyMessage(
        val id:String? = UUID.randomUUID().toString(),
        val message:String?
)