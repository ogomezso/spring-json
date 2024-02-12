package org.github.ogomezso.springkafka.infrastructure.rest;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.github.ogomezso.springkafka.infrastructure.kafka.ChuckAdapter;
import org.github.ogomezso.springkafka.infrastructure.rest.model.ChuckFactResponse;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ChuckController {

  private static final Logger log = org.slf4j.LoggerFactory.getLogger(ChuckController.class);
  private final ChuckAdapter chuckAdapter;
  private final FactResponseMapper mapper;

  @Autowired
  public ChuckController(ChuckAdapter chuckAdapter, FactResponseMapper mapper) {
    this.chuckAdapter = chuckAdapter;
    this.mapper = mapper;
  }

  @PostMapping("/chuck-says")
  public ChuckFactResponse sendFact() throws JsonProcessingException {
    return mapper.toResponse(chuckAdapter.sendFact());

  }

}