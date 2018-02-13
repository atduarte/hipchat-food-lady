package com.feedzai.kudos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedzai.kudos.serialization.inbound.WebhookInboundWrapper;
import com.feedzai.kudos.serialization.outbound.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;

@Path("/")
public class HipChatKudosEndpoint {
    private ObjectMapper objectMapper;

    public HipChatKudosEndpoint() {
        this.objectMapper = new ObjectMapper();
    }

    @POST
    @Path("/kudos")
    @Produces({"application/json"})
    @Consumes({"application/json"})
    public String kudos(String dataStr) throws IOException {

        WebhookInboundWrapper inbound = objectMapper.readValue(dataStr, WebhookInboundWrapper.class);

        WebhookOutboundWrapper outboundWrapper =
                ImmutableWebhookOutboundWrapper.builder()
                        .message(inbound.item().message().message())
                        .messageFormat("html")
                        .color("gray")
                        .card(ImmutableWebhookOutboundCard.builder()
                                .style("application")
                                .description(ImmutableWebhookOutboundCardDescription.builder()
                                        .format("html")
                                        .value(inbound.item().message().message())
                                        .build())
                                .title("Kudos to %s")
                                .thumbnail(ImmutableWebhookOutboundCardThumbnail.builder()
                                        .url("http://www.gravatar.com/avatar/7bf236dc0db1aedd29711a27a34f4501?s=512")
                                        .build())
                                .icon(ImmutableWebhookOutboundCardIcon.builder()
                                        .url("http://3.bp.blogspot.com/-zT-YDxq9UGM/U49t_QjBZ9I/AAAAAAAAAUQ/C0MDJyPE19M/s1600/Kudos+Thumbs+Up.png")
                                        .build())
                                .build())
                        .build();

        System.err.println(dataStr);
        System.err.println(inbound.item().message().message());
        System.err.println(objectMapper.writeValueAsString(outboundWrapper));

        return objectMapper.writeValueAsString(outboundWrapper);
    }
}

