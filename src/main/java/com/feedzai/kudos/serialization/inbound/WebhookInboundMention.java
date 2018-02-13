package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

import java.util.Map;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundMention.class)
public interface WebhookInboundMention {
    @Nullable
    Long id();

    @Nullable
    Map<String, String> links();

    @Nullable
    @JsonProperty("mention_name")
    String mentionName();

    @Nullable
    String name();

    @Nullable
    String version();
}

