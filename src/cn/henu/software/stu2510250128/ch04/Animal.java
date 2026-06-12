package cn.henu.software.stu2510250128.ch04;

public class Animal {
    private String name;
    private int age;
    private String species;
    private String habitat;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("age不能小于0，已重置为0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getHabitat() {
        return habitat;
    }

    public void setHabitat(String habitat) {
        this.habitat = habitat;
    }

    public void makeSound() {
        System.out.println("The [" + species + "] makes a sound.");
    }

    public void displayInfo() {
        System.out.println(this.getName() + '\n' + this.getAge() + '\n' +
                this.getSpecies() + '\n' + this.getHabitat());
    }

    public void eat() {
        System.out.println("The " + species + " is eating");
    }

    public Animal(String name, int age, String species, String habitat) {
        this.setName(name);
        this.setAge(age);
        this.setSpecies(species);
        this.setHabitat(habitat);

    }


}
