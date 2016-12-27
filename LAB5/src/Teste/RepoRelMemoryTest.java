package Teste;

import Exceptions.*;
import Repozitory.RepoRelMemory;
import Domain.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

/**
 * Created by Test on 11/10/2016.
 */
public class RepoRelMemoryTest {

    private RepoRelMemory repo = new RepoRelMemory(new ValidatorContract());

    @Test
    public void loadData() throws Exception {
        repo.add(new Contract(100,1,1,"21.10.2016","12.12.2016",12.5));
        repo.add(new Contract(101,2,3,"10.10.2016","08.11.2016",23.9));
        assert(repo.getAll().size()==4);
        Contract fxc1 = repo.getElementById(100);
        assert(fxc1.get_pid()==1);
        assert(fxc1.get_sid()==1);
        assert(fxc1.get_start()=="21.10.2016");
        assert(fxc1.get_deadLine()=="12.12.2016");
        Contract fxc2 = repo.getElementById(101);
        assert(fxc2.get_start()=="10.10.2016");
        //repo.getAll().stream().forEach(System.out::println);
    }

    @Test
    public void saveData() throws Exception {
        assertTrue(true);
    }

}