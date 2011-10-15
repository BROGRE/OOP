package Controller;

import java.util.ArrayList;
import java.util.List;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class AuflistungsController extends DBConnector {
	public AuflistungsController(Datenbank connector) {
		super(connector);
	}

	public List<LVA> getLVAs(){
		return connector.getLVAListe();
	}
	
	public List<Student> getStudents4LVA(LVA lva){
		List<Student> student_list = getStudentList4LVA(lva);
		if(student_list != null){
			return student_list;
		}else{
			return new ArrayList<Student>();
		}
	}
}