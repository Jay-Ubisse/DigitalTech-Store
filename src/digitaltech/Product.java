package digitaltech;
/**
 * Neste classe serão registadas as informacoes de cada
 * produto. A classe contém ainda métodos para actualização
 * dos dados de cada produto como também métodos para a
 * visualização dos dados.
 * 
 * @author Jay Ubisse
 * @version 1.0.0
 */

 public class Product {
    private String category;
    private String brand;
    private int id;
    private float price;
    
    public Product (String category, String brand, int id, float price) {
        this.category = category;
        this.brand = brand;
        this.id = id;
        this.price = price;
    }

    public String toString() {
        return "Categoria: " + this.category + "\nMarca: " + this.brand + "\nNumero de serie: " + this.id + "\nPreco: " + this.price;
    }

    public String getCategory() {
        return this.category;
    }

    public String getBrand() {
        return this.brand;
    }

    public int getId() {
        return this.id;
    }

    public float getPrice() {
        return this.price;
    }

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public void setId(int newId) {
        this.id = newId;
    }

    public void setPrice(float newPrice) {
        this.price = newPrice;
    }

    public boolean verifyId(int id) {
        return (this.id == id);
    }
 }
