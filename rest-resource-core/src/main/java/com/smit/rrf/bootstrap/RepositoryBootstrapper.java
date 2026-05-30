package com.smit.rrf.bootstrap;

import com.smit.rrf.bootstrap.factory.RepositoryDefinitionFactory;
import com.smit.rrf.bootstrap.scanner.RepositoryScanner;
import com.smit.rrf.metadata.RepositoryDefinition;
import com.smit.rrf.registry.RepositoryRegistry;

public class RepositoryBootstrapper {

    private final RepositoryScanner scanner;
    private final RepositoryDefinitionFactory factory;
    private final RepositoryRegistry registry;

    public RepositoryBootstrapper(
            RepositoryScanner scanner,
            RepositoryDefinitionFactory factory,
            RepositoryRegistry registry) {

        this.scanner = scanner;
        this.factory = factory;
        this.registry = registry;
    }

    public void bootstrap(String basePackage) {

        scanner.scan(basePackage)
                .forEach(repository -> {

                    RepositoryDefinition definition =
                            factory.create(repository);

                    registry.register(definition);
                });
    }
}