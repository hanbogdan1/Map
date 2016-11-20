package Domain;

public class sarcina extends UniqueById<Integer> {

	private String descriere;
	private Integer durata;
	
	public sarcina(){
		this(-1, "",-1);
	}
	
	public sarcina (Integer id , String desc,Integer durata){
		this._id=id;
		this.descriere=desc;
		this.durata=durata;
	}
	
	public Integer get_id(){
		return this._id;
	}
	
	public Integer get_durata(){
		return this.durata;
	}
	public void  set_id(Integer a ){
		this._id=a;
	}
	
	public void  set_durata(Integer a ){
		this.durata=a;
	}
	
	public String get_descriere (){
		return this.descriere;
	}
	
	public void set_descriere(String desc){
		this.descriere=desc;
	}
	
	static public int comparaDescriere(sarcina s1,sarcina s2){
        return s1.get_descriere().compareTo(s2.get_descriere());
	}
	
	public String toString(){
		return _id +" "+ this.descriere+" "+ this.durata;
	}
}
