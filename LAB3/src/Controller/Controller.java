package Controller;

import Domain.*;
import Repozitory.*;
import Exceptions.*;

import java.io.FileNotFoundException;

/**
 * Created by Test on 10/23/2016.
 */
public class Controller {
    private iRepo<post,Integer> _post;
    private iRepo<sarcina,Integer> _sarcinai;
    private iRepo<Contract,Integer> _rel;
    private String fNamesarcina = "sarcina.txt";
    private String fNamepostSer = "post.txt";

    Validator<post> vf = new postValidator();
    Validator<sarcina> vc = new sarcinaValidator();
    Validator<Contract> vContract = new ValidatorContract();

    public Controller(){
    	_sarcinai = new RepoSarcinaFisier(fNamesarcina,vc);
    	_post = new RepoPostSer(fNamepostSer,vf);
        
        _rel = new RepoRelMemory(vContract);
    }

    public void saveAll(){
        try {
            _post.saveData();
            _sarcinai.saveData();
            _rel.saveData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    //sarcina

    public void addsarcina(Integer id,String descriere) throws MyException{
        //sarcina c = new sarcina(id,descriere);
        _sarcinai.add(new sarcina(id,descriere));
    }

    public void updatesarcina(Integer id, String descriere) throws MyException{
        sarcina c = new sarcina(id,descriere);
        _sarcinai.findAndChange(c);
    }

    public void removesarcina(Integer id) throws MyException{
        _sarcinai.remove(_sarcinai.getElementById(id));
    }

    public void showAllsarcinas(){
        for(sarcina c:_sarcinai.getAll()){
            System.out.println(c);
        }
    }

    //post

    public void addPost(Integer id, String denumire, String tip ) throws MyException{
        post f = new post(id,denumire,tip);
        _post.add(f);
    }

    public void updatePost(Integer id, String denumire, String tip) throws MyException{
        post f = new post(id,denumire,tip);
        _post.findAndChange(f);
    }

    public void removePost(Integer id) throws MyException{
        _post.remove(_post.getElementById(id));
    }

    public void showAllPosts(){
        for(post f:_post.getAll()){
            System.out.println(f);
        }
    }

    //Contract

    public void addRel(Integer id, Integer cid, Integer fid, String start, String deadLine, Double sum) throws MyException{
        Contract Contract = new Contract(id,cid,fid,start,deadLine,sum);
        _rel.add(Contract);
    }

    public void updateRel(Integer id, Integer cid, Integer fid, String start, String deadLine, Double sum) throws MyException{
        Contract Contract = new Contract(id,cid,fid,start,deadLine,sum);
        _rel.findAndChange(Contract);
    }

    public void removeRel(Integer id) throws MyException{
        _rel.remove(_rel.getElementById(id));
    }

    public void showAllRel(){
        for(Contract r:_rel.getAll()){
            System.out.println(r);
        }
    }
}
