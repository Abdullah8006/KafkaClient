package com.abd.kafka.KafkaClient.producer;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.LongSerializer;

import com.abd.kafka.KafkaClient.model.Student;
import com.abd.kafka.KafkaClient.util.Constants;
import com.abd.kafka.KafkaClient.util.CustomSerializer;

public class ProducerFactory {

	public static Producer<Long, Student> getProducer() {
		Properties props = new Properties();
		props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, Constants.KAFKA_BROKERS);
		props.put(ProducerConfig.CLIENT_ID_CONFIG, Constants.CLIENT_ID);
		props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, LongSerializer.class.getName());
		props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, CustomSerializer.class.getName());
		// props.put(ProducerConfig.PARTITIONER_CLASS_CONFIG,
		// CustomPartitioner.class.getName());
		return new KafkaProducer<>(props);
	}
}
