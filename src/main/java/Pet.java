public class Pet {
  private String name;
  private int age;
  private String species;
  private Person owner;

  public Pet(String name, int age, String species) {
    this.name = name;
    this.age = age;
    this.species = species;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setSpecies(String species) {
    this.species = species;
  }

  public String getSpecies() {
    return this.species;
  }

  public void setOwner(Person owner) {
    this.owner = owner;
  }

  public Person getOwner() {
    return this.owner;
  }
}
