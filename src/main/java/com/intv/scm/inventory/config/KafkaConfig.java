package com.intv.scm.inventory.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

public class KafkaConfig {

    @Bean
    public ProducerFactory<String, String> createProductory() {
        Map<String, Object> map = new HashMap<>();
        map.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        map.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        return new DefaultKafkaProducerFactory<>(map);
    }

    @Bean
    public KafkaTemplate createKafkaTemplate() {
        return new KafkaTemplate(createProductory());
    }

    @Bean
    public ConsumerFactory<String, String> createConsumerConfig() {
        Map<String, Object> map = new HashMap<>();
        map.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "");
        map.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        map.put(ConsumerConfig.GROUP_ID_CONFIG,"");
        map.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG,"earliest");
        return new DefaultKafkaConsumerFactory<>(map, new StringDeserializer(), new StringDeserializer());
    }

    public KafkaListenerContainerFactory createListenerFactory() {
        ConcurrentKafkaListenerContainerFactory concurrentKafkaListenerContainerFactory
                =new ConcurrentKafkaListenerContainerFactory<>();
        concurrentKafkaListenerContainerFactory.setConsumerFactory(createConsumerConfig());
        return concurrentKafkaListenerContainerFactory;
    }
}
