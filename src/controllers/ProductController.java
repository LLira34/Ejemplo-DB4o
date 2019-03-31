package controllers;

import dao.ProductDAO;
import javax.swing.table.DefaultTableModel;
import models.Product;

/**
 *
 * @author LLira
 */
public class ProductController extends ProductDAO {

    public ProductController() {
    }

    public boolean save(int productID, String productName, int supplierID, int categoryID, String quantityPerUnit, double unitPrice) {
        Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice);
        return this.save(product);
    }

    public boolean update(int productID, String productName, int supplierID, int categoryID, String quantityPerUnit, double unitPrice) {
        Product product = new Product(productID, productName, supplierID, categoryID, quantityPerUnit, unitPrice);
        return this.update(product);
    }

    public boolean delete(int id) {
        if (id > 0) {
            Product product = new Product(id, null, 0, 0, null, 0.0);
            return this.delete(product);
        } else {
            return false;
        }
    }

    public DefaultTableModel products() {
        String header[] = {"ID", "Nombre", "Proveedor", "Categoria", "Cantida/Unidad", "Precio"};
        DefaultTableModel dtm = new DefaultTableModel(null, header);
        Product product = null;
        Product[] pro = this.consultProduct(product);

        if (pro != null) {
            for (Product p1 : pro) {
                try {
                    Object[] obj = new Object[6];
                    obj[0] = p1.getProductID();
                    obj[1] = p1.getProductName();
                    obj[2] = p1.getSupplierID();
                    obj[3] = p1.getCategoryID();
                    obj[4] = p1.getQuantityPerUnit();
                    obj[5] = p1.getUnitPrice();
                    dtm.addRow(obj);
                } catch (NullPointerException e) {
                    System.out.println("Aqui el error: " + e);
                }
            }
        }
        return dtm;
    }

}//End class
