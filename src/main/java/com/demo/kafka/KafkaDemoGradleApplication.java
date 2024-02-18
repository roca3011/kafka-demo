package com.demo.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Properties;

@SpringBootApplication
@Slf4j
public class KafkaDemoGradleApplication {

	public static void main(String[] args) {
		//SpringApplication.run(KafkaDemoGradleApplication.class, args);
		log.info("Starting application");

		Properties properties = new Properties();
		properties.setProperty("bootstrap.servers", "127.0.0.1:9092");

		properties.setProperty("key.serializer", StringSerializer.class.getName());
		properties.setProperty("value.serializer", StringSerializer.class.getName());

		KafkaProducer<String, String> producer = new KafkaProducer<>(properties);

		//It encapsulates the key, value, and optional metadata associated with a record.
		ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_topic", "Hello world");

		producer.send(producerRecord);
		//tell the producer to send all data and block until done
		producer.flush();
		//flush and close the producer
		producer.close();
		log.info("Ending application");

	}

}
