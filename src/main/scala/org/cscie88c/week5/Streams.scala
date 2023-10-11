package org.cscie88c.week5

import java.util.UUID
import scala.util.Random

object Streams {
  val rnd = new Random()
  def uuid: String = UUID.randomUUID.toString.replaceAll("-", "")

  case class Dog(name: String, age: Int, hasCurrentShots: Boolean)

  val mult5: LazyList[Int] =LazyList.range(0, 101, 5)

  val randIntStream: LazyList[Int] = LazyList.continually(Random.nextInt(16))

  val dogs: LazyList[Dog] = LazyList.iterate(Dog("dog-" + uuid, Random.nextInt(16), Random.nextBoolean()))(d => d.copy(name="dog-" + uuid, age=Random.nextInt(16), hasCurrentShots=Random.nextBoolean()))

  def healthyDogs(dogs: LazyList[Dog]): LazyList[Dog] = dogs.filter(d => d.hasCurrentShots == true)

  def averageHealthyAge(allDogs: LazyList[Dog], sampleSize: Int): Double = {
    val healthyDogsListSize: Double = healthyDogs(allDogs.take(sampleSize)).size
    healthyDogsListSize/sampleSize
  }


}
