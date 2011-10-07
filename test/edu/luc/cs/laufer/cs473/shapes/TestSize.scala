package edu.luc.cs.laufer.cs473.shapes

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.FunSuite

import BoundingBox._
import TestFixtures._
import Size._

@RunWith(classOf[JUnitRunner])
class TestSize extends FunSuite {

  def testSize(description: String, s: Shape, num: Int) = {
    test(description) {
          assert(s === size(s))
    }
  }

// TODO comment these tests back in
  testSize("simple ellipse", simpleEllipse, 1)
  testSize("simple rectangle", simpleRectangle, 1)
  testSize("simple location", simpleLocation, 1)
  testSize("basic group", basicGroup, 2)
  testSize("simple group", simpleGroup, 2)
  testSize("groupOne", groupOne, 2) 
  testSize("groupTwo", groupTwo, 2)
  testSize("groupThree", groupThree, 2)
  testSize("groupFour", groupFour, 2)
  testSize("groupFive", groupFive, 2)
  testSize("groupSix", groupSix, 2)
  testSize("groupSeven", groupSeven, 2)
  testSize("groupEight", groupEight, 2)
  testSize("groupNine", groupNine, 2)
  testSize("complex group", complexGroup, 8)  
}
