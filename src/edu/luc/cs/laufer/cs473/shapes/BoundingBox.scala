package edu.luc.cs.laufer.cs473.shapes

object BoundingBox {
  def boundingBox(s: Shape): Location = s match {
    case Rectangle(_, _) =>
      new Location(0, 0, s)
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }
    case Ellipse(height, width) =>
      new Location(-(height), -(width), new Rectangle(height * 2, width * 2))
    case Group(multishapes*) => multishapes.map((s:Shape) => boundingBox(s)).foldLeft(Location(0, 0, Rectangle(1, 1))) {
               
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
