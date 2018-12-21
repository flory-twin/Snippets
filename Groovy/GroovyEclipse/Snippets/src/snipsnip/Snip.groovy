package snipsnip

class Snip {
	//Should be able to declare @PackageScope!
	String stringit
	//Note that Groovy will automatically set the following up as a private field with getters and setters; one can manually override the getter and/or the setter and/or neither. 
	def numb = 5

	//For beans with only a default constructor, and with fields as noted above, Groovy also provides a syntax which is the same as calling the default constructor followed by the setters:
	//For example, if Server has member fields 'name' and 'cluster' and a default or 0-parameter constructor, then the following is valid:
	//def server = new Server(name: "Obelix", cluster: aCluster)
	//However, Groovy also provides .with({Closure}) and .tap({Closure}) on all objects.
	// .with causes all statements in the closure to be prefixed with the object .with is called on, so the following code produces equivalent results:
	//def server = new Server().with
	//{
	//	name="Obelix"
	//	cluster=aCluster
	//	it
	//}
	// .tap causes the return of the closure's it to be implicit, so the code is further equivalent to:
	//def server = new Server().tap
	//{
	//	name="Obelix"
	//	cluster=aCluster
	//}
	
	//In Groovy, to compare references, use .is().  == means value comparison (like Java's .equals(), but with added protection against null pointers on either side of the comparison.)

	//String interpolation is eager if a variable is specified directly.
	//However, something like "Variable a is ${-> a}" is bound only at evaluation time:
	//def a = 3
	//String b = "Variable a is $a" //Eagerly evaluated
	//String c = "Variable a is ${-> a}" //Lazily evaluated
	//a++
	//println b //Prints "Variable a is 3".
	//println c //Prints "Variable a is 4".
	
	
	//{ [closureParameters -> ] statements }
	Closure aClosure = { int c, int d -> c + d }
	 
	//Every function is public by default
	int func(int one, int two)
	{
		//Something else...
		//At the top level, parentheses are not required on methods which are not called as class members
		//So println(one) can be written...
		println one
		//But this WON'T work--nested calls must include parens, and parseInt is called as a member of Integer
		//println Integer.parseInt "one"
		//And this  
		//Last statement executed returns
		one + two
	}
	
	int otherFunc(Closure c)
	{
		c.call()
	}
}
