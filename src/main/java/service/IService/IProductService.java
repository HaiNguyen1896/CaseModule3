    package service.IService;

    import java.util.List;

    public interface IProductService<E> {
        void add (E e);
        void delete(int id);
        List<E> findProduct(String search);
        void edit (int id);
    }
