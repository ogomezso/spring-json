package org.github.ogomezso.springkafka.infrastructure.kafka;

import org.github.ogomezso.springkafka.domain.ChuckFactPort;
import org.github.ogomezso.springkafka.domain.model.ChuckFact;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
class ChuckService implements ChuckAdapter {

  private final ChuckProducer chuckProducer;
  private final ChuckFactPort chuckFactPort;
  private final ObjectMapper objectMapper;

  @Override
  public ChuckFact sendFact() throws JsonProcessingException {
    ChuckFact fact = chuckFactPort.buildFact();
    chuckProducer.sendFact(fact);
    return fact;
  }
}
