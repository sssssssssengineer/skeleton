# CS61B: Code and Notes

## Introduction

Code for cs61b, both skeleton and implementations. Besides, notes and solutions to some problems are recorded.

## Settings

### alias: `subl` and `md`

To avoid typing in `Git Bash` each time I run it the following 2 lines:

```
alias subl='"C:\Program Files\Sublime Text 2\sublime_text.exe" $@'
```

I follow instruction [Setting up Sublime](https://www.udacity.com/wiki/ud775/sublime), create a `.bashrc` at `C:\Users\CYS` with following content. Remember to put `\` before any `Space`, `(` and `)`.

```
alias subl="C:/Program\ Files/Sublime\ Text\ 2/sublime_text.exe"
```

### Markdown Editor

I follow instruction [here](http://www.cnblogs.com/IPrograming/p/Sublime-markdown-editor.html), use `Sublime Text` as my Markdown editor. For more detail, view [here](http://m.blog.csdn.net/article/details?id=51235792).

Attaching pictures into Markdown is what I concern. First, I follow instruction [here](https://www.tekrevue.com/tip/how-to-take-and-manage-screenshots-in-windows-8/), make screenshots restored in `pics/`. Second, follow instruction [here](http://stackoverflow.com/questions/10189356/how-to-add-screenshot-to-readmes-in-github-repository) to set relative link for pictures accessing. The result can only be viewed via Github, as relative link is only supported by Github instead of plugins for `Sublime Text`.


## Notes 

### lec9: Extends, Casting, Higher Order Functions

**Constructors are not inherited.** However, the rules of Java say that all subclass constructors must start with a call to a constructor for the super class. If not, then `VengefulSList`'s `sentinel` would be null, which is bad.

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


----------


**Implementation Inheritance Breaks Encapsulation**. Uses following example to show that. Consider a dog.

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

However, a dog can also implement its `bark` as a special case of `barkMany`.

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


----------


**Compile-time type and Runtime type**. Even though `sl` "points to" `VengefulSList` object, that its runtime type is `VengefulSList`, `sl` is declared as `SList` variable, that its compile-time type (static type) is `SList`.

![lec9page25](pics/lec9page25.png)
