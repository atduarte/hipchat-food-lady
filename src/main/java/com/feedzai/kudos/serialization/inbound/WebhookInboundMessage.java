package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

import java.util.Date;
import java.util.List;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundMessage.class)
public interface WebhookInboundMessage {
    @Nullable
    Date date();

    @Nullable
    WebhookInboundFrom from();

    @Nullable
    String id();

    @Nullable
    String color();

    @Nullable
    @JsonProperty("message_format")
    String messageFormat();

    @Nullable
    List<WebhookInboundMention> mentions();

    String message();

    @Nullable
    String type();
}

