package RunningServer;

import Service.CSVfileReader;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;

import java.nio.charset.Charset;
import java.util.Random;

public class JavaRunner {
    public static void main(String[] args) {

        CSVfileReader csVfileReader = new CSVfileReader();

        Dataset<Row> dataset = csVfileReader.createcsv(csVfileReader.createSparkContext());

        Dataset<Row> df = dataset.groupBy("username").count();

        df.show();

        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array);

        df.write().format("text").save("/path/to/save");




    }
}
