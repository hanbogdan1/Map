package Repozitory;

import Domain.*;
import Exceptions.MyException;
import Exceptions.Validator;

import java.io.*;
import java.util.StringTokenizer;

/**
 * Created by Test on 11/8/2016.
 */
public class RepoSarcinaFisier extends RepoUnique<sarcina,Integer> {

    private String fName;

    public RepoSarcinaFisier(String fileName, Validator<sarcina> validator) {
        super(validator);
        this.fName = fileName;
        try{
            this.loadData();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (MyException e) {
            System.out.print("Datele din fisierul cu sarcinai cunt corupte:\n");
            e.printStackTrace();
        }
    }


    @Override
    public void loadData() throws FileNotFoundException, MyException{
        String line;
        //String argv[] = new String[2];
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.fName)))) {
            while(((line = reader.readLine())!=null)){
                StringTokenizer tk = new StringTokenizer(line,"|");
                sarcina c = new sarcina(Integer.parseInt(tk.nextToken()),tk.nextToken(),Integer.parseInt(tk.nextToken()));
                this.add(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveData() throws FileNotFoundException, MyException {
        try(BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.fName)))){
            all.forEach(sarcina -> {
                String line = sarcina.get_id() + "|" + sarcina.get_descriere() + "|"+ sarcina.get_durata()+"\n";
                try {
                    writer.write(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
