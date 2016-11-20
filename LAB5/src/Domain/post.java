package Domain;

import java.io.Serializable;

public class post extends UniqueById<Integer> implements Serializable{
	//private Integer id ;
	private String _denumire;
	private String _tip;
	
	public post(Integer id, String denumire ,String tip){
		this._id=id;
		this._denumire=denumire;
		this._tip=tip;
		
	}
	
	public post (){
		this(-1, "", "");
	}
	
	
	public Integer get_id(){
		return this._id;
	}
	public String get_denumire(){
		return this._denumire;
	}
	public String get_tip(){
		return this._tip;
	}
	
	public void set_id(Integer ID){
		this._id=ID;
	}
	public void set_denumire(String Dem){
		 this._denumire=Dem;
	}
	public void  set_tip(String tip){
		this._tip=tip;
	}
	
	public String toString(){
		return _id +" "+ this._denumire + " "+ this._tip;
	}
	
}
