package service.IService;

import java.util.List;

public interface IProductService<E> {
    void add (E e);
    boolean deleteProduct(int id);
    List<E> findAll();
    boolean edit (int id, E e);
    List<E> findProduct(String search);
}
