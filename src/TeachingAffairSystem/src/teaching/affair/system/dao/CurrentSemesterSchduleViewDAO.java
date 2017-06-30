package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.view.CurrentSemesterSchduleView;

/**
 * A data access object (DAO) providing persistence and search support for
 * CurrentSemesterSchduleView entities. Transaction control of the save(),
 * update() and delete() operations can directly support Spring
 * container-managed transactions or they can be augmented to handle
 * user-managed Spring transactions. Each of these methods provides additional
 * information for how to configure it for the desired type of transaction
 * control.
 * 
 * @see teaching.affair.system.pojo.view.CurrentSemesterSchduleView
 * @author MyEclipse Persistence Tools
 */
public class CurrentSemesterSchduleViewDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(CurrentSemesterSchduleViewDAO.class);
	// property constants

	public void save(CurrentSemesterSchduleView transientInstance) {
		/*log.debug("saving CurrentSemesterSchduleView instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}*/
	}

	public void delete(CurrentSemesterSchduleView persistentInstance) {
		/*log.debug("deleting CurrentSemesterSchduleView instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}*/
	}

	public CurrentSemesterSchduleView findById(teaching.affair.system.pojo.view.CurrentSemesterSchduleViewId id) {
		log.debug("getting CurrentSemesterSchduleView instance with id: " + id);
		try {
			CurrentSemesterSchduleView instance = (CurrentSemesterSchduleView) getSession()
					.get("teaching.affair.system.pojo.view.CurrentSemesterSchduleView", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(CurrentSemesterSchduleView instance) {
		log.debug("finding CurrentSemesterSchduleView instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.view.CurrentSemesterSchduleView")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding CurrentSemesterSchduleView instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from CurrentSemesterSchduleView as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all CurrentSemesterSchduleView instances");
		try {
			String queryString = "from CurrentSemesterSchduleView";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public CurrentSemesterSchduleView merge(CurrentSemesterSchduleView detachedInstance) {
		log.debug("merging CurrentSemesterSchduleView instance");
		try {
			CurrentSemesterSchduleView result = (CurrentSemesterSchduleView) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(CurrentSemesterSchduleView instance) {
		log.debug("attaching dirty CurrentSemesterSchduleView instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(CurrentSemesterSchduleView instance) {
		log.debug("attaching clean CurrentSemesterSchduleView instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}