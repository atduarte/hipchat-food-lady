package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundItem.class)
public interface WebhookInboundItem {
    WebhookInboundMessage message();

    @Nullable
    WebhookInboundRoom room();
}
