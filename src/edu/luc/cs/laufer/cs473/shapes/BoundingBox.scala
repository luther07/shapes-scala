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
      val b = multishapes.toList.map (boundingBox(_)) //map Group items to BB
      
      
      val xs = b.map(_.x).reduceLeft((x1,x2) => x1.min(x2)) //map and reduce x val's to get min
      
      val ys = b.map(_.y).reduceLeft((y1,y2) => y1.min(y2)) //map and reduce y val's to get min
      
      val shapeses = b.map(_.shape) //map BB's to their shapes
      
      //need recursive function or reduceLeft function to reduce shapeses to a single boundingBox
      //val mysolution = shapeses.reduceLeft((rect1, rect2) => {
      //  rect1.asInstanceOf[edu.luc.cs.laufer.cs473.shapes.Rectangle].width })
      
      for (elem <- shapeses) elem match{ //pattern match the shapes to Rectangles and print width
        case (edu.luc.cs.laufer.cs473.shapes.Rectangle(width,height)) => println(width) }
      
      for (elem <- shapeses) elem match{ //pattern match the shapes to Rectangles and print height
        case (edu.luc.cs.laufer.cs473.shapes.Rectangle(width,height)) => println(height) }

      Location(0,0,Rectangle(1,1))
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
