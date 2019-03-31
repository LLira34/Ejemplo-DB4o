package dao;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;

/**
 *
 * @author LLira
 */
public class Connection {

    protected ObjectContainer obj;
    private static Connection instance;

    private Connection() {
    }

    public static Connection getInstance() {
        if (instance == null) {
            instance = new Connection();
        }
        return instance;
    }

    public void open() {
        try {
            this.obj = Db4o.openFile("C:\\Users\\LLira\\Desktop\\databases_db4o\\DB_AppDB4o.yap");
        } catch (Exception e) {
            System.out.println("Error aqui: " + e);
        }
    }

}//End class
