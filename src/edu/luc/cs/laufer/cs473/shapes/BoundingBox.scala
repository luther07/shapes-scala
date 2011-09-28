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
      val b = multishapes.toList map (boundingBox(_))
      for (elem <- b) println(elem)
      println("\n")
      val xs = b map (_.x)
      val finalx = xs.reduceLeft((x1,x2) => x1.min(x2))
      println(finalx)
      val ys = b map (_.y)
      val finaly = ys.reduceLeft((y1,y2) => y1.min(y2))
      println(finaly)
      val shapeses = b map (_.shape)
      //val finalshape = shapeses.reduceLeftOption((s1,s2) => s1.)
      //val finalshape = shapeses.reduceLeft((s1,s2) => Rectangle(a,b))
      //val stuff = b.reduceLeft((sh1,sh2) => Location(finalx, finaly, Rectangle(sh1.)))
      //for (elem <- b) println(elem)
      //println("\n")
      //for (elem <- multishapes) {}
      //val b = List()
      //for (elem <- multishapes) ((boundingBox(elem))::b)
      //for (elem <- multishapes) println(boundingBox(elem)+"\n")
      //for (elem <- multishapes) println(elem.getClass())
      //println("\n")
      //for (elem <- multishapes) println(elem)
      //listShapes =new List()
      //multishapes.foreach(x => )
      // val extractor = Group.unapplySeq( multishapes )
      //println(b)
      Location(0,0,Rectangle(1,1))
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
