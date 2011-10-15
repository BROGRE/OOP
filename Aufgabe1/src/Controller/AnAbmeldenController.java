package Controller;

import java.util.List;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class AnAbmeldenController extends DBConnector{
	public AnAbmeldenController(Datenbank connector) {
		super(connector);
	}

	public boolean anmelden(LVA lva, Student student){
		List<Student> student_list = getStudentList4LVA(lva);
		if(student_list != null && !student_list.contains(student)){
			if(lva.isAnmeldezeit()){
				student_list.add(student);
				lva.incrementStudAnz();
				return true;
			}
		}
		return false;
	}
	
	public boolean abmelden(LVA lva, Student student){
		List<Student> student_list = getStudentList4LVA(lva);
		if(student_list != null && student_list.contains(student)){
			if(lva.isAbmeldezeit()){
				student_list.remove(student);
				lva.decrementStudentAnz();
				return true;
			}
		}
		return false;
	}
}