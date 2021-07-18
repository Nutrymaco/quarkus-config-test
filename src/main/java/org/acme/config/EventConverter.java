package org.acme.config;

import org.eclipse.microprofile.config.spi.Converter;

public class EventConverter implements Converter<GreetingResource.Event> {
    @Override
    public GreetingResource.Event convert(String s) throws IllegalArgumentException, NullPointerException {
        if (isNullOrEmpty(s)) {
            return null;
        }

        return GreetingResource.Event.valueOf(s.toUpperCase());
    }

    private boolean isNullOrEmpty(String input) {
        return input == null || input.isEmpty();
    }
}
