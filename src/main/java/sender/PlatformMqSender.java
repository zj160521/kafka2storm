package sender;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import info.PlatformData;
import info.PlatformInfo;

import java.util.Properties;

public class PlatformMqSender {
    public static void main(String[] args) {
        String TOPIC = "gameRecord";
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.169.7.20:9092");
        props.put("request.required.acks", "1");
        props.put("partitioner.class", "kafka.producer.DefaultPartitioner");
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(props));
        for (int messageNo = 0; messageNo < 6; messageNo++) {
            String str = new PlatformData(new PlatformInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            producer.send(new KeyedMessage<String, String>(TOPIC, messageNo + "",str));
        }
    }
}
