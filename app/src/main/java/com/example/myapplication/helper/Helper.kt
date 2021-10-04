package com.example.myapplication.helper

import java.util.*

class Helper {
    fun probability():Boolean {
        val random = Random()
        val chance50oftrue :Boolean= if (random.nextInt(2) === 0) true else false
        return chance50oftrue
    }
    fun checkFibonaci(){


    }
    fun Fibonacci(N: Int) {
        var num1 = 0
        var num2 = 1
        var counter = 0
        // Iterate till counter is N
        while (counter < N) {
            print("$num1 ")
            // Swap
            val num3 = num2 + num1
            num1 = num2
            num2 = num3
            counter = counter + 1
        }
    }

}