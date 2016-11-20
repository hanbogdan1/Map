package Domain;

import java.util.Date;

/**
 * Created by Test on 10/22/2016.
 */
public class Contract extends UniqueById<Integer> {
    public Integer _pid;
    public Integer _sid;
    public String _start;
    public String _deadLine;
    public Double _sum;

    public Contract(Integer id, Integer cid, Integer fid, String start, String deadLine, Double sum){
        _id = id;
        _sid = cid;
        _pid = fid;
        _start = start;
        _deadLine = deadLine;
        _sum = sum;
    }

    public void set_deadLine(String newDate){
        _deadLine = newDate;
    }

    public void set_sum(Double newSum){
        _sum = newSum;
    }

    public Integer get_pid(){
        return _pid;
    }

    public Integer get_sid(){
        return _sid;
    }

    public String get_start(){
        return _start;
    }

    public String get_deadLine(){
        return _deadLine;
    }

    public Double get_sum(){
        return _sum;
    }

    @Override
    public String toString(){
        return _id+" "+_sid+" "+_pid+" "+_start+" "+_deadLine+" "+_sum;
    }

}
