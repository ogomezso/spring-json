package org.github.ogomezso.springkafka.infrastructure.rest.model;

import java.util.Objects;

public class ChuckFactResponse {

  private Long timestamp;
  private String fact;

  ChuckFactResponse(Long timestamp, String fact) {
    this.timestamp = timestamp;
    this.fact = fact;
  }

  public static ChuckFactResponseBuilder builder() {
    return new ChuckFactResponseBuilder();
  }

  public Long getTimestamp() {
    return this.timestamp;
  }

  public String getFact() {
    return this.fact;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }

  public void setFact(String fact) {
    this.fact = fact;
  }

  public boolean equals(final Object o) {
    if (o == this) return true;
    if (!(o instanceof ChuckFactResponse)) return false;
    final ChuckFactResponse other = (ChuckFactResponse) o;
    if (!other.canEqual((Object) this)) return false;
    final Object this$timestamp = this.getTimestamp();
    final Object other$timestamp = other.getTimestamp();
    if (!Objects.equals(this$timestamp, other$timestamp)) return false;
    final Object this$fact = this.getFact();
    final Object other$fact = other.getFact();
    if (!Objects.equals(this$fact, other$fact)) return false;
    return true;
  }

  protected boolean canEqual(final Object other) {
    return other instanceof ChuckFactResponse;
  }

  public int hashCode() {
    final int PRIME = 59;
    int result = 1;
    final Object $timestamp = this.getTimestamp();
    result = result * PRIME + ($timestamp == null ? 43 : $timestamp.hashCode());
    final Object $fact = this.getFact();
    result = result * PRIME + ($fact == null ? 43 : $fact.hashCode());
    return result;
  }

  public String toString() {
    return "ChuckFactResponse(timestamp=" + this.getTimestamp() + ", fact=" + this.getFact() + ")";
  }

  public static class ChuckFactResponseBuilder {
    private Long timestamp;
    private String fact;

    ChuckFactResponseBuilder() {
    }

    public ChuckFactResponseBuilder timestamp(Long timestamp) {
      this.timestamp = timestamp;
      return this;
    }

    public ChuckFactResponseBuilder fact(String fact) {
      this.fact = fact;
      return this;
    }

    public ChuckFactResponse build() {
      return new ChuckFactResponse(this.timestamp, this.fact);
    }

    public String toString() {
      return "ChuckFactResponse.ChuckFactResponseBuilder(timestamp=" + this.timestamp + ", fact=" + this.fact + ")";
    }
  }
}
