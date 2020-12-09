package com.svetikov.kotlinreactivespring

import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class MyController {

    @CrossOrigin(origins = ["http://http://localhost:63342/"])
    @GetMapping("/one")
    fun oneMessage():MyMessage = MyMessage("1","Alisa")
}