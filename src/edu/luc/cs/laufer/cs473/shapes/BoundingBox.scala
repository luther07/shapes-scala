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
      //I'm doing it wrong: need to only process two at a time instead of processing globally
      val boxes = multishapes.toList.map(boundingBox(_)) //map Group items to BB
      
      val result = boxes.reduceLeft((a:Shape, b:Shape) => { 
        val ax = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(x, _, Rectangle(_,_))) => x 
        }
        val ay = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, y, Rectangle(_,_))) => y
        }
        val bx = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(x, _, Rectangle(_,_))) => x
        }
        val by = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, y, Rectangle(_,_))) => y
        }
        val minx = (ax).min(bx)
        val miny = (ay).min(by)
        val recta = a match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, _, Rectangle(w,h))) => Rectangle(w,h)
        }
        val rectb = b match{
          case (edu.luc.cs.laufer.cs473.shapes.Location(_, _, Rectangle(w,h))) => Rectangle(w,h)
        }
        val rectWidth = ((ax + recta.width).max(bx + rectb.width)-minx)
        val rectHeight = ((ay + recta.height).max(bx + rectb.height)-miny)
        Location(minx, miny, Rectangle(rectWidth, rectHeight))
      })
      //Location(1, 1, Rectangle(1, 1))
      result
      //Location(-50, -30, Rectangle(100, 70))
    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
