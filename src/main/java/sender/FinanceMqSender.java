package sender;

import info.FinanceData;
import info.FinanceInfo;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;

public class FinanceMqSender {
    public static void main(String[] args) {
        String TOPIC = "financeRec";
        Properties props = new Properties();
        props.put("key.serializer", StringSerializer.class.getName());
        props.put("value.serializer", StringSerializer.class.getName());
        props.put("bootstrap.servers", "192.168.3.85:9092");
        Producer<String, String> producer = new KafkaProducer<String, String>(props);

        for (int messageNo = 0; messageNo < 1; messageNo++) {
            String str = new FinanceData(new FinanceInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            producer.send(new ProducerRecord<String, String>(TOPIC, messageNo + "",str));
        }
        producer.flush();
    }
}
