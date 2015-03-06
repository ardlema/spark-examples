package org.ardlema.sparkexamples

import org.apache.spark.rdd.RDD
import org.apache.spark.{SparkConf, SparkContext}

trait CombinerExamples {

  val conf = new SparkConf()
    .setAppName("ExampleApp")
    .setMaster("local[2]")
  val sc = new SparkContext(conf)

  def getPerKeyAverageUsingCombineByKey(values: RDD[(String, Int)]) = {

  }
}

