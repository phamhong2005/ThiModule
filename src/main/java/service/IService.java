package service;

import java.util.List;

public interface IService <E>{
    void add(E e);
    int findByid(int id);
    void delete(int id);
    void update(int id , E e);
    List<E> findAll();
}
