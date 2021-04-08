package pl.dkaluza.credit.dtos;

/**
 * Mapper interface used to mark class as a mapper from some dto to appropriate entity object.
 * @param <T> type of provided object
 * @param <U> type of returned object
 */
public interface EntityMapper<T, U> {
    U toEntity(T object);
}
