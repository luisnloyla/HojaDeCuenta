/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HojaDeCuenta;

/**
 *
 * @author luis
 */
public class AutoCompletar {
    private String name;
    private int age;
 
    public AutoCompletar(String name, int age) {
        this.name = name;
        this.age = age;
    }
 
    public String getName() {
        return name;
    }
 
    public int getAge() {
        return age;
    }
 
    @Override
    public String toString() {
        return this.name;
    }

}
