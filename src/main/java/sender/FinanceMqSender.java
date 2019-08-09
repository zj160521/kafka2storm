package sender;

import kafka.javaapi.producer.Producer;
import kafka.producer.KeyedMessage;
import kafka.producer.ProducerConfig;
import info.FinanceData;
import info.FinanceInfo;

import java.util.Properties;

public class FinanceMqSender {
    public static void main(String[] args) {
        String TOPIC = "financeRec";
        Properties props = new Properties();
        props.put("serializer.class", "kafka.serializer.StringEncoder");
        props.put("metadata.broker.list", "192.169.7.20:9092");
        props.put("request.required.acks", "1");
        props.put("partitioner.class", "kafka.producer.DefaultPartitioner");
        Producer<String, String> producer = new Producer<String, String>(new ProducerConfig(props));

        for (int messageNo = 0; messageNo < 1; messageNo++) {
            String str = new FinanceData(new FinanceInfo().random()).random();
            System.out.println(">>>>>>>>>"+str);
            producer.send(new KeyedMessage<String, String>(TOPIC, messageNo + "",str));

        }
    }
}
