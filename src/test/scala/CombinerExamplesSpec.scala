package org.ardlema.sparkexamples

import org.scalatest.{ShouldMatchers, FlatSpec}

class CombinerExamplesSpec
  extends FlatSpec
  with CombinerExamples
  with ShouldMatchers {

  trait AverageRDD {
    val rdd = sc.parallelize(Seq(("panda", 1), ("pink", 3), ("pirate", 3), ("panda", 1), ("pink", 4)))
  }

  "CombinerExamples" should "get the average of a key value rdd" in new AverageRDD {
    getPerKeyAverageUsingCombineByKey(rdd) should be(Seq("panda",0.5), Seq("pirate",3), Seq("pink", 3.5))
  }
}

