package edu.luc.cs.laufer.cs473.shapes

abstract class Shape
case class Rectangle(width: Int, height: Int) extends Shape
case class Location(x: Int, y: Int, shape: Shape) extends Shape
// TODO add missing case classes (see test fixtures)
