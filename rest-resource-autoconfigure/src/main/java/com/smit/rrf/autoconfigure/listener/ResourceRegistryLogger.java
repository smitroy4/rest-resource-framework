package com.smit.rrf.autoconfigure.listener;

import com.smit.rrf.registry.ResourceRegistry;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

public class ResourceRegistryLogger {

    private final ResourceRegistry registry;

    public ResourceRegistryLogger(
            ResourceRegistry registry) {

        this.registry = registry;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void logResources() {

        registry.getAll()
                .forEach(resource ->
                        System.out.println(
                                "[RRF] Registered Resource: "
                                        + resource.getEntityClass()
                                        .getSimpleName()
                        ));
    }
}