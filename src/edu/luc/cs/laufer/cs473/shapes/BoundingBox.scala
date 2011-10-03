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
        val minx = (a.x).min(b.x)
        val miny = (a.y).min(b.x)
        val rectWidth = (a.x + a.shape.width).max(b.x + b.shape.width)
        val rectHeight = (a.y + a.shape.height).max(b.x + b.shape.height)
        Location(minx, miny, Rectangle(rectWidth, rectHeight))
      })

    }

    // TODO add missing cases (see test fixtures)
    // must use map and reduceLeft (or foldLeft) for Group (no mutable variables!)
  }
}
