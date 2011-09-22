package edu.luc.cs.laufer.cs473.shapes

abstract class Shape

case class Rectangle(width: Int, height: Int) extends Shape {
  if (!((width > 0) && (height > 0))) {
    throw new IllegalArgumentException("invalid Rectangle: length or height is not a postive integer")
  }
}

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  if (shape == null) {
    throw new IllegalArgumentException("null shape in location")
  }
}

case class Ellipse(width: Int, height: Int) extends Shape {
  if (!(height > 0)) {
    throw new IllegalArgumentException("invalid ellipse: height must be greater than zero")
  }
  if (!(width > 0)) {
    throw new IllegalArgumentException("invalid ellipse: width must be greater than zero")
  }  
}

case class Group(multishapes: Shape*) extends Shape
// TODO validity checking for Group!!!!!!!!!

// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
