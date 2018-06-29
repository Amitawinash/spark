package Test.Amit;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.Dataset;

/**
 * @author amitkumar
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	String logFile = "/home/amit/Downloads/spark-2.3.1-bin-hadoop2.7/README.md"; // Should be some file on your system
        SparkSession spark = SparkSession.builder().appName("Simple_Application").config("spark.master", "local").getOrCreate();
        Dataset<String> logData = spark.read().textFile(logFile).cache();

        long numAs = logData.filter(s -> s.contains("building")).count();
        long numBs = logData.filter(s -> s.contains("b")).count();

        System.out.println("Lines with a: " + numAs + ", lines with b: " + numBs);

        spark.stop();
    }
}
