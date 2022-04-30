package digitaltech;

import java.util.HashMap;
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

    public void saveProduct(Product product) {
        if(!this.findProduct(product.getCategory(), product.getId())) {
            this.map.get(product.getCategory()).add(product);
        } else {
            throw new IllegalArgumentException("\nImpossivel registrar: Este produto ja esta registrado!");
        }

    }

    public void removeProduct(Product product) {
        if(this.findProduct(product.getCategory(), product.getId())) {
            this.map.get(product.getCategory()).remove(product);
        } else {
            throw new IllegalArgumentException("Produto nao encontrado");
        }
    }

    public void editProduct(Product product, String newCategory, String newBrand, int newId, float newPrice) {
        if(this.findProduct(product.getCategory(), product.getId())) {
            this.removeProduct(product);
            Product newProduct = new Product(newCategory, newBrand, newId, newPrice);
            this.map.get(newCategory).add(newProduct);
        } else {
            throw new IllegalArgumentException("Produto nao encontrado");
        }
    }

    public boolean findProduct(String category, int id) {
        boolean found = false;
        for(int index = 0; index < map.get(category).size(); index ++) {
            if(map.get(category).get(index).getId() == id) {
                found = true;
                break;
            }
        }
        return found;
    }

}
