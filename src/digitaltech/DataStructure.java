package digitaltech;

import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class DataStructure {
    private ArrayList<Product> computerList;
    private ArrayList<Product> phoneList;
    private ArrayList<Product> tvList;
    private HashMap<String, ArrayList<Product>> map;

    public final String NOT_FOUND = "Produto nao encontrado";

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
            throw new IllegalArgumentException(NOT_FOUND);
        }
    }

    public void modifyCategory(String oldCategory, int id, String newCategory) {
        if(this.containsProduct(oldCategory, id)) {
            Product newProduct = new Product(newCategory, this.getProduct(oldCategory, id).getBrand(), id, this.getProduct(oldCategory, id).getPrice());
            this.removeProduct(this.getProduct(oldCategory, id));
            this.saveProduct(newProduct);
        } else {
            throw new IllegalArgumentException(NOT_FOUND);
        }
    }

    public void modifyBrand(String category, int id, String newBrand) {
        if(this.containsProduct(category, id)) {
           this.getProduct(category, id).setBrand(newBrand);      
        } else {
            throw new IllegalArgumentException(NOT_FOUND);
        }
    }

    public void modifyId(String category, int id, int newId) {
        if(this.containsProduct(category, id)) {
           this.getProduct(category, id).setId(newId);      
        } else {
            throw new IllegalArgumentException(NOT_FOUND);
        }
    }

    public void modifyPrice(String category, int id, float newPrice) {
        if(this.containsProduct(category, id)) {
           this.getProduct(category, id).setPrice(newPrice);      
        } else {
            throw new IllegalArgumentException(NOT_FOUND);
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
