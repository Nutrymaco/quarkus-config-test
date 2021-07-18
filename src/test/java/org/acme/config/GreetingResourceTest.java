package org.acme.config;

import io.quarkus.test.junit.QuarkusTest;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.acme.config.GreetingResource.Event.IN_PROGRESS;
import static org.acme.config.GreetingResource.Event.READY;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
public class GreetingResourceTest {

    @Inject
    GreetingResource.MyMap myMap;

    @ConfigProperty(name = "mymap.")

    @Test
    public void testConfigMapping() {
        assertEquals(Map.of("key1", "value1"), myMap.myMap());
        assertEquals(Map.of(READY, "go", IN_PROGRESS, "do some"), myMap.nestedMap());
    }

}