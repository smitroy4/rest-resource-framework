package com.smit.rrf.registry;

public class RepositoryRegistryPrinter {

    public void print(RepositoryRegistry registry) {

        System.out.println();
        System.out.println("====== RRF Repositories ======");

        registry.getAll()
                .values()
                .forEach(repo -> {

                    System.out.println(
                            repo.getEntityClass()
                                    .getSimpleName()
                                    + " -> "
                                    + repo.getRepositoryClass()
                                    .getSimpleName()
                    );

                });

        System.out.println("==============================");
    }
}