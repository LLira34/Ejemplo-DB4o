package test;

import com.db4o.Db4o;
import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import models.Order;
import models.OrderDetail;
import models.Product;

/**
 *
 * @author LLira
 */
public class Test {

    public static void main(String[] args) {
        ObjectContainer db = Db4o.openFile(
                "C:\\Users\\LLira\\Desktop\\databases_db4o\\DB_AppDB4o.yap");
        //create(db);
        //createOrder(db);
        //createProduct(db);

        query(db);
        queryOrder(db);
        queryProduct(db);
        db.close();
    }

    public static void create(ObjectContainer base) {
        Product p1 = new Product(2, "Pinguinos", 2, 2, "Muchas", 14.2);
        //Order o1 = new Order(2, 2, 2, "1997-01-01", "1997-01-01", "1997-01-01", 5);

        /*OrderDetail od1 = new OrderDetail(22.2, 8, 0);
        //od1.addOrder(o1);
        od1.addProduct(p1);

        base.set(od1);*/
    }

    public static void createOrder(ObjectContainer base) {
        //Order o1 = new Order(1, 1, 1, "1997-01-01", "1997-01-01", "1997-01-01", 0);
        //base.set(o1);
    }

    public static void createProduct(ObjectContainer base) {
        Product product = new Product(1, "Sabritas", 1, 1, "15 cajas", 12.2);
        base.set(product);
    }

    public static void query(ObjectContainer base) {
        OrderDetail od1 = new OrderDetail();
        ObjectSet result = base.get(od1);
        System.out.println("Existing " + result.size() + " order details");
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void queryOrder(ObjectContainer base) {
        Order o1 = new Order();
        ObjectSet result = base.get(o1);
        System.out.println("Existing " + result.size() + " order");
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

    public static void queryProduct(ObjectContainer base) {
        Product p1 = new Product(0, null, 0, 0, null, 0);
        ObjectSet result = base.get(p1);
        System.out.println("Existing " + result.size() + " products");
        while (result.hasNext()) {
            System.out.println(result.next());
        }
    }

}//End class
