package Interfaces;

public interface ISensor<T> {
    void subscribe(IObserver<T> observer);
    void unsubscribe(IObserver<T> observer);
    void broadcasting();
}
