import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

  @Test
  void testAddParents() {
    Person p = new Person("John", "Deere", 25, "Male");

    Person father = new Person("Klaas", "Deere", 50, "Male");
    Person mother = new Person("Karen", "Deere", 50, "Female");

    p.addParents(mother, father);

    assertEquals(mother, p.getMother());
    assertEquals(father, p.getFather());
  }

  @Test
  void testAddChild() {
    Person p = new Person("John", "Deere", 25, "Male");

    Person child = new Person("Klaas", "Deere", 12, "Male");

    p.addChild(child);

    assertEquals(1, p.getChildren().size());
  }

  @Test
  void testAddPet() {
    Person p = new Person("John", "Deere", 25, "Male");

    Pet pet = new Pet("Klaas", 2, "Dog");

    p.addPet(pet);

    assertEquals(1, p.getPets().size());
  }

  @Test
  void testAddSibling() {
    Person p = new Person("John", "Deere", 25, "Male");

    Person sibling = new Person("Klaas", "Deere", 23, "Male");

    p.addSibling(sibling);

    assertEquals(1, p.getSiblings().size());
  }

  @Test
  void testGetGrandChildren() {
    Person grandFather = new Person("John", "Deere", 60, "Male");
    Person father = new Person("Kees", "Deere", 25, "Male");
    Person child = new Person("Joris", "Deere", 12, "Male");

    father.addChild(child);

    grandFather.addChild(father);

    assertEquals(1, grandFather.getGrandChildren().size());
  }

  @Test
  void testGetGrandChildrenPets() {
    Person grandFather = new Person("John", "Deere", 60, "Male");
    Person father = new Person("Kees", "Deere", 25, "Male");
    Person child = new Person("Joris", "Deere", 12, "Male");

    Pet pet1 = new Pet("Hond", 2, "Dog");

    father.addChild(child);

    child.addPet(pet1);

    grandFather.addChild(father);

    assertEquals(1, grandFather.getGrandChildrenPets().size());
  }

  @Test
  void testGetNieces() {
    Person p = new Person("John", "Deere", 25, "Male");
    Person sibling = new Person("Klaas", "Deere", 25, "Male");

    Person nephew = new Person("Kees", "Deere", 12, "Male");
    Person niece = new Person("Karen", "Deere", 12, "Female");

    sibling.addChild(nephew);
    sibling.addChild(niece);

    p.addSibling(sibling);

    assertEquals(1, p.getNieces().size());
  }
}