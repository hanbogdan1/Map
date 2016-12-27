package Repozitory;

import Domain.*;
import Exceptions.MyException;
import Exceptions.Validator;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by Test on 11/8/2016.
 */
public class RepoPostSer extends RepoUnique<post,Integer>{

    private String fName;

    public RepoPostSer(String fileName, Validator<post> validator) {
        super(validator);
        this.fName = fileName;
        try{
            this.loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.print("Datele din fisierul serializat cu filme cunt corupte:\n");
            e.printStackTrace();
        }
    }

    @Override
    public void loadData() throws FileNotFoundException, MyException {

        try {
            ObjectInputStream objInStream = new ObjectInputStream(new FileInputStream(fName));
            all = (ArrayList<post>) objInStream.readObject();
            objInStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData() throws FileNotFoundException, MyException {
        try{
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(fName));
            objectOutputStream.writeObject(all);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
