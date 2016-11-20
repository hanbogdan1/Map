package Repozitory;
import Exceptions.MyException;
import Utils.Observable;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Test on 10/22/2016.
 */
public interface iRepo<T,ID> extends Observable<T>{
    void add(T e) throws MyException;
    T remove(T e) throws MyException;
    T change(int pos, T e) throws MyException;
    T findAndChange(T e) throws MyException;
    T getElementById(ID id) throws  MyException;
    void loadData() throws FileNotFoundException, MyException;
    void saveData() throws FileNotFoundException, MyException;
    List<T> getAll();
}
