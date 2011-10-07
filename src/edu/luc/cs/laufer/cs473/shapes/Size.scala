package edu.luc.cs.laufer.cs473.shapes

object Size {
  def size(s: Shape): Int = s match {
    case Rectangle(_, _) => {
      println(1)
      1
      }
    case Location(x, y, shape) => 
      size(shape)
    case Ellipse(width, height) =>
      1
    case Group(multishapes @ _*) => {
      val boxes = multishapes.toList.map(size(_)) //map Group items to their size
      
      /* The function passed to foldLeft must process two shapes at a time,
       * returning the accumulated size of those two shapes. The reduceLeft function
       * will apply the function repeatedly on all shapes list "boxes".
       */
      val result = boxes.foldLeft(0)((a:Int, b:Int) => {
        a + b
      })
      result
    }
    // TODO following BoundingBox, create a size function that counts the number 
    //                             of concrete leaf shapes (such as ellipses and rectangles)
    //                             in a general shape.
  }
}
