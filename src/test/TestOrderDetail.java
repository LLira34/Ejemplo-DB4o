package test;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import controllers.OrderDetailController;
import dao.Connection;
import dao.OrderDetailDAO;
import java.util.ArrayList;
import java.util.List;
import models.Order;
import static test.Test.query;
import static test.Test.queryOrder;
import static test.Test.queryProduct;

/**
 *
 * @author LLira
 */
public class TestOrderDetail {

    public static void main(String[] args) {

        OrderDetailDAO odd = new OrderDetailDAO();
        Connection conn = Connection.getInstance();
        //String result = odd.readOrders();
        //System.out.println("Ordenes: " + result);
        /*OrderDetailController odc = new OrderDetailController();
        String result = odc.getOrders();
        System.out.println("Ordenes: " + result);
        Order order = new Order(0, 0, 0, null, null, null, 0);
        int results = order.getCustomerID();
        System.out.println("Orden: " + results);*/
        //ObjectContainer obj;
        ObjectContainer db = Db4o.openFile(
                "C:\\Users\\LLira\\Desktop\\databases_db4o\\DB_AppDB4o.yap");
        //create(db);
        //createOrder(db);
        //createProduct(db);
        getAll(db);

        //query(db);
        //queryOrder(db);
        //queryProduct(db);
        db.close();
    }

    public static void getAll(ObjectContainer obj) {
        Order o1 = new Order(0, 0, 0, null, null, null, 0);
        ObjectSet result = obj.get(o1);
        if (result.size() > 0) {
            while (result.hasNext()) {
                System.out.println(result.next());
            }
        }
    }

}//End class
