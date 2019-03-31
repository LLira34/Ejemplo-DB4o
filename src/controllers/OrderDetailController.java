package controllers;

import dao.OrderDetailDAO;
import javax.swing.table.DefaultTableModel;
import models.OrderDetail;

/**
 *
 * @author LLira
 */
public class OrderDetailController extends OrderDetailDAO {

    //Operations
    public boolean save(int id, int order, int product, double unitPrice, int quantity, double discount) {
        OrderDetail od = new OrderDetail(id, order, product, unitPrice, quantity, discount);
        return this.save(od);
    }
    
    public boolean update(int id, int order, int product, double unitPrice, int quantity, double discount){
        OrderDetail newOrderDetail = new OrderDetail(id, order, product, unitPrice, quantity, discount);
        return this.update(newOrderDetail);
    }

    public boolean delete(int id) {
        if (id > 0) {
            OrderDetail od = new OrderDetail(id, 0, 0, 0.0, 0, 0.0);
            return this.delete(od);
        } else {
            return false;
        }
    }

    public DefaultTableModel details() {
        String header[] = {"ID", "Orden", "Producto", "Precio Unitario", "Cantidad", "Descuento"};
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        OrderDetail detail = null;
        OrderDetail[] od = this.consultOrderDetail(detail);

        if (od != null) {
            for (OrderDetail od1 : od) {
                try {
                    Object[] obj = new Object[6];
                    obj[0] = od1.getId();
                    obj[1] = od1.getOrder();
                    obj[2] = od1.getProduct();
                    obj[3] = od1.getUnitPrice();
                    obj[4] = od1.getQuantity();
                    obj[5] = od1.getDiscount();
                    dtm.addRow(obj);
                } catch (NullPointerException e) {
                    System.out.println("Aqui el error: " + e);
                }
            }
        }
        return dtm;
    }

}//End class
