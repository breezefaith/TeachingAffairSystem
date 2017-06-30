package teaching.affair.system.model;

import java.util.List;

import org.hibernate.Transaction;

import teaching.affair.system.dao.ManagerDAO;
import teaching.affair.system.dao.StudentDAO;
import teaching.affair.system.pojo.Manager;
import teaching.affair.system.pojo.Student;

public class ManagerManager {
	public static String getJsonString(){
		ManagerDAO managerDAO=new ManagerDAO();
		List<Manager> managers=managerDAO.findAll();
		StringBuffer info=new StringBuffer("[");
		for(Manager item:managers){
			info.append("{");
			info.append(formatString("managerNo", String.valueOf(item.getManagerNo())));
			info.append(formatString("username", item.getUsername()));
			info.append(formatString("password", item.getPassword()));
			info.deleteCharAt(info.length()-1);
			info.append("},");
		}
		info.deleteCharAt(info.length()-1);
		info.append("]");
		return new String(info);
	}
	
	public static boolean updateManager(String managerNo, String username, String password) {
		try {
			ManagerDAO managerDAO=new ManagerDAO();
			Transaction transaction=managerDAO.getSession().beginTransaction();
			Manager manager=new Manager(username, password);
			manager.setManagerNo(Integer.valueOf(managerNo));
			System.out.println("��ʼ����");
			System.out.println(manager);
			managerDAO.getSession().update(manager);
			transaction.commit();
			System.out.println("���³ɹ�");
			return true;
		} catch (RuntimeException e) {
			return false;
		}

	}
	public static boolean insertManager(String managerNo,String username, String password) {
		try {
			ManagerDAO managerDAO=new ManagerDAO();
			Transaction transaction=managerDAO.getSession().beginTransaction();
			Manager manager=new Manager(username, password);
			manager.setManagerNo(Integer.valueOf(managerNo));
			System.out.println("��ʼ����");
			System.out.println(manager);
			managerDAO.getSession().save(manager);
			transaction.commit();
			System.out.println("����ɹ�");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	public static boolean deleteManager(String managerNo) {
		try {
			ManagerDAO managerDAO=new ManagerDAO();
			Transaction transaction=managerDAO.getSession().beginTransaction();
			System.out.println("��ʼɾ��");
			Manager manager=managerDAO.findById(Integer.valueOf(managerNo));
			if(manager!=null){
				managerDAO.delete(manager);
			}
			transaction.commit();
			System.out.println("ɾ���ɹ�");
			return true;
		} catch (RuntimeException e) {
			return false;
		}
	}
	private static String formatString(String key,String value){
		return "\""+key+"\":"+"\""+value+"\",";
	}
	public static void main(String[] args) {
		System.out.println(getJsonString());
	}
}
