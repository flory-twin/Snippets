package snipsnip

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.anyOf;
import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.CoreMatchers.is;

class StyleConventionsTest {
	//Used with one of the following tests
	int aMemberFunctionWithClosure(int c, Closure d)
	{
		d.call()
	}
	//Used with one of the following tests
	int anotherMemberFunctionWithClosure(Closure e)
	{
		e.call()
	}
	
	@Test
	void testGStringLines()
	{
		def A = "A rose" + 
				" is a rose" +
				" is a rose."
		def B = 
"A rose\
 is a rose\
 is a rose."
		assertThat("\\ allows entry of strings on multiple lines.",
			A,
			equalTo(B))
		
		def newline = "\n"
		def D = "A rose" + newline +
				" is a rose" + newline +
				" is a rose."
		def E = """A rose
 is a rose
 is a rose."""
		assertThat("Using \"\"\" allows direct entry of multiline strings.",
			D,
			equalTo(E))

		def F = """A rose
					 is a rose
					 is a rose.""".stripIndent()
		assertThat("Using \"\"\" allows direct entry of multiline strings; using it with .stripIndent() allows those strings to be directly indented like other code.",
			D,
			equalTo(E))
	}
	
	@Test
	void testClassesAreFirstClassCitizens()
	{
		assertThat("Classes are first-class citizens; this means that a class object may be directly obtained from a type.",
			Object.class,
			equalTo(Object))
	}
	
	@Test
	void testClosureCallMethods()
	{
		//When calling a function where the last argument is a closure, the closure can be given outside the parentheses.
		//Including return as a personal style decision...
		def resultA = this.aMemberFunctionWithClosure(3, {return 2})
		def resultB = this.aMemberFunctionWithClosure(3) {return 2}
		//If no other arguments are present, no parentheses are needed at all.
		def resultC = this.anotherMemberFunctionWithClosure { return 2 }
		assertThat("""When calling a function where the last argument is a closure, the closure can be given outside the parentheses.
						If no other arguments are present, no parentheses are needed at all.""".stripIndent(),
						resultA,
						is(anyOf(equalTo(resultB), equalTo(resultC))))
	}
}
