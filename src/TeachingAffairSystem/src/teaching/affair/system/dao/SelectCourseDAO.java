package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.SelectCourse;

/**
 * A data access object (DAO) providing persistence and search support for
 * SelectCourse entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see teaching.affair.system.pojo.SelectCourse
 * @author MyEclipse Persistence Tools
 */
public class SelectCourseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SelectCourseDAO.class);
	// property constants
	public static final String STUDENT_NO = "studentNo";
	public static final String SEMESTER_COURSE_NO = "semesterCourseNo";
	public static final String SCORE = "score";

	public void save(SelectCourse transientInstance) {
		log.debug("saving SelectCourse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SelectCourse persistentInstance) {
		log.debug("deleting SelectCourse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SelectCourse findById(java.lang.Integer id) {
		log.debug("getting SelectCourse instance with id: " + id);
		try {
			SelectCourse instance = (SelectCourse) getSession().get("teaching.affair.system.pojo.SelectCourse", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SelectCourse instance) {
		log.debug("finding SelectCourse instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.SelectCourse")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SelectCourse instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SelectCourse as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByStudentNo(Object studentNo) {
		return findByProperty(STUDENT_NO, studentNo);
	}

	public List findBySemesterCourseNo(Object semesterCourseNo) {
		return findByProperty(SEMESTER_COURSE_NO, semesterCourseNo);
	}

	public List findByScore(Object score) {
		return findByProperty(SCORE, score);
	}

	public List findAll() {
		log.debug("finding all SelectCourse instances");
		try {
			String queryString = "from SelectCourse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SelectCourse merge(SelectCourse detachedInstance) {
		log.debug("merging SelectCourse instance");
		try {
			SelectCourse result = (SelectCourse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SelectCourse instance) {
		log.debug("attaching dirty SelectCourse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SelectCourse instance) {
		log.debug("attaching clean SelectCourse instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}