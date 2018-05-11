package com.company;

import java.io.*;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
        byte[] intermediate = null;
        try (ByteArrayOutputStream output = new ByteArrayOutputStream();
             ObjectOutputStream oos = new ObjectOutputStream(output)
        ) {
            oos.writeInt(3);
            oos.writeObject(new Animal("Dog"));
            oos.writeObject(new Animal("Cat"));
            oos.writeObject(new Animal("Mouse"));

            output.flush();
            intermediate = output.toByteArray();

        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(Arrays.toString(intermediate));
        Animal[] animals = deserializeAnimalArray(intermediate);
        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].name);
        }
//        System.out.println(Arrays.toString(animals));
    }

    public static Animal[] deserializeAnimalArray(byte[] data) {
        try (ByteArrayInputStream input = new ByteArrayInputStream(data);
             ObjectInputStream ois = new ObjectInputStream(input)
        ) {
            int number = ois.readInt();
            Animal[] animals = new Animal[number];
            for (int i = 0; i < number; i++) {
                animals[i] = (Animal) ois.readObject();
            }

            return animals;
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}

class Animal implements Serializable {
    public final String name;

    public Animal(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Animal) {
            return Objects.equals(name, ((Animal) obj).name);
        }
        return false;
    }
}