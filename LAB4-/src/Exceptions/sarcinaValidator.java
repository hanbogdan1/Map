package Exceptions;

import Exceptions.MyException;
import Domain.*;

public class sarcinaValidator implements Validator<sarcina>{

	@Override
	public boolean verify (sarcina object) throws MyException {
		String errors="";
			if(object.get_id()<0)
				errors+="Id trebuie sa fie pozitiv !\n";
			if(object.get_durata()<0)
				errors+="Durata trebuie sa fie pozitiva !\n";
			if(object.get_descriere()=="")
				errors+="Descrierea nu trebuie sa fie vida !\n";
			if(errors!="")
				throw new MyException(errors);
			return true;
	}

}
