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
      val b = multishapes.toList map (boundingBox(_)) //map Group items to BB
      
      val xs = b map (_.x) //map BB's to their x val's
      val finalx = xs.reduceLeft((x1,x2) => x1.min(x2)) //reduce x val's to get min
      
      val ys = b map (_.y) //map BB's to their y val's
      val finaly = ys.reduceLeft((y1,y2) => y1.min(y2)) //reduce y val's to get min
      
      val shapeses = b map (_.shape) //map BB's to their shapes
      for (elem <- shapeses) elem match{
        case (edu.luc.cs.laufer.cs473.shapes.Rectangle(width,height)) => println(width) }

      Location(0,0,Rectangle(1,1))
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
