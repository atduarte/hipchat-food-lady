package com.feedzai.kudos.serialization.outbound;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookOutboundCardThumbnail.class)
public interface WebhookOutboundCardThumbnail {
    @Nullable
    String url();
}
