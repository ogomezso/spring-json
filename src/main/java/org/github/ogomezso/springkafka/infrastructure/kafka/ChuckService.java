package org.github.ogomezso.springkafka.infrastructure.kafka;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.github.ogomezso.springkafka.domain.ChuckFactPort;
import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
class ChuckService implements ChuckAdapter {

  private final ChuckProducer chuckProducer;
  private final ChuckFactPort chuckFactPort;
  private final ObjectMapper objectMapper;

  @Autowired
  public ChuckService(ChuckProducer chuckProducer, ChuckFactPort chuckFactPort, ObjectMapper objectMapper) {
    this.chuckProducer = chuckProducer;
    this.chuckFactPort = chuckFactPort;
    this.objectMapper = objectMapper;
  }

  @Override
  public ChuckFact sendFact() throws JsonProcessingException {
    ChuckFact fact = chuckFactPort.buildFact();
    chuckProducer.sendFact(fact);
    return fact;
  }
}
