package org.acme.config;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.config.WithConverter;

import javax.inject.Inject;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithParentName;
import io.smallrye.config.WithName;

import java.util.Map;


@Path("/greeting")
public class GreetingResource {

    @Inject
    MyMap mymap;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        System.out.println("myMap = " + mymap.myMap());
        System.out.println("nested = " + mymap.nestedMap());
        return "Hello RESTEasy";
    }

    public enum Event {
        READY,
        IN_PROGRESS;
    }

    @ConfigMapping(prefix = "myMap")
    public interface MyMap {
        @WithParentName
        Map<String, String> myMap();

        @WithName("event")
        Map<@WithConverter(EventConverter.class)Event, String> nestedMap();
    }

}