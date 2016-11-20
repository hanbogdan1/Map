package Controller;

import Domain.*;
import Repozitory.*;
import Exceptions.*;

import java.io.FileNotFoundException;
import java.util.ArrayList;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Created by Test on 10/23/2016.
 */
public class Controller {
    private iRepo<post,Integer> _post;
    private iRepo<sarcina,Integer> _sarcinai;
    private iRepo<Contract,Integer> _rel;
    
    private String fNamesarcina = "sarcina.txt";
    private String fNamepostSer = "post.txt";
    private List<post> listPartPost;
    private List<sarcina> listPartSarcina;
    
    Validator<post> vf = new postValidator();
    Validator<sarcina> vc = new sarcinaValidator();
    Validator<Contract> vContract = new ValidatorContract();

    public Controller(){
    	_sarcinai = new RepoSarcinaFisier(fNamesarcina,vc);
    	_post = new RepoPostSer(fNamepostSer,vf);
        _rel = new RepoRelMemory(vContract);
        listPartPost = new ArrayList<>();
        listPartSarcina = new ArrayList<>();	
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

    

    public void addsarcina(Integer id,String descriere,Integer durata) throws MyException{
        //sarcina c = new sarcina(id,descriere);
        _sarcinai.add(new sarcina(id,descriere,durata));
    }

    public void updatesarcina(Integer id, String descriere,Integer durata) throws MyException{
        sarcina c = new sarcina(id,descriere,durata);
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
    
    
    //filtrari+sortari
    
    
    
    public List<sarcina> getPartListSarcina(){
        return listPartSarcina;
    }

    public List<post> getListPartPost(){
        return listPartPost;
    }

    public void setListPartSarcina(List<sarcina> newList){
        listPartSarcina = newList;
    }

    public void setListPartposte(List<post> newList){
        listPartPost = newList;
    }

    public void emptyPartialSarcinaList(){
        listPartSarcina.clear();
    }

    public void emptyPartialPostList(){
        listPartPost.clear();
    }

    //filtrari

    private <E> List<E> filterGeneric(List<E> lista, Predicate<E> p){
        return lista.stream().filter(p).collect(Collectors.toList());
    }

   

    public List<sarcina> filterSarcinaDescriere(String descriere){
        Predicate<sarcina> p = el->el.get_descriere().contains(descriere);
        return filterGeneric(_sarcinai.getAll(),p);
    }
    
    public List<sarcina> filterSarcinaFullTime(){
        Predicate<sarcina> p = el->el.get_durata()>6;
        return filterGeneric(_sarcinai.getAll(),p);
    }
    
    

    public List<post> filterPostDenumire(String denumire){
        Predicate<post> p = el->el.get_denumire().contains(denumire);
        return filterGeneric(_post.getAll(),p);
    }	

    public List<post> filterPostByTip(String tip){
        Predicate<post> p = el->el.get_tip().equals(tip);
        return filterGeneric(_post.getAll(),p);
    }
    
    
    public List<sarcina> FiltrareNoua(){
        Predicate<sarcina> p = el->(el.get_durata()>4 && !el.get_descriere().contains("and") );
        return filterGeneric(_sarcinai.getAll(), p);
     }
    
    
    public List<sarcina> sortnoua(List<sarcina> list){
    	return list.stream().sorted((c1, c2)->c1.get_durata()-c2.get_durata()).collect(Collectors.toList());
      //Collections.sort(list,post::comparaDescriere);
    }

    public List<sarcina> sortSarcinasByDescriere(List<sarcina> list){
        return list.stream().sorted((c1, c2)->c1.get_descriere().compareTo(c2.get_descriere())).collect(Collectors.toList());
      //Collections.sort(list,post::comparaDescriere);
    }

    public List<post> sortPostByDenumire(List<post> list){
    	return list.stream().sorted((c1, c2)->c1.get_denumire().compareTo(c2.get_denumire())).collect(Collectors.toList());
    }

    
    public List<sarcina> sortSarcinasByDurata(List<sarcina> list){
        return list.stream().sorted((c1, c2)->c1.get_durata()-c2.get_durata()).collect(Collectors.toList());
    }
    
}
