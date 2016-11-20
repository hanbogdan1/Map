package Teste;

import Exceptions.*;
import Repozitory.RepoRelMemory;
import Domain.*;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Test on 11/10/2016.
 */
public class RepoUniqueTest {

    private RepoRelMemory all;

    @Before
    public void setUp() throws Exception {
        all = new RepoRelMemory(new ValidatorContract());
        all.add(new Contract(100,1,1,"21.10.2016","12.12.2016",12.5));
        all.add(new Contract(101,2,3,"10.10.2016","08.11.2016",23.9));
    }

    @Test
    public void getElementById() throws Exception {
    	Contract f = all.getElementById(100);
        assert(f.get_start()=="21.10.2016");
        Contract f2 = all.getElementById(101);
        assert(f2.get_sid()==2);
    }

    @Test
    public void idAvailable() throws Exception {
        assertFalse(all.idAvailable(1));
        assertTrue(all.idAvailable(102));
    }

    @Test
    public void add() throws Exception {
        all.add(new Contract(103,1,1,"21.10.2016","12.12.2016",12.5));
        assert(all.getAll().size()==5);
    }

    @Test
    public void remove() throws Exception { //foloseste si getElementById si getAll
        all.remove(all.getElementById(100));
        assert(all.getAll().size()==3);
    }

    @Test
    public void findAndChange() throws Exception {
        all.findAndChange(new Contract(100,1,1,"21.10.2015","12.12.2016",12.5));
        Contract r = all.getElementById(100);
        assert(r.get_start()=="21.10.2015");
    }

    @Test
    public void getAll() throws Exception {
        assert(all.getAll().size() == 4);
    }

}