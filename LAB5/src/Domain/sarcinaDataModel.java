package Domain;
import Utils.Observable;
import Utils.Observer;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.List;

import Repozitory.iRepo;


public class sarcinaDataModel implements Observer<sarcina> {
    ObservableList<sarcina> model;
    iRepo repository;

    public sarcinaDataModel(iRepo<sarcina,Integer> repository){
        this.repository = repository;
        repository.addObserver(this);
        model = FXCollections.observableArrayList((List<sarcina>)repository.getAll());
    }

    public ObservableList<sarcina> getModel(){
        return model;
    }

    @Override
    public void update(Observable<sarcina> e) {
        model.setAll((List<sarcina>)repository.getAll());
    }
}
