package edu.luc.cs.laufer.cs473.shapes

import BoundingBox.boundingBox
import TestFixtures.simpleLocation

object Main {
  def main(args : Array[String]) : Unit = {
    println(boundingBox(simpleLocation))
  }
}
