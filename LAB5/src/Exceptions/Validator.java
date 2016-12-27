package Exceptions;


import Exceptions.MyException;

/**
 * Created by Test on 10/22/2016.
 */
public interface Validator<T> {
    boolean verify(T t) throws MyException;
}
