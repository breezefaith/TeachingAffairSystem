package teaching.affair.system.test;

import java.util.List;

import teaching.affair.system.dao.SelectCourseResultViewDAO;
import teaching.affair.system.pojo.view.SelectCourseResultView;

public class TestHibernate {
	
	public static void main(String[] args) {
		SelectCourseResultViewDAO selectCourseResultViewDAO=new SelectCourseResultViewDAO();
		List<SelectCourseResultView> list=selectCourseResultViewDAO.findAll();
		for(SelectCourseResultView item:list){
			System.out.println(item);
		}
	}
}
