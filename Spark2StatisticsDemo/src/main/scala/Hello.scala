
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object Hello {
  def main(args: Array[String]) {
    val conf = new SparkConf().setAppName("Simple Word Count Application").setMaster("local[2]").set("spark.executor.memory", "1g")
    val sc = new SparkContext(conf)
    val myFile = sc.textFile("hdfs://quickstart.cloudera/user/cloudera/input.txt")
    val wordspair = myFile.flatMap(row => row.split(" ")).map(x => (x, 1)).reduceByKey(_ + _)
    wordspair.foreach(println)
  }

}
