package com.feedzai.kudos.serialization.outbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookOutboundWrapper.class)
public interface WebhookOutboundWrapper {
    @Nullable
    @JsonProperty("message_format")
    String messageFormat();

    @Nullable
    String color();

    @Nullable
    String message();

    @Nullable
    WebhookOutboundCard card();
}
