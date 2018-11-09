package com.abd.kafka.KafkaClient.util;

import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.abd.kafka.KafkaClient.model.Student;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomDeserializer implements Deserializer<Student> {
	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
	}

	@Override
	public Student deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();
		Student object = null;
		try {
			object = mapper.readValue(data, Student.class);
		} catch (Exception exception) {
			System.out.println("Error in deserializing bytes " + exception);
		}
		return object;
	}

	@Override
	public void close() {
	}
}