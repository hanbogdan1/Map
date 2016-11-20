package Domain;

public class sarcina extends UniqueById<Integer> {

	private String descriere;
	
	public sarcina(){
		this(-1, "");
	}
	
	public sarcina (Integer id , String desc){
		this._id=id;
		this.descriere=desc;
	}
	
	public Integer get_id(){
		return this._id;
	}
	
	public void  set_id(Integer a ){
		this._id=a;
	}
	
	public String get_descriere (){
		return this.descriere;
	}
	
	public void set_descriere(String desc){
		this.descriere=desc;
	}
	
	public String toString(){
		return _id +" "+ this.descriere;
	}
}
