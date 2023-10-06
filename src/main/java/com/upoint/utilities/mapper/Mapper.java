package com.upoint.utilities.mapper;

public interface Mapper<T,E> {
	public E mapFrom(T dto);
	
	public T mapTo(E entity);	

}
