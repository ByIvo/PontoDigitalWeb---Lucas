package br.com.pontowebdigital.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaQuery;

import org.springframework.transaction.annotation.Transactional;

import br.com.pontowebdigital.model.Entidade;

public abstract class GenericDAO<T extends Entidade, E>
{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	private Class<T> entityClass;
	
	public GenericDAO(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}
	
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}
	
	public Class<T> getEntityClass()
	{
		return entityClass;
	}
	
	public void setEntityClass(Class<T> entityClass)
	{
		this.entityClass = entityClass;
	}
	
	@Transactional
	public T saveOrUpdate(T entity)
	{
		if (entity.getId() == null)
		{
			return this.save(entity);
		}
		else
		{
			return this.update(entity);
		}
	}
	
	@Transactional
	public T save(T entity)
	{
		validateOnSave(entity);
		entityManager.persist(entity);
		entityManager.flush();
		
		return entity;
	}
	
	@Transactional
	protected void validateOnSave(T entity)
	{
	
	}
	
	@Transactional
	public void remove(T entity)
	{
		T entityToBeRemoved = entityManager.getReference(entityClass, entity.getId());
		
		entityManager.remove(entityToBeRemoved);
	}
	
	@Transactional
	public void remove(Integer id)
	{
		T entityToBeRemoved = entityManager.getReference(entityClass, id);
		
		entityManager.remove(entityToBeRemoved);
	}
	
	@Transactional
	public T update(T entity)
	{
		return entityManager.merge(entity);
	}
	
	public T find(E entityID)
	{
		return entityManager.find(entityClass, entityID);
	}
	public T findF(E entityID)
	{
		return entityManager.find(entityClass, entityID);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public List<T> findAll()
	{
		CriteriaQuery criteriaQuery = entityManager.getCriteriaBuilder().createQuery();
		criteriaQuery.select(criteriaQuery.from(entityClass));
		
		return entityManager.createQuery(criteriaQuery).getResultList();
	}
	
	public Query createQuery(String query)
	{
		return entityManager.createQuery(query, entityClass);
	}
}
