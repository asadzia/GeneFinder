/**
 * A JUnit test case class.
 * @author Asad Zia
 * @Version 1.0
 */

import junit.framework.Assert;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

@SuppressWarnings("deprecation")
public class GeneTest extends TestCase {
	private DNA myDNA_one;
	private DNA myDNA_two;
	private DNA myDNA_three;
	
	protected void setUp()
	{
		myDNA_one = new DNA();
		myDNA_one.setStructure("AATGCTAGTTTAAATCTGA");
		
		myDNA_two = new DNA();
		myDNA_two.setStructure("ataaactatgttttaaatgt");
		
		myDNA_three = new DNA();
		myDNA_three.setStructure("acatgataacctaag");
	}
	
	public void testCheckDNA()
	{
		String Expected_one = "ATGCTAGTTTAAATCTGA";
		String Expected_two = "ATGTTTTAA";
		String Expected_three = "";
		
		String Result_one = GeneProcessor.CheckDNA(myDNA_one.getStructure());
		String Result_two = GeneProcessor.CheckDNA(myDNA_two.getStructure());
		String Result_three = GeneProcessor.CheckDNA(myDNA_three.getStructure());
		
		Assert.assertTrue(Expected_one.equals(Result_one));
		Assert.assertTrue(Expected_two.equals(Result_two));
		Assert.assertTrue(Expected_three.equals(Result_three));
	}
	
	public static Test suite() {
		return new TestSuite(GeneTest.class);
	}
}
