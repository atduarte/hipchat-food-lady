package com.feedzai.kudos.serialization.outbound;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookOutboundCardIcon.class)
public interface WebhookOutboundCardIcon {
    @Nullable
    String url();
}
