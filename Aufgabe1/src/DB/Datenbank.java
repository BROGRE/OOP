package DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import BO.LVA;
import BO.Student;

public class Datenbank {
	private ArrayList<Student> StudentListe = new ArrayList<Student>();
	private ArrayList<LVA> LVAListe= new ArrayList<LVA>();
	private Map<LVA, ArrayList<Student>> Inskriptionen = new HashMap<LVA, ArrayList<Student>>();
	
	public List<Student> getStudentListe() {
		return StudentListe;
	}
	public List<LVA> getLVAListe() {
		return LVAListe;
	}
	public Map<LVA, ArrayList<Student>> getInskriptionen() {
		return Inskriptionen;
	}	
}