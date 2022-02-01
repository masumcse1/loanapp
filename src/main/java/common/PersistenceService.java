package common;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

@Transactional(TxType.MANDATORY)
public class PersistenceService {

	@PersistenceContext
	private EntityManager entityManager;

	public <T> T save(T t) throws Exception {
		try {
			entityManager.persist(t);
			entityManager.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> save(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(save(t));
		}
		return list;
	}

	public <T> T update(T t) throws Exception {
		try {
			entityManager.merge(t);
			entityManager.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> update(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(update(t));
		}
		return list;
	}

	public <T> T delete(T t) throws Exception {
		try {
			entityManager.remove(entityManager.getReference(t.getClass(), t));
			entityManager.flush();
		} catch (Exception e) {
			throw e;
		} finally {
			entityManager.clear();
		}
		return t;
	}

	public <T> List<T> delete(List<T> ts) throws Exception {
		List<T> list = new ArrayList<>();
		for (T t : ts) {
			list.add(delete(t));
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	public <T> T loadById(Object id, Class entityClass) {
		T t = (T) entityManager.find(entityClass, id);
		return t;
	}

	/*
	 * @SuppressWarnings("unchecked") public Object getIdProperty(Class
	 * entityClass) { Object idProperty = null; Metamodel metamodel =
	 * entityManager.getMetamodel(); EntityType entity =
	 * metamodel.entity(entityClass); Set<SingularAttribute> singularAttributes
	 * = entity.getSingularAttributes(); for (SingularAttribute
	 * singularAttribute : singularAttributes) { if (singularAttribute.isId()) {
	 * idProperty = singularAttribute.getName(); break; } } if (idProperty ==
	 * null) throw new RuntimeException("id field not found"); return
	 * idProperty; }
	 */

}
