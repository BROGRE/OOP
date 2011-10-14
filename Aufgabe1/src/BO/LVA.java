package BO;

import java.util.Date;

public class LVA {
	public LVA(	int Nr,	String Name, Date Anmeldeanfang,
			Date Anmeldeende, Date Abmeldeende){
		setNr(Nr);
		setName(Name);
		setAnmeldeanfang(Anmeldeanfang);
		setAnmeldeende(Anmeldeende);
		setAbmeldeende(Abmeldeende);
	}
	public LVA(	int Nr,	String Name){	
		setNr(Nr);
		setName(Name);
	}
	
	
	private int Nr;
	private String Name;
	private Date Anmeldeanfang;
	private Date Anmeldeende;
	private Date Abmeldeende;
	private int StudAnz = 0;
	public void setNr(int nr) {
		Nr = nr;
	}
	public int getNr() {
		return Nr;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getName() {
		return Name;
	}
	public void setAnmeldeende(Date anmeldeende) {
		Anmeldeende = anmeldeende;
	}
	public Date getAnmeldeende() {
		return Anmeldeende;
	}
	public void setAbmeldeende(Date abmeldeende) {
		Abmeldeende = abmeldeende;
	}
	public Date getAbmeldeende() {
		return Abmeldeende;
	}
	public void incrementStudAnz() {
		StudAnz++;
	}
	public void decrementStudentAnz() {
		StudAnz--;
	}
	public int getStudAnz() {
		return StudAnz;
	}
	public void setAnmeldeanfang(Date anmeldeanfang) {
		Anmeldeanfang = anmeldeanfang;
	}
	public Date getAnmeldeanfang() {
		return Anmeldeanfang;
	}
	
	public boolean isAnmeldezeit(){
		return(getAnmeldeanfang().before(new Date()) && 
			getAnmeldeende().after(new Date()));
	}
	
	public boolean isAbmeldezeit(){
		return(this.getAbmeldeende().before(new Date()));
	}
}
