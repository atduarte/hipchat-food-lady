package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundWrapper.class)
public interface WebhookInboundWrapper {
    @Nullable
    String event();

    WebhookInboundItem item();

    @Nullable
    @JsonProperty("oauth_client_id")
    String oauthClientId();

    @Nullable
    @JsonProperty("webhook_id")
    String webhookId();
}
