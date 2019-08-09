package sender;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import info.ActivityData;
import info.ActivityInfo;

import java.util.Properties;

public class ActivityMqSender {
    public static void main(String[] args) {
        String TOPIC = "activity_stat";
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.169.7.20:9092");
        props.put("request.required.acks", "1");
        props.put("partitioner.class", "kafka.producer.DefaultPartitioner");
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(props));
        for (int messageNo = 0; messageNo < 3; messageNo++) {
            String str = new ActivityData(new ActivityInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            producer.send(new KeyedMessage<String, String>(TOPIC, messageNo + "",str));
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
        }
    }
}
