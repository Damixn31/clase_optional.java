package org.olmedo.optional.ejemplo.repositorio;

import org.olmedo.optional.ejemplo.models.Computadora;

import java.util.Optional;

public interface Repositorio<T> {
    Optional<Computadora> filtrar(String nombre);

}
