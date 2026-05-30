package com.smit.rrf.registry;

public class ResourceRegistryPrinter {

    public void print(ResourceRegistry registry) {

        System.out.println();
        System.out.println("========== RRF Registry ==========");

        registry.getAll().forEach(resource -> {

            System.out.println(
                    resource.getEntityClass().getSimpleName()
                            + " -> "
                            + resource.getPath()
            );

        });

        System.out.println("==================================");
        System.out.println();
    }
}