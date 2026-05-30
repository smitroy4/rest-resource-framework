package com.smit.rrf.metadata;

public class ResourceDefinition {

    private Class<?> entityClass;

    private Class<?> dtoClass;

    private String path;

    private boolean pageable;

    private boolean sortable;

    private boolean searchable;

    public ResourceDefinition() {
    }

    public Class<?> getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(Class<?> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<?> getDtoClass() {
        return dtoClass;
    }

    public void setDtoClass(Class<?> dtoClass) {
        this.dtoClass = dtoClass;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public boolean isPageable() {
        return pageable;
    }

    public void setPageable(boolean pageable) {
        this.pageable = pageable;
    }

    public boolean isSortable() {
        return sortable;
    }

    public void setSortable(boolean sortable) {
        this.sortable = sortable;
    }

    public boolean isSearchable() {
        return searchable;
    }

    public void setSearchable(boolean searchable) {
        this.searchable = searchable;
    }
}