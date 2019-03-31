package controllers;

import dao.OrderDAO;
import javax.swing.table.DefaultTableModel;
import models.Order;

/**
 *
 * @author LLira
 */
public class OrderController extends OrderDAO {

    public OrderController() {
    }

    public boolean save(int orderID, int customerID, int employeeID, String orderDate,
            String requiredDate, String shippedDate, int shipVia) {
        Order order = new Order(orderID, customerID, employeeID, orderDate, requiredDate, shippedDate, shipVia);
        return this.save(order);
    }

    public boolean update(int orderID, int customerID, int employeeID, String orderDate, String requiredDate, String shippedDate, int shipVia) {
        Order newOrder = new Order(orderID, customerID, employeeID, orderDate, requiredDate, shippedDate, shipVia);
        return this.update(newOrder);
    }

    public boolean delete(int id) {
        if (id > 0) {
            Order order = new Order(id, 0, 0, null, null, null, 0);
            return this.delete(order);
        } else {
            return false;
        }
    }

    public DefaultTableModel orders() {
        String header[] = {"ID", "Cliente", "Empleado", "Fecha Orden", "Fecha Requerida", "Fecha Envío", "Vía"};
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        Order order = null;
        Order[] ord = this.consult(order);

        if (ord != null) {
            for (Order o1 : ord) {
                try {
                    Object[] obj = new Object[7];
                    obj[0] = o1.getOrderID();
                    obj[1] = o1.getCustomerID();
                    obj[2] = o1.getEmployeeID();
                    obj[3] = o1.getOrderDate();
                    obj[4] = o1.getRequiredDate();
                    obj[5] = o1.getShippedDate();
                    obj[6] = o1.getShipVia();
                    //Rows
                    dtm.addRow(obj);
                } catch (NullPointerException e) {
                    System.out.println("Aqui el error: " + e);
                }
            }
        }
        return dtm;
    }

}//End class
