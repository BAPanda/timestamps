package timestamps.kafkaintegration;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Autowired;

import timestamps.dao.impl.StatisticsDAOImpl;
import timestamps.models.Statistics;

public class Consumer {
	@Autowired
	StatisticsDAOImpl statisticsDAOImpl;
	
	KafkaConsumer<BigInteger, String> consumer;

	public Consumer(String topic) throws FileNotFoundException, IOException {
		Properties props = new Properties();
		props.load(new FileInputStream(new File("kafkaconsumer.properties")));
		
		consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Arrays.asList(topic));
	}
	
	public void run(){	
		
		ConsumerRecords<BigInteger, String> records = consumer.poll(5);
		for (ConsumerRecord<BigInteger, String> record : records) {
			String data = record.value();
			
			Statistics stat = new Statistics();
			stat.setEntityID(record.key());
			
			String[] params = data.split(":");
			
			stat.sethDDSpace(Double.parseDouble(params[0]));
			stat.setrAMLoad(Double.parseDouble(params[1]));
			stat.setTemperature(Double.parseDouble(params[2]));
			stat.setTimestamp(Long.parseLong(params[3]));
			
			statisticsDAOImpl.write(stat);
		}
		
	}
	
}
