package com.abd.kafka.KafkaClient;

import java.util.concurrent.ExecutionException;

import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.abd.kafka.KafkaClient.consumer.ConsumerFactory;
import com.abd.kafka.KafkaClient.model.Student;
import com.abd.kafka.KafkaClient.producer.ProducerFactory;
import com.abd.kafka.KafkaClient.util.Constants;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		//runProducer();
		runConsumer();
	}

	public static void runConsumer() {
		Consumer<Long, Student> consumer = ConsumerFactory.getConsumer();
		int noMessageFound = 0;
		while (true) {
			ConsumerRecords<Long, Student> consumerRecords = consumer.poll(1000);
			// 1000 is the time in milliseconds consumer will wait if no record
			// is found at broker.
			if (consumerRecords.count() == 0) {
				noMessageFound++;
				if (noMessageFound > Constants.MAX_NO_MESSAGE_FOUND_COUNT)
					// If no message found count is reached to threshold exit
					// loop.
					break;
				else
					continue;
			}
			// print each record.
			consumerRecords.forEach(record -> {
				System.out.println("Record Key " + record.key());
				System.out.println("Record value " + record.value());
				System.out.println("Record partition " + record.partition());
				System.out.println("Record offset " + record.offset());
			});
			// commits the offset of record to broker.
			consumer.commitAsync();
		}
		consumer.close();
	}

	public static void runProducer() {
		Producer<Long, Student> producer = ProducerFactory.getProducer();
		for (int index = 0; index < Constants.MESSAGE_COUNT; index++) {
			ProducerRecord<Long, Student> record = new ProducerRecord<Long, Student>(Constants.TOPIC_NAME,
					new Student(index + 1, "Name " + index, String.valueOf(index % 5)));
			try {
				RecordMetadata metadata = producer.send(record).get();
				System.out.println("Record sent with key " + index + " to partition " + metadata.partition()
						+ " with offset " + metadata.offset());
			} catch (ExecutionException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			} catch (InterruptedException e) {
				System.out.println("Error in sending record");
				System.out.println(e);
			}
		}
	}
}
