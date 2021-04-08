package pl.dkaluza.credit.mappers;

public interface Mapper<T, U> {
    U toObject(T object);
}
