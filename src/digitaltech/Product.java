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
    private short id;
    
    public Product (String category, String brand, short id) {
        this.category = category;
        this.brand = brand;
        this.id = id;
    }

    public String toString() {
        return "Categoria: " + this.category + "Marca: " + this.brand + "Numero de serie: " + this.id;
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

    public void setCategory(String newCategory) {
        this.category = newCategory;
    }

    public void setBrand(String newBrand) {
        this.brand = newBrand;
    }

    public void setId(short newId) {
        this.id = newId;
    }
 }
