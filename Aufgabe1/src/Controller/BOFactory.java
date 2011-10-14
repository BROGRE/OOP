package Controller;

import java.util.ArrayList;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class BOFactory extends Datenbank {
	public boolean addLVA(LVA lva){
		for(LVA v : LVAListe){
			if(lva.getNr() == v.getNr())
				return false;
		}
		LVAListe.add(lva);
		Inskriptionen.put(lva, new ArrayList<Student>());
		return true;
	}
	
	public boolean addStudent(Student student){
		for(Student s : StudentListe){
			if(s.getMatrikelNr() == student.getMatrikelNr() )
				return false;
		}
		StudentListe.add(student);
		return true;		
	}
}
