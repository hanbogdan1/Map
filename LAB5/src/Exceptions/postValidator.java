package Exceptions;

import Exceptions.MyException;

import Domain.*;


public class postValidator implements Validator<post>{

	@Override
	public boolean verify(post object) throws MyException {
			String errors="";
				if(object.get_id()<0)
					errors+="Id trebuie sa fie pozitiv !\n";
				if(object.get_denumire()=="")
					errors+="Denumirea nu trebuie sa fie vida !\n";
				if(object.get_tip()=="")
					errors+="Tipul nu trebuie sa fie vid !\n";
				if(errors!="")
					throw new MyException(errors);
				return true;
			
		}
		
		
}
