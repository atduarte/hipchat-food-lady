package com.feedzai.kudos.serialization.outbound;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.feedzai.kudos.serialization.Nullable;
import org.immutables.value.Value;

@Value.Immutable
@JsonDeserialize(as = ImmutableWebhookOutboundCard.class)
public interface WebhookOutboundCard {
    @Nullable
    String id();

    @Nullable
    String style();

    @Nullable
    String title();

    @Nullable
    WebhookOutboundCardDescription description();

    @Nullable
    WebhookOutboundCardThumbnail thumbnail();

    @Nullable
    WebhookOutboundCardIcon icon();
}
