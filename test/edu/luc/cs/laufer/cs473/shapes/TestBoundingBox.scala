package edu.luc.cs.laufer.cs473.shapes

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

import BoundingBox._
import TestFixtures._

@RunWith(classOf[JUnitRunner])
class TestBoundingBox extends FunSuite {

  def testBoundingBox(description: String, s: Shape, x: Int, y: Int, width: Int, height: Int) = {
    test(description) {
	  val b = boundingBox(s)
	  val r = b.shape.asInstanceOf[Rectangle]
	  assert(x === b.x)
	  assert(y === b.y)
	  assert(width === r.width)
	  assert(height === r.height)
    }
  }

// TODO comment these tests back in

  testBoundingBox("simple ellipse", simpleEllipse, -50, -30, 100, 60)
  testBoundingBox("simple rectangle", simpleRectangle, 0, 0, 80, 120)
  testBoundingBox("simple location", simpleLocation, 70, 30, 80, 120)
  testBoundingBox("basic group", basicGroup, -50, -30, 100, 70)
  testBoundingBox("simple group", simpleGroup, 150, 70, 350, 280)
  testBoundingBox("groupOne", groupOne, -200, -200, 101, 101) 
  testBoundingBox("groupTwo", groupTwo, -200, -200, 101, 301)
  testBoundingBox("groupThree", groupThree, -200, -200, 301, 301)
  testBoundingBox("groupFour", groupFour, -200, -200, 301, 101)
  testBoundingBox("groupFive", groupFive, -200, 100, 101, 101)
  testBoundingBox("groupSix", groupSix, -200, 100, 301, 101)
  testBoundingBox("groupSeven", groupSeven, 100, 100, 101, 101)
  testBoundingBox("groupEight", groupEight, 100, -200, 101, 301)
  testBoundingBox("groupNine", groupNine, 100, -200, 101, 101)

  
  testBoundingBox("complex group", complexGroup, 30, 60, 470, 320)
}
