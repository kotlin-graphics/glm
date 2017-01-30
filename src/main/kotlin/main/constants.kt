package main

/**
 * Created by GBarbieri on 14.12.2016.
 */


fun epsilon(a: Float, b:Float) = Math.max(Math.ulp(a), Math.ulp(b))
fun epsilon() = Float.MIN_VALUE