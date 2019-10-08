package sender;

import info.ActivityData;
import info.ActivityInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class ActivityMqSender {
    public static void main(String[] args) {
        String TOPIC = "flink_test";
        Properties props = new Properties();
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("bootstrap.servers", "192.168.3.85:9092");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int messageNo = 0; messageNo < 1; messageNo++) {
            String str = new ActivityData(new ActivityInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            producer.send(new ProducerRecord<String, String>(TOPIC, messageNo + "",str));
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
        producer.flush();
    }
}
