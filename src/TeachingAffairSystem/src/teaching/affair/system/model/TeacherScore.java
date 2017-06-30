package teaching.affair.system.model;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.Transaction;

import teaching.affair.system.dao.SelectCourseDAO;
import teaching.affair.system.util.ConnectionUtil;

public class TeacherScore {
	public static boolean updateScore(String semesterNo,String courseNo,String studentNo,String score){
		try {
			System.out.println("开始更新");
			ConnectionUtil connectionUtil=new ConnectionUtil();
			String sql="update select_course set score='"+score+"' "
					+ "where student_no='"+studentNo+"' and semester_course_no in (select semester_course_no "
					+ "from semester_course where semester_no='"+semesterNo+"' "
							+ "and course_no='"+courseNo+"')";
			System.out.println(sql);
			if(connectionUtil.excuteUpdate(sql)){
				System.out.println("更新成功");
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
//			e.printStackTrace();
			return false;
		}
	}
	public static void main(String[] args) {
		updateScore("1", "c1", "s1", "99");
	}
}
