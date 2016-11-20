package UserInterface;

import Controller.Controller;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import Exceptions.MyException;

/**
 * Created by Test on 10/23/2016.
 */
public class UI {
    public UI(){};
    private void show(){
        /* shows the menu of the aplication*/
        System.out.println("\n");
        System.out.println("------------------------------");
        System.out.println("1 - adauagre post");
        System.out.println("2 - stergere post");
        System.out.println("3 - update post");
        System.out.println("4 - toate posturile");
        System.out.println("\n");
        System.out.println("5 - adauagre sarcina");
        System.out.println("6 - stergere sarcina");
        System.out.println("7 - update sarcina");
        System.out.println("8 - tote sarcinile");
        System.out.println("\n");
        System.out.println("9 - adaugare contract");
        System.out.println("10 - returnare");
        System.out.println("11 - update inchiriere");
        System.out.println("12 - toate relatile\n");
        System.out.println("13 - salvare");
        System.out.println("14 - sortare dupa descriere a sarcinilor");
        System.out.println("15 - sortarea dupa durata a sarcinilor");
        System.out.println("16 - sortare dupa denumire a posturilor");
        System.out.println("17 - filtrare dupa denumire a posturilor");
        System.out.println("18 - filtrare dupa tip a posturilor");
        System.out.println("19 - filtrare dupa durata a sarcinilor");
        System.out.println("20 - filtrare dupa descriere a sarcinilor");
        System.out.println("------------------------------");
    }
    public void start()
    {
        Controller ctrl = new Controller(){};
        try{
            initialize(ctrl);
            sort_nou(ctrl);
        }catch(MyException e){
            System.out.println("Adaugari implicite refuzate");
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
        Scanner in = new Scanner(System.in);

        while(true){
            show();
            //String sNum = in.nextLine();
            Integer num;
            while(!in.hasNextInt()){
                System.out.println("trebuie sa fie intreg");
                in.next();
            }
            num = in.nextInt();
            switch(num) {
                case 1: {
                    doAddPost(ctrl);
                    break;
                }
                case 2: {
                    doRmPost(ctrl);
                    break;
                }
                case 3: {
                    doUpPost(ctrl);
                    break;
                }
                case 4: {
                    printPost(ctrl);
                    break;
                }
                case 5: {
                    doAddSarcina(ctrl);
                    break;
                }
                case 6: {
                    doRmSarcina(ctrl);
                    break;
                }
                case 7: {
                    doUpSarcina(ctrl);
                    break;
                }
                case 8: {
                    printSarcinas(ctrl);
                    break;
                }
                case 9:{
                    doAddRel(ctrl);
                    break;
                }
                case 10:{
                    doRmRel(ctrl);
                    break;
                }
                case 11:{
                    doUpRel(ctrl);
                    break;
                }
                case 12:{
                    printRels(ctrl);
                    break;
                }
                case 13:{
                    ctrl.saveAll();
                    break;
                }
                case 14:{
                	sotare_sarcina_descriere(ctrl);
                    break;
                }
                case 15:{
                	sotare_sarcina_durata(ctrl);
                    break;
                }
                case 16:{
                	sotare_posturi_denumire(ctrl);
                    break;
                }
                case 17:{
                    filtrare_denumire_posturi(ctrl);
                    break;
                }
                case 18:{
                	filtrare_tip_posturi(ctrl);
                    break;
                }
                case 19:{
                	filtrare_durata_sarcini(ctrl);
                    break;
                }
                case 20:{
                	filtrare_descriere_sarcini(ctrl);
                    break;
                }
                
                default: {
                    System.out.println("Invalid input !");
                }
            }
        }
       
    }

    
    
    private void filtrare_denumire_posturi(Controller ctrl){
    	Scanner in = new Scanner(System.in);
    	String descriere=getString(in, "Introduceti denumire pt sortare!");
    	ctrl.emptyPartialPostList();
        ctrl.setListPartposte(ctrl.filterPostDenumire(descriere));
        printList(ctrl.getListPartPost());
    }
    
    
    private void filtrare_tip_posturi(Controller ctrl){
    	Scanner in = new Scanner(System.in);
    	String descriere=getString(in, "Introduceti tipul pt sortare! ");
    	ctrl.emptyPartialPostList();
        ctrl.setListPartposte(ctrl.filterPostByTip(descriere));
        printList(ctrl.getListPartPost());
    }
   private void filtrare_durata_sarcini(Controller ctrl){
   		ctrl.emptyPartialSarcinaList();
       ctrl.setListPartSarcina(ctrl.filterSarcinaFullTime());
       printList(ctrl.getPartListSarcina());
    }
   private void filtrare_descriere_sarcini(Controller ctrl){
	   Scanner in = new Scanner(System.in);
   		String descriere=getString(in, "Introduceti descriere pt sortare! ");
   	  ctrl.emptyPartialSarcinaList();
       ctrl.setListPartSarcina(ctrl.filterSarcinaDescriere(descriere));
       printList(ctrl.getPartListSarcina());
   }
   private void sort_nou(Controller ctrl){
	    
   	    ctrl.emptyPartialSarcinaList();
   	  
        ctrl.setListPartSarcina(ctrl.sortnoua((ctrl.FiltrareNoua())));
        printList(ctrl.getPartListSarcina());
   }
    
    
    private void initialize(Controller ctrl) throws MyException {
        //ctrl.addSarcina(1,"Ion","Str. mare");
        //ctrl.addSarcina(2,"Petru","Calea dreapta");
        //ctrl.addSarcina(3,"Gogu","Bdul Dacia");
      

    }

    private void printRels(Controller ctrl) {
        ctrl.showAllRel();
        
    }
    
    private void sotare_sarcina_descriere(Controller ctrl){
    	Scanner in = new Scanner(System.in);
    	String descriere=getString(in, "Introduceti descriere pt sortare! ");
    	ctrl.emptyPartialSarcinaList();
        ctrl.setListPartSarcina(ctrl.sortSarcinasByDescriere(ctrl.filterSarcinaDescriere(descriere)));
        printList(ctrl.getPartListSarcina());
    }
    private void sotare_sarcina_durata(Controller ctrl){
    	ctrl.emptyPartialSarcinaList();
        ctrl.setListPartSarcina(ctrl.sortSarcinasByDurata(ctrl.filterSarcinaFullTime()));
        printList(ctrl.getPartListSarcina());
        
    	
    }
    private void sotare_posturi_denumire(Controller ctrl){
  	
    	Scanner in = new Scanner(System.in);
    	String descriere;
    	descriere=getString(in, "Introduceti denumire pt sortare: ");
    	ctrl.emptyPartialPostList();
        ctrl.setListPartposte(ctrl.sortPostByDenumire(ctrl.filterPostDenumire(descriere)));
        printList(ctrl.getListPartPost());
  }
    
    
    
    
    
    private <E> void printList(List<E> lista){
        lista.stream().forEach(System.out::println);
    }
    
    private void doUpRel(Controller ctrl) {
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"ID rel: ");
        Integer fid  = getInteger(in,"post id: ");
        Integer cid = getInteger(in,"Sarcina id: ");
        //String start = getString(in,"start: ");
        String dead = getString(in,"DeadLine: ");
        Double pret = getDouble(in,"Price: ");
        //DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //startDate = current day;
        Date date = new Date();
        try {
            ctrl.updateRel(id,cid,fid,date.toString(),dead,pret);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doRmRel(Controller ctrl) {
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"Id-ul dupa care se va face stergerea: ");
        try {
            ctrl.removeRel(id);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doAddRel(Controller ctrl) {
        Scanner in = new Scanner(System.in);

        Integer id = getInteger(in,"ID rel: ");
        Integer fid  = getInteger(in,"Post id: ");
        Integer cid = getInteger(in,"Sarcina id: ");
        //String start = getString(in,"start: ");
        String dead = getString(in,"DeadLine: ");
        Double pret = getDouble(in,"Price: ");
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy"); //startDate = current day;
        Date date = new Date();
        try {
            ctrl.addRel(id,cid,fid,dateFormat.format(date),dead,pret);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private Double getDouble(Scanner in, String msg) {
        boolean good = false;
        Double p;
        while(good==false) {
            try {
                good = true;
                in.nextLine();
                System.out.println(msg);
                p = in.nextDouble();
                return p;
            } catch (InputMismatchException e) {
                good = false;
                System.out.println("Alegeti un pret valid !" + e.getMessage());
            }
        }
        //
        p=0.0;
        return p;
    }

    //verificari input primar !!!!

    private String getString(Scanner s, String msg){
        boolean good = false;
        String str;
        while(good == false) {
            try {
                good = true;
                s.nextLine();
                System.out.println(msg);
                str = s.next();
                return str;
            } catch (InputMismatchException e) {
                good = false;
                System.out.println("Alegeti un string valid !" + e.getMessage());
            }
        }
     
        str = "";
        return str;
    }

    private Integer getInteger(Scanner s, String msg){
        while(true) {
            Integer i;
            try {
                System.out.println(msg);
                i = s.nextInt();
                return i;
            } catch (InputMismatchException e) {
                System.out.println("Alegeti un Integer valid !" + e.getMessage());
                continue;
            }
        }
    }

    private void doAddPost(Controller ctrl){
        Scanner in = new Scanner(System.in);

        Integer id = getInteger(in,"Id");
        String denumire = getString(in,"denumire");
        String tip = getString(in,"tip");
        try {
            ctrl.addPost(id,denumire,tip);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doUpPost(Controller ctrl){
        Scanner in = new Scanner(System.in);

        Integer id = getInteger(in,"Id");
        String denumire = getString(in,"denumire");
        String tip = getString(in,"tip");
        
        try {
            ctrl.updatePost(id,denumire,tip);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doRmPost(Controller ctrl){
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"Id-ul dupa care se va face stergerea: ");
        try {
            ctrl.removePost(id);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printPost(Controller ctrl){
        ctrl.showAllPosts();
    }

    private void doAddSarcina(Controller ctrl){
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"Id");
        Integer durata = getInteger(in,"Durata");
        String descriere = getString(in,"descriere");
        try {
            ctrl.addsarcina(id,descriere,durata);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doRmSarcina(Controller ctrl){
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"Id-ul dupa care se va face stergerea: ");
        try {
            ctrl.removesarcina(id);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void doUpSarcina(Controller ctrl){
        Scanner in = new Scanner(System.in);
        Integer id = getInteger(in,"Id");
        Integer durata = getInteger(in,"Durata");
        String descriere = getString(in,"descriere");
        try {
            ctrl.updatesarcina(id,descriere,durata);
        } catch (MyException e) {
            System.out.println(e.getMessage());
        }
    }

    private void printSarcinas(Controller ctrl){
        ctrl.showAllsarcinas();
    }

}
