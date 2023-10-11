package org.cscie88c.week4

import scala.math

object TrigUtils {

  // https://www.scala-lang.org/api/2.13.6/scala/math/index.html
  // use the function literal syntax for sin and cos
  val sinDegrees: Double => Double = (i: Double) => math.sin(i.toRadians)
  val cosDegrees: Double => Double = (i: Double) => math.cos(i.toRadians)

  // use the placeholder syntax for squared
  val squared: Double => Double = math.pow(_, 2)  
}
