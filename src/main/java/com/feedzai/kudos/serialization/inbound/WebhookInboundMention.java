package com.feedzai.kudos.serialization.inbound;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookInboundMention.class)
public interface WebhookInboundMention {

}

