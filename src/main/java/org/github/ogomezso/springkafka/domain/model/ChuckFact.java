package org.github.ogomezso.springkafka.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Value;

@Builder
@Value
public class ChuckFact {
  @JsonProperty
  String id;
  @JsonProperty
  Long timestamp;
  @JsonProperty
  String fact;
}
