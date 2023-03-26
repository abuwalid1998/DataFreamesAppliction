package Service;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class CSVfileReader {

    public SparkSession createSparkContext() {

        SparkConf conf = new SparkConf().setAppName("Main")
                .setMaster("local")
                .set("spark.executor.memory", "3g")
                .set("spark.driver.memory", "3g");

        JavaSparkContext sc = new JavaSparkContext(conf);

        return SparkSession.builder().sparkContext(sc.sc()).getOrCreate();
    }
    public Dataset<Row> createcsv(SparkSession sparkSession){

       Dataset<Row> dataset = sparkSession.sqlContext().read().option("header",true).csv("src/main/resources/MOCK_DATA (1).csv");



       dataset.show(false);

       return dataset;
    }


}
