package com.feedzai.kudos;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.feedzai.kudos.serialization.inbound.WebhookInboundMention;
import com.feedzai.kudos.serialization.inbound.WebhookInboundWrapper;
import com.feedzai.kudos.serialization.outbound.*;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String kudos(String dataStr) throws IOException, NoSuchAlgorithmException {

        WebhookInboundWrapper inbound = objectMapper.readValue(dataStr, WebhookInboundWrapper.class);
        System.err.println(dataStr);

        Pattern pattern = Pattern.compile("^/kudos @([^ ]*) (for .*)$");
        Matcher matcher = pattern.matcher(inbound.item().message().message());

        if (!matcher.find()) {
            return shrug("pattern mismatch!");
        }

        String kudosToMentionName = matcher.group(1);
        String kudosFeat = StringUtils.capitalize(matcher.group(2));

        Optional<WebhookInboundMention> kudosToMention = inbound.item().message().mentions().stream()
                .filter(m -> StringUtils.equals(m.mentionName(), kudosToMentionName))
                .findAny();

        if (!kudosToMention.isPresent()) {
            return shrug(String.format("who is %s?", kudosToMentionName));
        }

        String kudosToEmail = String.format("%s@feedzai.com", StringUtils.lowerCase(kudosToMention.get().name()).replaceAll(" ", "."));
        MessageDigest md = MessageDigest.getInstance("MD5");
        String KudosToDigest = Hex.encodeHexString(md.digest(kudosToEmail.getBytes()));

        System.err.println(kudosToEmail);

        WebhookOutboundWrapper outboundWrapper =
                ImmutableWebhookOutboundWrapper.builder()
                        .message(kudosFeat)
                        .messageFormat("html")
                        .color("gray")
                        .card(ImmutableWebhookOutboundCard.builder()
                                .id("fee4d9a3-685d-4cbd-abaa-c8850d9b1960")
                                .style("application")
                                .description(ImmutableWebhookOutboundCardDescription.builder()
                                        .format("html")
                                        .value(kudosFeat)
                                        .build())
                                .title(String.format("Kudos to %s", kudosToMention.get().name()))
                                .thumbnail(ImmutableWebhookOutboundCardThumbnail.builder()
                                        .url(String.format("http://www.gravatar.com/avatar/%s?s=512", KudosToDigest))
                                        .build())
                                .icon(ImmutableWebhookOutboundCardIcon.builder()
                                        .url("http://hipchat-kudos-hipchat-kudos.7e14.starter-us-west-2.openshiftapps.com/hipchat-kudos/images/icon.png")
                                        .build())
                                .build())
                        .build();


        System.err.println(objectMapper.writeValueAsString(outboundWrapper));

        return objectMapper.writeValueAsString(outboundWrapper);

    }

    private String shrug(final String context) throws JsonProcessingException {
        WebhookOutboundWrapper outboundWrapper =
                ImmutableWebhookOutboundWrapper.builder()
                        .message(String.format("(shrug) %s", context))
                        .color("gray")
                        .build();

        return objectMapper.writeValueAsString(outboundWrapper);
    }
}

