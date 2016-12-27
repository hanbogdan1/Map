package Exceptions;


import Domain.*;
import Repozitory.RepoUnique;

public class ValidatorContract implements Validator<Contract>{

	 private String errCollect;
	    public ValidatorContract(){
	        errCollect = "";
	    }
	    public boolean verify(Contract e) throws MyException{ 
	        if(e.get_sum() < 0) {
	            errCollect+="Suma nu poate sa fie negativa\n";
	        }
	        String[] parts = e.get_deadLine().split("\\.");
	        String[] partsStart = e.get_start().split("\\.");
	        //System.out.println(e.get_deadLine());
	        //System.out.println(parts[0]);
	        if(parts.length!=3){
	            errCollect+="Formatul datei este gresit. Format: zz.ll.aaaa\n";
	        }
	        if((parts[2]+parts[1]+parts[0]).compareTo(partsStart[2]+partsStart[1]+partsStart[0])<0) {
	            errCollect+="Data de sfarsit nu poate sa fie in trecut\n";
	        }

	        String s = e.get_start();
	        //checkDateFormat(s);
	        s = e.get_deadLine();
	        checkDateFormat(s);
	        if(errCollect!="")
	            throw new MyException(errCollect);
	        return true;
	    }

	    public boolean checkCorelation(Contract c, RepoUnique<sarcina,Integer> rec, RepoUnique<post,Integer> ref){
	        if(rec.idAvailable(c.get_sid()) == true || ref.idAvailable(c.get_pid()) == true) {
	            errCollect+="Eroare la corelatie\n";
	        }
	        return false;
	    }

	    private void checkDateFormat(String s){
	        if(s.length()!=10) {
	            errCollect+="Formatul datei este gresit. Lungime incorecta. Format: zz.ll.aaaa\n";
	        }
	        if(!s.matches("[0-9.]+")) {
	            errCollect+="Nu pot exista caractere in data. Format: zz.ll.aaaa\n";
	        }
	        char[] c = s.toCharArray();
	        if(c[2]!='.' && c[5]!='.') {
	            errCollect+="Caracterul . nu este la locul potrivit. Format: zz.ll.aaaa\n";
	        }
	        String[] parts = s.split("\\.");
	        Integer zi,luna,an;
	        zi = Integer.parseInt(parts[0]);
	        luna = Integer.parseInt(parts[1]);
	        an = Integer.parseInt(parts[2]);
	        if(zi > 31) {
	            errCollect+="Ziua nu poate sa fie > 31. Format: zz.ll.aaaa\n";
	        }
	        if(zi > 28 && an%4!=0) {
	            errCollect+="Nu exista zi > 28 in februrie daca anul nu este bisect Format: zz.ll.aaaa\n";
	        }
	        if(zi > 29 && luna==2){
	            errCollect+="Nu exista zi > 29 in daca anul nu este bisect Format: zz.ll.aaaa\n";
	        }
	        if(zi == 31 && (luna == 2 || luna == 4 || luna == 6 || luna == 9 || luna == 11)){
	            errCollect+="Doar lunile 01,03,05,07,10,12 au 31 de zile Format: zz.ll.aaaa\n";
	        }
	        if(luna > 12) {
	            errCollect+="Luna nu poate sa fie > 12 Format: zz.ll.aaaa\n";
	        }
	    }

}
