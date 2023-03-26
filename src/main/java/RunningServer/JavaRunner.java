package RunningServer;

import Service.CSVfileReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SaveMode;

import java.nio.charset.Charset;
import java.util.Random;

public class JavaRunner {
    public static void main(String[] args) {

        CSVfileReader csVfileReader = new CSVfileReader();

        Dataset<Row> dataset = csVfileReader.createcsv(csVfileReader.createSparkContext());

        Dataset<Row> df = dataset.groupBy("usercity").count();



        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array);


        df = dataset.groupBy("usercity").count();

        df.show();


        df.repartition(1).write().mode(SaveMode.Overwrite)
                .csv("src/main/resources/Results");


    }
}
