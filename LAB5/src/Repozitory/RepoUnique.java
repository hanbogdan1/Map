package Repozitory;

import Domain.UniqueById;
import Exceptions.MyException;
import Exceptions.Validator;
import Utils.Observer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Test on 10/22/2016.
 */
public abstract class RepoUnique<T extends UniqueById<ID>,ID> implements iRepo<T,ID> {
    protected ArrayList<T> all;
    private Validator<T> validator;
    private List<Observer<T>> observers = new ArrayList<>();

    public RepoUnique(Validator<T> validator){
        this.validator = validator;
        all = new ArrayList<T>();
    }

    private boolean idExists(ID id){
        for(T e:all) {
            if (e.get_id().equals(id)) {
                return true;
            }
        }
        return false;
    }

    private Integer getPosById(ID id){
        for(T e:all) {
            if (e.get_id().equals(id)) {
                return all.indexOf(e);
            }
        }
        return -1;
    }

    @Override
    public T getElementById(ID id) throws MyException{
        for(T e:all){
            if(e.get_id().equals(id))
                return e;
        }
        throw new MyException("T id not found");
    }

    public boolean idAvailable(ID checkID){
        for(T e:all){
            if(e.get_id().equals(checkID))
                return false;
        }
        return true;
    }

    @Override
    public void add(T e) throws MyException {
        if (idExists(e.get_id()) || validator.verify(e)==false)
            throw new MyException("Id duplicat la adaugare ");
        all.add(e);
        notifyObservers();
        doSave();
    }

    private void doSave(){
        try {
            saveData();
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    @Override
    public T remove(T e) throws MyException {
        if (idExists(e.get_id())==false)
            throw new MyException("Se incearca stergerea unui element inexistene ");
        else {
         T a=all.remove(all.indexOf(e));
         notifyObservers();
         return a;
        }
        
    }

    @Override
    public T change(int pos, T e) throws MyException {
        return e;
    }

    @Override
    public T findAndChange(T e) throws MyException {
        if (!idExists(e.get_id())) {
            throw new MyException("Se incearca updateul unui element inexistent ");
        }
       // T ret = e;
        all.set(getPosById(e.get_id()), e);
        doSave();
        notifyObservers();
        return e;
    }

    @Override
    public ArrayList<T> getAll(){return all;}
    
    
    
    public void addObserver(Observer<T> o) {
        System.out.println("Add observer"+o.getClass());
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer<T> o) {
        System.out.println("Remove observer"+o.getClass());
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers){
            o.update(this);
        }
    }
}
