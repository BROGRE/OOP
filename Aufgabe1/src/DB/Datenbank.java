package DB;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import BO.LVA;
import BO.Student;

public abstract class Datenbank {
	protected static ArrayList<Student> StudentListe = new ArrayList<Student>();
	protected static ArrayList<LVA> LVAListe= new ArrayList<LVA>();
	protected static Map<LVA, ArrayList<Student>> Inskriptionen = new HashMap<LVA, ArrayList<Student>>();
}