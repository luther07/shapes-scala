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
      val boxes = multishapes.toList.map(boundingBox(_)) //map Group items to BB
      
      /* The function passed to reduceLeft must process two shapes at a time,
       * returning the  bounding box on those two shapes. The reduceLeft function
       * will apply the function repeatedly on all shapes list "boxes".
       */
      val result = boxes.reduceLeft((a:Shape, b:Shape) => {
        val ax = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(x, _, Rectangle(_,_))) => x 
          case _ => -1234
        }
        val ay = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, y, Rectangle(_,_))) => y
          case _ => -1234
        }
        val bx = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(x, _, Rectangle(_,_))) => x
          case _ => -1234
        }
        val by = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, y, Rectangle(_,_))) => y
          case _ => -1234
        }
        val minx = (ax).min(bx)
        val miny = (ay).min(by)
        val recta = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, _, r @ Rectangle(_,_))) => r
          case _ => Rectangle(-1234,-1234)
        }
        val rectb = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, _, r @ Rectangle(_,_))) => r
          case _ => Rectangle(-1234,-1234)
        }
        val rectWidth = ((ax + recta.width).max(bx + rectb.width)+(-minx))
        val rectHeight = ((ay + recta.height).max(by + rectb.height)+(-miny))
        Location(minx, miny, Rectangle(rectWidth, rectHeight))
      })
      result
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
