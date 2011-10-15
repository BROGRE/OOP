package Controller;

import DB.Datenbank;

public class DBControllerFactory {
	private Datenbank connector;
	
	public DBControllerFactory(){
		connector = new Datenbank();		
	}
	public DBControllerFactory(Datenbank connector){
		this.connector = connector;
	}
	
	public AnAbmeldenController Create_AnAbmeldenController(){
		return new AnAbmeldenController(connector);
	}
	
	public AuflistungsController Create_AuflistungsController(){
		return new AuflistungsController(connector);
	}
	
	public BOFactory Create_BOFactory(){
		return new BOFactory(connector);
	}
}