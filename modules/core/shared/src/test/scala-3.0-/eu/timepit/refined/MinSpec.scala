package eu.timepit.refined

import eu.timepit.refined.api.{Min, Refined}
import eu.timepit.refined.boolean._
import eu.timepit.refined.numeric._
import eu.timepit.refined.types.numeric._
import org.scalacheck.Prop._
import org.scalacheck.Properties
import shapeless.nat._
import shapeless.tag.@@

class MinSpec extends Properties("Min") {

  property("Min[Int Refined Greater[W.`1`.T]]") = secure {
    Min[Int Refined Greater[W.`1`.T]].min.value ?= 2
  }

  property("Min[Int Refined Greater[_0]]") = secure {
    Min[Int Refined Greater[_0]].min.value ?= 1
  }

  property("Min[Long Refined Greater[_0]]") = secure {
    Min[Long Refined Greater[_0]].min.value ?= 1L
  }

  property("Min[Float Refined Greater[_0]]") = secure {
    Min[Float Refined Greater[W.`0f`.T]].min.value ?= "1.4E-45".toFloat
  }

  property("Min[Byte Refined Less[_0]]") = secure {
    Min[Byte Refined Less[_0]].min.value ?= Byte.MinValue
  }

  property("Min[Short Refined Less[_0]]") = secure {
    Min[Short Refined Less[_0]].min.value ?= Short.MinValue
  }

  property("Min[Int Refined Less[_0]]") = secure {
    Min[Int Refined Less[_0]].min.value ?= Int.MinValue
  }

  property("Min[Long Refined Less[_0]]") = secure {
    Min[Long Refined Less[_0]].min.value ?= Long.MinValue
  }

  property("Min[Float Refined Less[_0]]") = secure {
    Min[Float Refined Less[_0]].min.value ?= Float.MinValue
  }

  property("Min[Double Refined Less[_0]]") = secure {
    Min[Double Refined Less[_0]].min.value ?= Double.MinValue
  }

  property("Min[Int Refined NonPositive]") = secure {
    Min[Int Refined NonPositive].min.value ?= Int.MinValue
  }

  property("Min[Int Refined NonNegative]") = secure {
    Min[Int Refined NonNegative].min.value ?= 0
  }

  property("Min[Float Refined NonNegative]") = secure {
    Min[Float Refined NonNegative].min.value ?= 0f
  }

  property("Min[Double Refined NonNegative]") = secure {
    Min[Double Refined NonNegative].min.value ?= 0f
  }

  property("Min[Int Refined Not[Less[W.`-5`.T]]]") = secure {
    Min[Int Refined Not[Less[W.`-5`.T]]].min.value ?= -5
  }

  property("Min[Int Refined Interval.Open[_1, _4]]") = secure {
    Min[Int Refined Interval.Open[_1, _4]].min.value ?= 2
  }

  property("Min[Int @@ Interval.Open[_1, _4]]") = secure {
    Min[Int @@ Interval.Open[_1, _4]].min.asInstanceOf[Int] ?= 2
  }

  property("Min[Double Refined Interval.Open[_1, _4]]") = secure {
    Min[Double Refined Interval.Open[_1, _4]].min.value ?= 1.0000000000000002
  }

  property("Min[Int Refined Interval.Closed[W.`-20`.T, W.`10`.T]]") = secure {
    Min[Int Refined Interval.Closed[W.`-20`.T, W.`10`.T]].min.value ?= -20
  }

  property("Min[Double Refined Interval.Closed[W.`-20.001d`.T, W.`0d`.T]]") = secure {
    Min[Double Refined Interval.Closed[W.`-20.001d`.T, W.`0d`.T]].min.value ?= -20.001d
  }

  property("Min[Char Refined Interval.Closed[W.`'A'`.T, W.`'Z'`.T]]") = secure {
    Min[Char Refined Interval.Closed[W.`'A'`.T, W.`'Z'`.T]].min.value ?= 'A'
  }

  property("Min[Int Refined Even]") = secure {
    Min[Int Refined Even].min.value ?= Int.MinValue
  }

  property("Min[Int Refined Divisible[_5]]") = secure {
    Min[Int Refined Divisible[_5]].min.value ?= -2147483645
  }

  property("Min[Int Refined (Positive And Even)]") = secure {
    Min[Int Refined (Positive And Even)].min.value ?= 2
  }

  property("CompanionObject.min - Positive - Long") = secure {
    PosLong.MinValue ?= PosLong.unsafeFrom(1)
  }

  property("CompanionObject.min - Negative - Float") = secure {
    NegFloat.MinValue ?= NegFloat.unsafeFrom(Float.MinValue)
  }
}
