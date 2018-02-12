package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundRoom.class)
public interface WebhookInboundRoom {
    @Nullable
    Long id();

    @Nullable
    @JsonProperty("is_archived")
    Boolean isArchived();

    @Nullable
    Map<String, String> links();

    @Nullable
    String name();

    @Nullable
    String privacy();

    @Nullable
    String version();
}

