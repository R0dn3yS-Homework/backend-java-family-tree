import java.util.ArrayList;
import java.util.List;

public class Person {
  private String name;
  private String middleName;
  private String lastName;
  private String sex;
  private int age;
  private Person mother;
  private Person father;
  private final List<Person> siblings = new ArrayList<Person>();
  private final List<Person> children = new ArrayList<Person>();
  private final List<Pet> pets = new ArrayList<Pet>();

  public Person(String name, String lastName, int age, String sex) {
    this.name = name;
    this.lastName = lastName;
    this.age = age;
    this.sex = sex;

  }

  public Person(String name, String middleName, String lastName, int age, String sex) {
    this.name = name;
    this.middleName = middleName;
    this.lastName = lastName;
    this.age = age;
    this.sex = sex;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void setMiddleName(String middleName) {
    this.middleName = middleName;
  }

  public String getMiddleName() {
    return this.middleName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSex() {
    return this.sex;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public int getAge() {
    return this.age;
  }

  public void setMother(Person mother) {
    this.mother = mother;
  }

  public Person getMother() {
    return this.mother;
  }

  public void setFather(Person father) {
    this.father = father;
  }

  public Person getFather() {
    return this.father;
  }

  public void addParents(Person mother, Person father) {
    this.mother = mother;
    this.father = father;
  }

  public void addChild(Person child) {
    if (childUniqueName(child)) {
      children.add(child);
    }
  }

  public List<Person> getChildren() {
    return children;
  }

  public void addPet(Pet pet) {
    if (petUniqueName(pet)) {
      pets.add(pet);
    }
  }

  public List<Pet> getPets() {
    return pets;
  }

  public void addSibling(Person sibling) {
    if (siblingUniqueName(sibling)) {
      siblings.add(sibling);
    }
  }

  public List<Person> getSiblings() {
    return siblings;
  }

  public List<Person> getGrandChildren() {
    List<Person> grandChildren = new ArrayList<Person>();

    for (Person child : getChildren()) {
      grandChildren.addAll(child.getChildren());
    }

    return grandChildren;
  }

  public List<Pet> getGrandChildrenPets() {
    List<Pet> grandPets = new ArrayList<Pet>();

    for (Person grandChild : getGrandChildren()) {
      grandPets.addAll(grandChild.getPets());
    }

    return grandPets;
  }

  public List<Person> getNieces() {
    List<Person> nieces = new ArrayList<Person>();

    for (Person sibling : getSiblings()) {
      for (Person child : sibling.getChildren()) {
        if (child.getSex().equalsIgnoreCase("female")) {
          nieces.add(child);
        }
      }
    }

    return nieces;
  }

  // Private methods
  private boolean childUniqueName(Person child) {
    if (children.isEmpty()) {
      return true;
    }

    for (Person person : children) {
      if (person.getName().equalsIgnoreCase(child.getName())) {
        return false;
      }
    }

    return true;
  }

  private boolean petUniqueName(Pet newPet) {
    if (pets.isEmpty()) {
      return true;
    }

    for (Pet pet : pets) {
      if (pet.getName().equalsIgnoreCase(newPet.getName())) {
        return false;
      }
    }

    return true;
  }

  private boolean siblingUniqueName(Person sibling) {
    if (siblings.isEmpty()) {
      return true;
    }

    for (Person person : children) {
      if (person.getName().equalsIgnoreCase(sibling.getName())) {
        return false;
      }
    }

    return true;
  }
}
