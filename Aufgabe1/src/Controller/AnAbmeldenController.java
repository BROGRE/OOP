package Controller;

import java.util.ArrayList;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class AnAbmeldenController extends Datenbank{
	public boolean anmelden(LVA lva, Student student){
		if(Inskriptionen.containsKey(lva)){
			ArrayList<Student> student_list = Inskriptionen.get(lva);
			if(!student_list.contains(student)){
				if(lva.isAnmeldezeit()){
					student_list.add(student);
					lva.incrementStudAnz();
					return true;
				}
			}
		}
		return false;
	}
	
	public boolean abmelden(LVA lva, Student student){
		if(Inskriptionen.containsKey(lva)){
			ArrayList<Student> student_list = Inskriptionen.get(lva);
			if(!student_list.contains(student)){
				if(lva.isAbmeldezeit()){
					student_list.remove(student);
					lva.decrementStudentAnz();
					return true;
				}
			}
		}
		return false;
	}
}