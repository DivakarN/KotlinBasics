package com.sysaxiom.kotlinbasics

import android.view.View

//Property Extension
val Int.isEven: Boolean
    get() = this % 2 == 0

//Function Extension
fun View.show() {
    visibility = View.VISIBLE
}
