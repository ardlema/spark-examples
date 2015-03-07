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

  "CombinerExamples" should "get the average of a key value rdd using combineByKey" in new AverageRDD {
    val avgResult = getPerKeyAverageUsingCombineByKey(rdd).collect
    avgResult should contain theSameElementsAs(expectedAvgArray)
  }

  it should "get the average of a key value rdd using aggregate" in new AverageRDD {
    val avgResult = getPerKeyAverageUsingAggregateByKey(rdd).collect
    avgResult should contain theSameElementsAs(expectedAvgArray)
  }

  it should "get the average of a key value rdd using reduceByKey" in new AverageRDD {
    val avgResult = getPerKeyAverageUsingReduceByKey(rdd).collect
    avgResult should contain theSameElementsAs(expectedAvgArray)
  }
}

