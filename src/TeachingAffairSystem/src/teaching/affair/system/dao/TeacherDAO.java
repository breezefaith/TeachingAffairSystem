package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.Teacher;

/**
 * A data access object (DAO) providing persistence and search support for
 * Teacher entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see teaching.affair.system.pojo.Teacher
 * @author MyEclipse Persistence Tools
 */
public class TeacherDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TeacherDAO.class);
	// property constants
	public static final String TEACHER_NAME = "teacherName";
	public static final String SEX = "sex";
	public static final String TEACHER_ACADEMY = "teacherAcademy";
	public static final String TEACHER_TITLE = "teacherTitle";
	public static final String TEACHER_EMAIL = "teacherEmail";
	public static final String PASSWORD = "password";

	public void save(Teacher transientInstance){
		log.debug("saving Teacher instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Teacher persistentInstance) {
		log.debug("deleting Teacher instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Teacher findById(java.lang.String id) {
		log.debug("getting Teacher instance with id: " + id);
		try {
			Teacher instance = (Teacher) getSession().get("teaching.affair.system.pojo.Teacher", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Teacher instance) {
		log.debug("finding Teacher instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.Teacher")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Teacher instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from Teacher as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByTeacherName(Object teacherName) {
		return findByProperty(TEACHER_NAME, teacherName);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByTeacherAcademy(Object teacherAcademy) {
		return findByProperty(TEACHER_ACADEMY, teacherAcademy);
	}

	public List findByTeacherTitle(Object teacherTitle) {
		return findByProperty(TEACHER_TITLE, teacherTitle);
	}

	public List findByTeacherEmail(Object teacherEmail) {
		return findByProperty(TEACHER_EMAIL, teacherEmail);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findAll() {
		log.debug("finding all Teacher instances");
		try {
			String queryString = "from Teacher";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Teacher merge(Teacher detachedInstance) {
		log.debug("merging Teacher instance");
		try {
			Teacher result = (Teacher) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Teacher instance) {
		log.debug("attaching dirty Teacher instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Teacher instance) {
		log.debug("attaching clean Teacher instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}