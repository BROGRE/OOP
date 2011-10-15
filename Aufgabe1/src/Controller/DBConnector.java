package Controller;

import java.util.List;

import BO.LVA;
import BO.Student;
import DB.Datenbank;

public abstract class DBConnector {
	protected Datenbank connector;
	
	protected DBConnector(Datenbank connector){
		this.connector = connector;
	}
	
	protected List<Student> getStudentList4LVA(LVA lva){
		if(connector.getInskriptionen().containsKey(lva)){
			return connector.getInskriptionen().get(lva);
		}else {
			return null;
		}
	}
}