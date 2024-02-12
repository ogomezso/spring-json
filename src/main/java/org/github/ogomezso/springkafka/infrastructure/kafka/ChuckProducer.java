package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.github.ogomezso.springkafka.infrastructure.kafka.config.KafkaConfigProperties;
import org.slf4j.Logger;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Component
class ChuckProducer {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ChuckProducer.class);
  private final KafkaConfigProperties configProperties;

  private final KafkaTemplate<String, ChuckFact> chuckTemplate;


  ChuckProducer(
          KafkaConfigProperties configProperties,
          KafkaTemplate<String, ChuckFact> chuckTemplate) {
    this.configProperties = configProperties;
    this.chuckTemplate = chuckTemplate;
  }

  public void sendFact(ChuckFact fact) {
    ListenableFuture<SendResult<String, ChuckFact>> resultFuture = chuckTemplate
            .send(configProperties.getAppProperties().getChuckTopic(), fact);

    resultFuture.addCallback(new ListenableFutureCallback<>() {
      @Override
      public void onFailure(Throwable throwable) {
        log.error("Unable to Send chuck fact to kafka: {}", fact);
      }

      @Override
      public void onSuccess(SendResult<String, ChuckFact> result) {
        log.info("chuck fact delivered: {}. Event Offset: {}", fact,
                result.getRecordMetadata().offset());
      }
    });
  }
}
