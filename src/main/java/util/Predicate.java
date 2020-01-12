package util;

public interface Predicate<T, V> {
	public T test(V... param);
}
