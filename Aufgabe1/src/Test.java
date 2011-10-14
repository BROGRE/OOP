import java.text.ParseException;
import java.text.SimpleDateFormat;

import BO.LVA;
import BO.Student;
import Controller.AnAbmeldenController;
import Controller.AuflistungsController;
import Controller.BOFactory;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			doTests();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void doTests() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yy");		
		BOFactory factory = new BOFactory();
		AnAbmeldenController anabmelden = new AnAbmeldenController();
		AuflistungsController auflisten = new AuflistungsController();
				
		LVA lva1 = new LVA(1,"LVA1",dateFormat.parse("10.10.2011"),dateFormat.parse("20.10.2011"),dateFormat.parse("31.10.2011"));
		LVA lva2 = new LVA(2,"LVA2", dateFormat.parse("10.10.2011"),dateFormat.parse("20.10.2011"),dateFormat.parse("01.10.2011"));
		LVA lva3 = new LVA(3,"LVA3",dateFormat.parse("10.09.2011"),dateFormat.parse("10.10.2011"),dateFormat.parse("31.10.2011"));
		
		factory.addLVA(lva1);
		factory.addLVA(lva2);
		factory.addLVA(lva3);
		//error
		factory.addLVA(lva1);
		
		Student stud1 = new Student(0, "student1");
		Student stud2 = new Student(1, "student2");
		Student stud3 = new Student(2, "student3");
		
		factory.addStudent(stud1);
		factory.addStudent(stud2);
		factory.addStudent(stud3);
		//error
		factory.addStudent(stud1);		
		
		
		anabmelden.anmelden(lva1, stud1);
		anabmelden.anmelden(lva1, stud2);
		//error
		anabmelden.anmelden(lva1, stud2);
		
		anabmelden.anmelden(lva1, stud2);
		anabmelden.anmelden(lva2, stud3);
		
		//error
		anabmelden.abmelden(lva1, stud3);
		
		anabmelden.abmelden(lva1, stud2);
		anabmelden.anmelden(lva1, stud2);
		
		anabmelden.anmelden(lva3, stud2);
		
		anabmelden.anmelden(lva2, stud2);
		anabmelden.abmelden(lva2, stud2);
		
		for(LVA lva : auflisten.getLVAs()){
			System.out.println(String.format("%d %s %d",lva.getNr(), lva.getName(), lva.getStudAnz()));
		}
		System.out.println("------------------");
		for(LVA lva : auflisten.getLVAs()){
			System.out.println(String.format("%d %s %d",lva.getNr(), lva.getName(), lva.getStudAnz()));
			for(Student stud : auflisten.getStudents4LVA(lva)){
				System.out.println(String.format("%d %s",stud.getMatrikelNr(),stud.getName()));
			}
		}
	}

}
