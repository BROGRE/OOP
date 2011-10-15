package Controller;

import java.util.ArrayList;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public class BOFactory extends DBConnector {
	public BOFactory(Datenbank connector) {
		super(connector);
	}

	public boolean addLVA(LVA lva){
		for(LVA v : connector.getLVAListe()){
			if(lva.getNr() == v.getNr())
				return false;
		}
		connector.getLVAListe().add(lva);
		connector.getInskriptionen().put(lva, new ArrayList<Student>());
		return true;
	}
	
	public boolean addStudent(Student student){
		for(Student s : connector.getStudentListe()){
			if(s.getMatrikelNr() == student.getMatrikelNr() )
				return false;
		}
		connector.getStudentListe().add(student);
		return true;		
	}
}
