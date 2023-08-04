package service.IService;

import java.util.List;

public interface IOrder<E> {
    void add (E e);
    boolean deleteOrder(int id);
    List<E> findAll();
}
