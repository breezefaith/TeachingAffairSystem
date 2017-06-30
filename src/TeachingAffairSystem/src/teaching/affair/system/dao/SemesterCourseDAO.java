package teaching.affair.system.dao;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teaching.affair.system.pojo.SemesterCourse;

/**
 * A data access object (DAO) providing persistence and search support for
 * SemesterCourse entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see teaching.affair.system.pojo.SemesterCourse
 * @author MyEclipse Persistence Tools
 */
public class SemesterCourseDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(SemesterCourseDAO.class);
	// property constants
	public static final String SEMESTER_NO = "semesterNo";
	public static final String COURSE_NO = "courseNo";
	public static final String TEACHER_NO = "teacherNo";
	public static final String START_WEEK = "startWeek";
	public static final String END_WEEK = "endWeek";
	public static final String EXPECT_NUM = "expectNum";

	public void save(SemesterCourse transientInstance) {
		log.debug("saving SemesterCourse instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(SemesterCourse persistentInstance) {
		log.debug("deleting SemesterCourse instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public SemesterCourse findById(java.lang.Integer id) {
		log.debug("getting SemesterCourse instance with id: " + id);
		try {
			SemesterCourse instance = (SemesterCourse) getSession().get("teaching.affair.system.pojo.SemesterCourse",
					id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(SemesterCourse instance) {
		log.debug("finding SemesterCourse instance by example");
		try {
			List results = getSession().createCriteria("teaching.affair.system.pojo.SemesterCourse")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding SemesterCourse instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from SemesterCourse as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findBySemesterNo(Object semesterNo) {
		return findByProperty(SEMESTER_NO, semesterNo);
	}

	public List findByCourseNo(Object courseNo) {
		return findByProperty(COURSE_NO, courseNo);
	}

	public List findByTeacherNo(Object teacherNo) {
		return findByProperty(TEACHER_NO, teacherNo);
	}

	public List findByStartWeek(Object startWeek) {
		return findByProperty(START_WEEK, startWeek);
	}

	public List findByEndWeek(Object endWeek) {
		return findByProperty(END_WEEK, endWeek);
	}

	public List findByExpectNum(Object expectNum) {
		return findByProperty(EXPECT_NUM, expectNum);
	}

	public List findAll() {
		log.debug("finding all SemesterCourse instances");
		try {
			String queryString = "from SemesterCourse";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public SemesterCourse merge(SemesterCourse detachedInstance) {
		log.debug("merging SemesterCourse instance");
		try {
			SemesterCourse result = (SemesterCourse) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(SemesterCourse instance) {
		log.debug("attaching dirty SemesterCourse instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(SemesterCourse instance) {
		log.debug("attaching clean SemesterCourse instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}