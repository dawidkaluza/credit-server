package pl.dkaluza.credit.dtos;

/**
 * Mapper interface used to mark class as a mapper from some object to appropriate dto object.
 * @param <T> type of provided object
 * @param <U> type of returned object
 */
public interface DtoMapper<T, U> {
    U toDto(T object);
}
