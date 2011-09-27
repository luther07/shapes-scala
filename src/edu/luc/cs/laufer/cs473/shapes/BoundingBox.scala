package edu.luc.cs.laufer.cs473.shapes

object BoundingBox {
  def boundingBox(s: Shape): Location = s match {
    case Rectangle(_, _) =>
      Location(0, 0, s)
    case Location(x, y, shape) => {
      val b = boundingBox(shape)
      Location(x + b.x, y + b.y, b.shape)
    }
    case Ellipse(width, height) =>
      Location(-(width), -(height), new Rectangle(width * 2, height * 2))
    case Group(multishapes @ _*) => {
      val b = List()
      for (elem <- multishapes) (boundingBox(elem))::b
      //for (elem <- multishapes) println(boundingBox(elem))
      //for (elem <- multishapes) println(elem.getClass())
      //for (elem <- multishapes) println(elem)
      //listShapes =new List()
      //multishapes.foreach(x => )
      // val extractor = Group.unapplySeq( multishapes )
      println(b)
      Location(0,0,Rectangle(1,1))
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
