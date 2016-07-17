# CS61B: Code and Notes

Code for cs61b, both skeleton and implementations. Besides, notes and solutions to some problems are recorded.

## Notes 

### lec9

**Constructors are not inherited.** However, the rules of Java say that all subclass constructors must start with a call to a constructor for the super class. If not, then VengefulSList's sentinel would be null, which is bad.

```java
// These constructors are exactly equivalent.
// Given VengefulSList extends SList, which stores items deleted.

public VengefulSList(){
	deletedItems = new SList<Item>();
}

public VengefulSList(){
	super();
	deletedItems = new SList<Item>();
}
```

**Implementation Inheritance Breaks Encapsulation**. Uses following example to show that.

Consider a dog.

```java
class Dog{
	public void bark() {
	   System.out.println("bark");
	} 
	public void barkMany(int N) {
	   	for (int i = 0; i < N; i += 1) {
	      	bark();  
	   	}
	}
}
```

However, a dog can also implement its bark as a special case of barkMany.

```java
class Dog{
	public void bark() {
	   barkMany(1);
	}
	public void barkMany(int N) {
	   	for (int i = 0; i < N; i += 1) {
	      	System.out.println("bark");  
	   	}
	}
}
```

If class `verboseDog` inherits `Dog`, we see how problems appear.

```java
class verboseDog extends Dog{
	@Override
	public void barkMany(int N) {
	    System.out.println("As a dog, I say: ");
		for (int i = 0; i < N; i += 1) {
	       	bark();
		}
	}
}

public static void main(String[] args){
	verboseDog vb = new verboseDog();
	vb.barkMany(3);
}
```

If `Dog` class is actually implemented in the 2nd way, then bug comes. It prints "As a dog, I say: " and never ends.