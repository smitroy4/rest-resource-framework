package com.smit.rrf.metadata;

public class ResourceMetadata {

    private final Class<?> entityClass;
    private final Class<?> dtoClass;
    private final String path;
    private final boolean pageable;
    private final boolean sortable;
    private final boolean searchable;

    public ResourceMetadata(
            Class<?> entityClass,
            Class<?> dtoClass,
            String path,
            boolean pageable,
            boolean sortable,
            boolean searchable) {

        this.entityClass = entityClass;
        this.dtoClass = dtoClass;
        this.path = path;
        this.pageable = pageable;
        this.sortable = sortable;
        this.searchable = searchable;
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public Class<?> getDtoClass() {
        return dtoClass;
    }

    public String getPath() {
        return path;
    }

    public boolean isPageable() {
        return pageable;
    }

    public boolean isSortable() {
        return sortable;
    }

    public boolean isSearchable() {
        return searchable;
    }
}