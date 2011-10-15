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
		LVA lva2 = new LVA(2,"LVA2", dateFormat.parse("10.10.2011"),dateFormat.parse("14.10.2011"),dateFormat.parse("01.10.2011"));
		LVA lva3 = new LVA(3,"LVA3",dateFormat.parse("10.09.2011"),dateFormat.parse("30.10.2011"),dateFormat.parse("31.10.2011"));
		LVA lva4 = new LVA(4,"LVA4",dateFormat.parse("10.09.2010"),dateFormat.parse("10.10.2010"),dateFormat.parse("31.10.2011"));
		LVA lva5 = new LVA(5,"LVA5",dateFormat.parse("10.09.2011"),dateFormat.parse("31.10.2011"),dateFormat.parse("31.10.2010"));		
		
		Student stud1 = new Student(0, "student1");
		Student stud2 = new Student(1, "student2");
		Student stud3 = new Student(2, "student3");		
		
		doTest("Adding LVA 1!",true,
				factory.addLVA(lva1));
		doTest("Adding LVA 2!",true,
				factory.addLVA(lva2));
		doTest("Adding LVA 3!",true,
				factory.addLVA(lva3));
		doTest("Adding LVA 4!",true,
				factory.addLVA(lva4));
		doTest("Adding LVA 5!",true,
				factory.addLVA(lva5));
		doTest("Adding LVA 3 again!",false,
				factory.addLVA(lva3));
		
		doTest("Adding Student 1!",true,
				factory.addStudent(stud1));
		doTest("Adding Student 2!",true,
				factory.addStudent(stud2));
		doTest("Adding Student 3!",true,
				factory.addStudent(stud3));
		doTest("Adding Student 3 again!",false,
				factory.addStudent(stud3));
		
		doTest("Adding Student 1 to LVA 1!",true,
				anabmelden.anmelden(lva1, stud1));
		doTest("Adding Student 2 to LVA 1!",true,
				anabmelden.anmelden(lva1, stud2));
		doTest("Adding Student 2 to LVA 1 again!",false,
				anabmelden.anmelden(lva1, stud2));
		
		doTest("Adding Student 3 to LVA 5!",true,
				anabmelden.anmelden(lva5, stud3));
		doTest("Adding Student 2 to LVA 3!",true,
				anabmelden.anmelden(lva3, stud2));
		
		doTest("Adding Student 3 to LVA 2! (Anmeldezeitrauf abgelaufen - maxDate)",false,
				anabmelden.anmelden(lva2, stud3));
		doTest("Adding Student 3 to LVA 4! (Anmeldezeitrauf agbelaufen - minDate)",false,
				anabmelden.anmelden(lva4, stud3));		
		doTest("Removing Student 3 from LVA 5! (Abmeldezeitrauf agbelaufen)",false,
				anabmelden.anmelden(lva5, stud3));
		
		doTest("LVA1 hat 2 angemeldete Studenten!",true,
				lva1.getStudAnz() == 2);
		doTest("LVA2 hat 0 angemeldete Studenten!",true,
				lva2.getStudAnz() == 0);
		doTest("LVA3 hat 1 angemeldete Studenten!",true,
				lva3.getStudAnz() == 1);
		doTest("LVA4 hat 0 angemeldete Studenten!",true,
				lva4.getStudAnz() == 0);
		doTest("LVA5 hat 1 angemeldete Studenten!",true,
				lva5.getStudAnz() == 1);
		
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
	
	private static void doTest(String Msg, boolean expected, boolean value){
		System.out.print(Msg + " -> " + expected);
		if(value == expected){
			System.out.println(" OK!");
		}else{
			System.out.println(" ERROR!");
		}
	}
	

}
