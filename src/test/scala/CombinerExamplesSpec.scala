package org.ardlema.sparkexamples

import org.scalatest.{ShouldMatchers, FlatSpec}

class CombinerExamplesSpec
  extends FlatSpec
  with CombinerExamples
  with ShouldMatchers {

  trait AverageRDD {

    val rdd = sc.parallelize(Seq(("panda", 1), ("pink", 3), ("pirate", 3), ("panda", 1), ("pink", 4)))
    val expectedAvgArray = Array(("panda",1.0), ("pirate",3.0), ("pink", 3.5))
  }

  "CombinerExamples" should "get the average of a key value rdd" in new AverageRDD {
    val avgResult = getPerKeyAverageUsingCombineByKey(rdd).collect
    avgResult should contain theSameElementsAs(expectedAvgArray)
  }
}

