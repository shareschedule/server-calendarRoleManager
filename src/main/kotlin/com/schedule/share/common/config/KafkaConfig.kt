import org.apache.kafka.clients.consumer.ConsumerConfig
import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.annotation.EnableKafka
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory
import org.springframework.kafka.core.ConsumerFactory
import org.springframework.kafka.core.DefaultKafkaConsumerFactory
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer

@EnableKafka
@Configuration
class KafkaConfig {

//    @Value("\${BOOTSTRAP_SERVERS_IP}")
    private var BOOTSTRAP_SERVERS_IP: String = "localhost:29092"

//    @Value("\${GROUP_ID_NAME}")
    private var GROUP_ID_NAME: String = "calendar-role-manager"

    @Bean
    fun consumerFactory(): ConsumerFactory<String, String> {
        val stringDeserializer = StringDeserializer()
        val errorHandlingDeserializer = ErrorHandlingDeserializer(stringDeserializer)

        val props: MutableMap<String, Any> = HashMap()
        props[ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG] = BOOTSTRAP_SERVERS_IP
        props[ConsumerConfig.GROUP_ID_CONFIG] = GROUP_ID_NAME
        props[ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG] = StringDeserializer::class.java
        props[ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG] = errorHandlingDeserializer

        return DefaultKafkaConsumerFactory(props)
    }

    @Bean
    fun kafkaListener(): ConcurrentKafkaListenerContainerFactory<String, String> {
        val factory = ConcurrentKafkaListenerContainerFactory<String, String>()
        factory.consumerFactory = consumerFactory()

        return factory
    }
}