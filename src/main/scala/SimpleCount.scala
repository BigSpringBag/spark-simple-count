// import required spark classes
import org.apache.spark.SparkContext
import org.apache.spark.SparkContext._
import org.apache.spark.SparkConf
 
// define main method (scala entry point)
object SimpleCount {
  def main(args: Array[String]) {
    val logFile = "/Users/BSB/spark-2.1.0-bin-hadoop2.6/README.md" // Should be some file on your system
    val conf = new SparkConf().setAppName("Simple Application").setMaster("local[*]")
    val sc = new SparkContext(conf)
    val logData = sc.textFile(logFile, 2).cache()
    val numAs = logData.filter(line => line.contains("a")).count()
    val numBs = logData.filter(line => line.contains("b")).count()
    println("--------------------------------------------")
    println(s"Lines with a: $numAs, Lines with b: $numBs")
    println("--------------------------------------------")
    sc.stop()
    
  }
}
