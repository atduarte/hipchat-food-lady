package com.feedzai.kudos.serialization;

import javax.inject.Singleton;
import java.util.HashMap;
import java.util.Map;

@Singleton
public class KudosIsStash {
    private Map<String, String> stash = new HashMap<>();

    public void put(final String mentionName, final String email) {
        stash.put(mentionName, email);
    }

    public String get(final String mentionName) {
        return stash.get(mentionName);
    }
}
