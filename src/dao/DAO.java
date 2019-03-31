package dao;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;

/**
 *
 * @author LLira
 */
public abstract class DAO<T> {

    protected T model;
    Connection conn = Connection.getInstance();

    public boolean save(T object) {
        try {
            conn.open();
            conn.obj.set(object);
            conn.obj.close();
            return true;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean delete(T object) {
        try {
            conn.open();
            ObjectSet results = conn.obj.get(object);
            if (results.size() > 0) {
                T t = (T) results.next();
                conn.obj.delete(t);
                conn.obj.close();
                return true;
            } else {
                conn.obj.close();
                return false;
            }
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println(e);
            return false;
        }
    }

    public T search(T object) {
        conn.open();
        T found = null;
        ObjectSet results = conn.obj.get(object);
        if (results.hasNext()) {
            found = (T) results.next();
        }
        return found;
    }

}//End class
