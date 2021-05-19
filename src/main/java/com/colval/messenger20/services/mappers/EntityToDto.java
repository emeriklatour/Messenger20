package com.colval.messenger20.services.mappers;

public interface EntityToDto<T, D> {
    D entityToDto(T t);
}
