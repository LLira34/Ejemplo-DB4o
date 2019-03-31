package dao;

import com.db4o.ObjectSet;
import com.db4o.ext.DatabaseClosedException;
import com.db4o.ext.DatabaseReadOnlyException;
import models.Product;

/**
 *
 * @author LLira
 */
public class ProductDAO extends DAO<Product> {

    public Product[] consultProduct(Product object) {
        try {
            Product[] products = null;
            conn.open();
            ObjectSet resultsProduct = conn.obj.get(object);
            int i = 0;
            if (resultsProduct.hasNext()) {
                products = new Product[resultsProduct.size()];
                while (resultsProduct.hasNext()) {
                    try {
                        products[i] = (Product) resultsProduct.next();
                        i++;
                    } catch (Exception e) {
                        System.out.println("Error aqui: " + e);
                    }
                }
            }
            conn.obj.close();
            return products;
        } catch (DatabaseClosedException | DatabaseReadOnlyException e) {
            System.out.println("Error aqui: " + e);
            return null;
        }
    }

    public boolean update(Product object) {
        try {
            conn.open();
            ObjectSet results = conn.obj.get(new Product(object.getProductID(), null, 0, 0, null, 0.0));
            if (results.size() > 0) {
                Product result = (Product) results.next();
                result.setProductName(object.getProductName());
                result.setSupplierID(object.getSupplierID());
                result.setCategoryID(object.getCategoryID());
                result.setQuantityPerUnit(object.getQuantityPerUnit());
                result.setUnitPrice(object.getUnitPrice());
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

}//End class
