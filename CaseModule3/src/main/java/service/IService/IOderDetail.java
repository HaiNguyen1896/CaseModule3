package service.IService;

import java.util.List;

public interface IOderDetail<E> {
    void add (E e);
    boolean deleteOrderDetail(int id);
    List<E> findAll();
    boolean edit (int id, E e);
}
