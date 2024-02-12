package org.github.ogomezso.springkafka.domain.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;

public final class ChuckFact {
  @JsonProperty
  private final
  String id;
  @JsonProperty
  private final
  Long timestamp;
  @JsonProperty
  private final
  String fact;

  ChuckFact(String id, Long timestamp, String fact) {
    this.id = id;
    this.timestamp = timestamp;
    this.fact = fact;
  }

  public static ChuckFactBuilder builder() {
    return new ChuckFactBuilder();
  }

  public String getId() {
    return this.id;
  }

  public Long getTimestamp() {
    return this.timestamp;
  }

  public String getFact() {
    return this.fact;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof ChuckFact)) return false;
    final ChuckFact other = (ChuckFact) o;
    final Object this$id = this.getId();
    final Object other$id = other.getId();
    if (!Objects.equals(this$id, other$id)) return false;
    final Object this$timestamp = this.getTimestamp();
    final Object other$timestamp = other.getTimestamp();
    if (!Objects.equals(this$timestamp, other$timestamp)) return false;
    final Object this$fact = this.getFact();
    final Object other$fact = other.getFact();
    if (!Objects.equals(this$fact, other$fact)) return false;
    return true;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $id = this.getId();
    result = result * PRIME + ($id == null ? 43 : $id.hashCode());
    final Object $timestamp = this.getTimestamp();
    result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
    final Object $fact = this.getFact();
    result = result * PRIME + ($fact == null ? 43 : $fact.hashCode());
    return result;
  }

  public String toString() {
    return "ChuckFact(id=" + this.getId() + ", timestamp=" + this.getTimestamp() + ", fact=" + this.getFact() + ")";
  }

  public static class ChuckFactBuilder {
    private String id;
    private Long timestamp;
    private String fact;

    ChuckFactBuilder() {
    }

    @JsonProperty
    public ChuckFactBuilder id(String id) {
      this.id = id;
      return this;
    }

    @JsonProperty
    public ChuckFactBuilder timestamp(Long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    @JsonProperty
    public ChuckFactBuilder fact(String fact) {
      this.fact = fact;
      return this;
    }

    public ChuckFact build() {
      return new ChuckFact(this.id, this.timestamp, this.fact);
    }

    public String toString() {
      return "ChuckFact.ChuckFactBuilder(id=" + this.id + ", timestamp=" + this.timestamp + ", fact=" + this.fact + ")";
    }
  }
}
