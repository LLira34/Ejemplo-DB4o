package dao;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import models.Order;

/**
 *
 * @author LLira
 */
public class OrderDAO extends DAO<Order> {

    public Order[] consult(Order object) {
        try {
            Order[] orders = null;
            conn.open();
            ObjectSet results = conn.obj.get(object);
            int i = 0;
            if (results.hasNext()) {
                orders = new Order[results.size()];
                while (results.hasNext()) {
                    try {
                        orders[i] = (Order) results.next();
                        i++;
                    } catch (Exception e) {
                        System.out.println("Error aqui: " + e);
                    }
                }
            }
            conn.obj.close();
            return orders;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("Error aqui: " + e);
            return null;
        }
    }

    public boolean update(Order object) {
        try {
            conn.open();
            ObjectSet results = conn.obj.get(new Order(object.getOrderID(), 0, 0, null, null, null, 0));
            if (results.size() > 0) {
                Order result = (Order) results.next();
                result.setCustomerID(object.getCustomerID());
                result.setEmployeeID(object.getEmployeeID());
                result.setOrderDate(object.getOrderDate());
                result.setRequiredDate(object.getRequiredDate());
                result.setShippedDate(object.getShippedDate());
                result.setShipVia(object.getShipVia());
                conn.obj.set(result);
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

    public Order[] getAll(Order object) {
        try {
            Order[] orders = null;
            conn.open();
            ObjectSet results = conn.obj.get(object);
            int i = 0;
            if (results.hasNext()) {
                orders = new Order[results.size()];
                while (results.hasNext()) {
                    orders[i] = (Order) results.next();
                    i++;
                }
            }
            conn.obj.close();
            return orders;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println(e);
            return null;
        }
    }

}//End class
