package edu.luc.cs.laufer.cs473.shapes

abstract class Shape

case class Rectangle(width: Int, height: Int) extends Shape

case class Location(x: Int, y: Int, shape: Shape) extends Shape {
  if (shape == null) {
    throw new IllegalArgumentException("null shape in location")
  }
}

case class Ellipse(foci_distance_sum: Int, foci_line_length: Int) extends Shape {
  if (foci_distance_sum < foci_line_length) {
    throw new IllegalArgumentException("invalid ellipse: foci_distance_sum must be greater than foci_line_length")
  }
}

case class Group(multishapes: Shape*) extends Shape

//case class Group(location1: Location, location2: Location) extends Shape

// TODO add missing case classes (see test fixtures)
// TODO must include validity checking for constructor arguments
