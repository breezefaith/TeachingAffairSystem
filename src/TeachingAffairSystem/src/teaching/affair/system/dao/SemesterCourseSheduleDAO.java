package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.SemesterCourseShedule;

/**
 * A data access object (DAO) providing persistence and search support for
 * SemesterCourseShedule entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see teaching.affair.system.pojo.SemesterCourseShedule
 * @author MyEclipse Persistence Tools
 */
public class SemesterCourseSheduleDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SemesterCourseSheduleDAO.class);
	// property constants
	public static final String START_CLASS_NO = "startClassNo";
	public static final String END_CLASS_NO = "endClassNo";

	public void save(SemesterCourseShedule transientInstance) {
		log.debug("saving SemesterCourseShedule instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SemesterCourseShedule persistentInstance) {
		log.debug("deleting SemesterCourseShedule instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SemesterCourseShedule findById(teaching.affair.system.pojo.SemesterCourseSheduleId id) {
		log.debug("getting SemesterCourseShedule instance with id: " + id);
		try {
			SemesterCourseShedule instance = (SemesterCourseShedule) getSession()
					.get("teaching.affair.system.pojo.SemesterCourseShedule", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SemesterCourseShedule instance) {
		log.debug("finding SemesterCourseShedule instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.SemesterCourseShedule")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SemesterCourseShedule instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SemesterCourseShedule as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStartClassNo(Object startClassNo) {
		return findByProperty(START_CLASS_NO, startClassNo);
	}

	public List findByEndClassNo(Object endClassNo) {
		return findByProperty(END_CLASS_NO, endClassNo);
	}

	public List findAll() {
		log.debug("finding all SemesterCourseShedule instances");
		try {
			String queryString = "from SemesterCourseShedule";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SemesterCourseShedule merge(SemesterCourseShedule detachedInstance) {
		log.debug("merging SemesterCourseShedule instance");
		try {
			SemesterCourseShedule result = (SemesterCourseShedule) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SemesterCourseShedule instance) {
		log.debug("attaching dirty SemesterCourseShedule instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SemesterCourseShedule instance) {
		log.debug("attaching clean SemesterCourseShedule instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}