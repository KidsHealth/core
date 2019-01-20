package es.uma.health.kids.application;

public interface Mapper<T, TDTO> {
    
	TDTO toDTO(T entity);
	T toEntity(TDTO dto);
	
}
