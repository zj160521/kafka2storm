package sender;

import info.PlatformData;
import info.PlatformInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class PlatformMqSender {
    public static void main(String[] args) {
        String TOPIC = "gameRecord";
        Properties props = new Properties();
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("bootstrap.servers", "192.168.3.85:9092");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);
        for (int messageNo = 0; messageNo < 6; messageNo++) {
            String str = new PlatformData(new PlatformInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            long timeMillis = System.currentTimeMillis();
            producer.send(new ProducerRecord<String, String>(TOPIC, timeMillis + "",str));
        }
        producer.flush();
    }
}
