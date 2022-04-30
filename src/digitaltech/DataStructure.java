package digitaltech;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DataStructure {
    private ArrayList<Product> computerList;
    private ArrayList<Product> phoneList;
    private ArrayList<Product> tvList;
    private HashMap<String, ArrayList<Product>> map;

    public DataStructure() {
        this.phoneList =  new ArrayList<>();
        this.computerList =  new ArrayList<>();
        this.tvList =  new ArrayList<>();
        this.map = new HashMap<>();
        this.map.put("computador", computerList);
        this.map.put("celular", phoneList);
        this.map.put("tv", tvList);
    }

    public List<Product> getComputerList() {
        return this.computerList;
    }

    public List<Product> getPhoneList() {
        return this.phoneList;
    }

    public List<Product> getTvList() {
        return this.tvList;
    }
    

    public void saveProduct(Product product) {
        if(!this.containsProduct(product.getCategory(), product.getId())) {
            this.map.get(product.getCategory()).add(product);
        } else {
            throw new IllegalArgumentException("\nImpossivel registrar: Este produto ja esta registrado!");
        }

    }

    public void removeProduct(Product product) {
        if(this.containsProduct(product.getCategory(), product.getId())) {
            this.map.get(product.getCategory()).remove(product);
        } else {
            throw new IllegalArgumentException("Produto nao encontrado");
        }
    }

    public void editProduct(String oldCategory, int oldId, String newCategory, String newBrand, int newId, float newPrice) {
        if(this.containsProduct(oldCategory, oldId)) {
            this.removeProduct(getProduct(oldCategory, oldId));
            Product newProduct = new Product(newCategory, newBrand, newId, newPrice);
            this.map.get(newCategory).add(newProduct);
        } else {
            throw new IllegalArgumentException("Produto nao encontrado");
        }
    }

    public boolean containsProduct(String category, int id) {
        boolean found = false;
        for(int index = 0; index < map.get(category).size(); index ++) {
            if(map.get(category).get(index).getId() == id) {
                found = true;
                break;
            }
        }
        return found;
    }

    public Product getProduct(String category, int id) {
        for(int index = 0; index < map.get(category).size(); index ++) {
            if(map.get(category).get(index).getId() == id) {
                return map.get(category).get(index);
            }
        }
        return null;
    }

}
