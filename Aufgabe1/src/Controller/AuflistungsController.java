package Controller;

import java.util.ArrayList;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class AuflistungsController extends Datenbank {
	public ArrayList<LVA> getLVAs(){
		return LVAListe;
	}
	
	public ArrayList<Student> getStudents4LVA(LVA lva){
		if(Inskriptionen.containsKey(lva)){
			ArrayList<Student> student_list = Inskriptionen.get(lva);
			return student_list;
		}else{
			return new ArrayList<Student>();
		}
	}
}
