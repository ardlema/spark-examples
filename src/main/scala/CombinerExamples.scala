package org.ardlema.sparkexamples

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}
import org.apache.spark.SparkContext._

trait CombinerExamples {

  val conf = new SparkConf()
    .setAppName("ExampleApp")
    .setMaster("local[2]")
  val sc = new SparkContext(conf)

  val combiner = (v: Int) => (v, 1)
  val mergeValue = (v1: (Int, Int), v2: Int) => ((v1._1 + v2), v1._2 + 1)
  val mergeCombiner = (v1: (Int, Int), v2: (Int, Int)) => ((v1._1 + v2._1), (v1._2 + v2._2))

  def getPerKeyAverageUsingCombineByKey(values: RDD[(String, Int)]): RDD[(String, Float)] = {
    val valuesCombined = values.combineByKey(combiner, mergeValue, mergeCombiner)
    valuesCombined.map{ case (key, value) => (key, value._1 / value._2.toFloat) }
  }
}

