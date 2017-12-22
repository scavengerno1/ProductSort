class Product{

  private long id;
  private String brand;
  private String name;
  private int price;

  /****************
  * Object filler *
  *****************/
  public Product(long id, String brand, String name, int price){
    this.id = id;
    this.brand = brand;
    this.name = name;
    this.price = price;
  }

  /**********************
  * Getters and Setters *
  ***********************/
  public long getID(){
    return id;
  }

  public void setID(){
    this.id = id;
  }

  public String getBrand(){
    return brand;
  }

  public void setBrand(){
    this.brand = brand;
  }

  public String getName(){
    return name;
  }

  public void setName(){
    this.name = name;
  }

  public long getPrice(){
    return price;
  }

  public void setPrice(){
    this.price = price;
  }

  /************************
  * Method to print array *
  *************************/
  public String toString(){
    return id + "\t" + brand + "\t" + name + "\t" + price;
  }

}
