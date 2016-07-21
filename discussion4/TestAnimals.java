/**
 * Created by CYS on 2016/7/21.
 */
public class TestAnimals {
    public static void main(String[] args){
        Animal a = new Animal("Pluto", 10);
        Cat c = new Cat("Garfield", 6);
        Dog d = new Dog("Fido", 4);

        a.greet();
        c.greet();
        d.greet();

        a = c;
        a.greet();//Cat Garfield says: Meow!
        ((Cat) a).greet();//Cat Garfield says: Meow!

        a = new Dog("Spot", 10);
        d = (Dog) a;
        d.greet();//Dog Spot says: Woof!
    }
}
