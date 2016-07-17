# skeleton
Code for cs61b, both skeleton and implementations. Besides, notes and solutions to some problems are recorded.

## Notes 

### lec9
Constructors are not inherited. However, the rules of Java say that all subclass constructors must start with a call to a constructor for the super class.
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

