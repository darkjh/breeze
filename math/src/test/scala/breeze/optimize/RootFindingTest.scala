package breeze.optimize

import org.scalatest.FunSuite
import breeze.numerics.closeTo

/**
  * Tests for the RootFinding object
  * @author abertout
  **/
class RootFindingTest extends FunSuite {
  val f = (x: Double) => x*x
  val f2 = (x: Double) => math.sin(x)
  val f3 = (x: Double) =>  (x + 3)*(x - 1)*(x - 1)
  val f4 = (x: Double) => 2*x


  test("root finding") {
    val  found = RootFinding.find(f3,x0 = -4,x1 = Some(4/3.0))
    assert(closeTo(found,1d) || closeTo(found,-3d))
    assert(closeTo(RootFinding.find(f2, 3),3.1416))
    //assert(closeTo(RootFinding.brent(f, -1,1),0))

  }

  test("incorrect initial interval") {
    intercept[Exception] {
      RootFinding.brent(f4, -5, 5)
      RootFinding.find(f, 0.1)
    }
  }




}
