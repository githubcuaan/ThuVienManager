package interfaces.CRUD;

import java.util.List;

public interface ICRUD<T> {
    void them(T obj);
    boolean xoa(String id);
    void sua(T obj);
    List<T> timKiemTheoTen(String ten);
    List<T> getAll();
}