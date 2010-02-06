package edu.luc.cs.laufer.cs473.shapes

import BoundingBox._

object Main {
  def main(args : Array[String]) : Unit = {
    val s = Location(3, 4, Rectangle(20, 40))
    println(boundingBox(s))
  }
}
