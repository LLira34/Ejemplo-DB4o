package dao;

import com.db4o.ObjectContainer;
import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import models.Order;
import models.OrderDetail;

/**
 *
 * @author LLira
 */
public class OrderDetailDAO extends DAO<OrderDetail> {
    
    public boolean update(OrderDetail object) {
        try {
            conn.open();
            ObjectSet results = conn.obj.get(new OrderDetail(object.getId(), 0, 0, 0.0, 0, 0.0));
            if (results.size() > 0) {
                OrderDetail result = (OrderDetail) results.next();
                
                result.setId(object.getId());
                result.setOrder(object.getOrder());
                result.setProduct(object.getProduct());
                result.setUnitPrice(object.getUnitPrice());
                result.setQuantity(object.getQuantity());
                result.setDiscount(object.getDiscount());
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

    public OrderDetail[] consultOrderDetail(OrderDetail object) {
        try {
            OrderDetail[] details = null;
            conn.open();
            ObjectSet resultDetails = conn.obj.get(object);
            int i = 0;
            if (resultDetails.hasNext()) {
                details = new OrderDetail[resultDetails.size()];
                while (resultDetails.hasNext()) {
                    try {
                        details[i] = (OrderDetail) resultDetails.next();
                        i++;
                    } catch (Exception e) {
                        System.out.println("Error aqui: " + e);
                    }
                }
            }
            conn.obj.close();
            return details;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("Error aqui: " + e);
            return null;
        }
    }

    public OrderDetail[] getAllOrders() {
        conn.open();
        Order o1 = new Order();
        ObjectSet result = conn.obj.get(o1);
        int combo = 0;
        if (result.size() > 0) {
            while (result.hasNext()) {
                System.out.println(result.next());
                //combo = (int) result.next();
            }
        }
        conn.obj.close();
        return null;
    }

}//End class
