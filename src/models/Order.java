package models;

/**
 *
 * @author LLira
 */
public class Order {

    private int orderID;
    private int customerID;
    private int employeeID;
    private String orderDate;
    private String requiredDate;
    private String shippedDate;
    private int shipVia;

    public Order(
            int orderID, int customerID, int employeeID, String orderDate, String requiredDate, String shippedDate, int shipVia) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.employeeID = employeeID;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.shipVia = shipVia;
    }

    public Order() {
        this.orderID = 0;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(String requiredDate) {
        this.requiredDate = requiredDate;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public int getShipVia() {
        return shipVia;
    }

    public void setShipVia(int shipVia) {
        this.shipVia = shipVia;
    }

    @Override
    public String toString() {
        //return "Order{" + "orderID=" + orderID + '}';
        return "" + orderID;
    }

}//End class
