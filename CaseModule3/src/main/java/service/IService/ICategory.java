package service.IService;

import java.util.List;

public interface ICategory<E> {
    void add (E e);
    void delete(int id);
    List<E> findAll();
    boolean edit (int id, E e);
}
