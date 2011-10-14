package BO;

public class Student {
	public Student(int matrikelNr,String Name){
		setName(Name);
		setMatrikelNr(matrikelNr);
	}
	
	private int matrikelNr;
	private String Name;
	
	public int getMatrikelNr() {
		return matrikelNr;
	}
	public void setMatrikelNr(int matrikelNr) {
		this.matrikelNr = matrikelNr;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}
}
