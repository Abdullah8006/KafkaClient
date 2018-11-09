package com.abd.kafka.KafkaClient.util;

public interface Constants {
	public static final String KAFKA_BROKERS = "localhost:9092";
	public static final Integer MESSAGE_COUNT = 1000;
	public static final String CLIENT_ID = "client1";
	public static final String TOPIC_NAME = "topic-student";
	public static final String GROUP_ID_CONFIG = "consumerGroup1";
	public static final Integer MAX_NO_MESSAGE_FOUND_COUNT = 100;
	public static final String OFFSET_RESET_LATEST = "latest";
	public static final String OFFSET_RESET_EARLIER = "earliest";
	public static final Integer MAX_POLL_RECORDS = 1;
}
