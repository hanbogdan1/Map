package Repozitory;
import Domain.Contract;
import Exceptions.MyException;
import Exceptions.Validator;

import java.io.FileNotFoundException;

/**
 * Created by Test on 11/8/2016.
 */
public class RepoRelMemory extends RepoUnique<Contract,Integer> {

    public RepoRelMemory(Validator<Contract> validator){
        super(validator);
        try {
            loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.println("Datele relatilor sunt corupte - repo in memory");
            e.printStackTrace();
        }
    }

    @Override
    public void loadData() throws FileNotFoundException, MyException {
        all.add(new Contract(1,1,1,"21.10.2016","12.12.2016",12.5));
        all.add(new Contract(2,2,3,"10.10.2016","08.11.2016",23.9));
    }

    @Override
    public void saveData() throws FileNotFoundException, MyException {

    }
}
