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
	
	private boolean isNachAnmeldeanfang(){
		if(getAnmeldeanfang()!=null){
			return(this.getAnmeldeanfang().before(new Date()));
		}else{
			return true;
		}
	}
	private boolean isVorAnmeldeende(){
		if(getAnmeldeende()!=null){
			return(this.getAnmeldeende().after(new Date()));
		}else{
			return true;
		}
	}
	
	public boolean isAnmeldezeit(){
		return isNachAnmeldeanfang() && isVorAnmeldeende();
	}
	
	public boolean isAbmeldezeit(){
		if(getAbmeldeende()!=null){
			return(this.getAbmeldeende().before(new Date()));
		}else{
			return true;
		}
	}
}
