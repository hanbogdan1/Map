package Utils;
public interface Observer<T> {
    void update(Observable<T> e);
}
