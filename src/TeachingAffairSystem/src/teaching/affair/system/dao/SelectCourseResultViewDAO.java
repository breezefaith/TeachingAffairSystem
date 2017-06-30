package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.view.SelectCourseResultView;
import teaching.affair.system.pojo.view.SelectCourseResultViewId;

/**
 * A data access object (DAO) providing persistence and search support for
 * SelectCourseResultView entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see teaching.affair.system.dao.SelectCourseResultView
 * @author MyEclipse Persistence Tools
 */
public class SelectCourseResultViewDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SelectCourseResultViewDAO.class);
	// property constants

	public void save(SelectCourseResultView transientInstance) {
		log.debug("saving SelectCourseResultView instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SelectCourseResultView persistentInstance) {
		log.debug("deleting SelectCourseResultView instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SelectCourseResultView findById(SelectCourseResultViewId id) {
		log.debug("getting SelectCourseResultView instance with id: " + id);
		try {
			SelectCourseResultView instance = (SelectCourseResultView) getSession()
					.get("teaching.affair.system.pojo.view.SelectCourseResultView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SelectCourseResultView instance) {
		log.debug("finding SelectCourseResultView instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.SelectCourseResultView")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SelectCourseResultView instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SelectCourseResultView as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all SelectCourseResultView instances");
		try {
			String queryString = "from SelectCourseResultView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SelectCourseResultView merge(SelectCourseResultView detachedInstance) {
		log.debug("merging SelectCourseResultView instance");
		try {
			SelectCourseResultView result = (SelectCourseResultView) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SelectCourseResultView instance) {
		log.debug("attaching dirty SelectCourseResultView instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SelectCourseResultView instance) {
		log.debug("attaching clean SelectCourseResultView instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}