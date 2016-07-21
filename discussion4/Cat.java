/**
 * Created by CYS on 2016/7/21.
 */
public class Cat extends Animal {
    public Cat(String name, int age){
        super(name, age);
        this.noise = "Meow!";
    }

    @Override
    public void greet(){
        System.out.println("Cat " + name + " says: " + makeNoise());
    }

    public static void main(String[] args){
        Cat Kitty = new Cat("Kitty", 5);
        Kitty.greet();
    }
}
