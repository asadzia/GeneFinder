/**
 * The class which finds a a valid Gene in a protein structure.
 * @author Asad Zia
 *
 */

public class GeneProcessor {
	final static String start_codon = "ATG";
	final static String stop_codon_one = "TAG";
	final static String stop_codon_two = "TGA";
	final static String stop_codon_three = "TAA";
	
	/**
	 * The function which process a DNA structure to find a Gene.
	 * @param strand
	 * @return string
	 */
	public static String CheckDNA (String strand)
	{
		String myProtein = strand.toUpperCase();
			int check = myProtein.indexOf(start_codon);
			
			if (check != -1)
			{
				/* find the occurence of the TAG codon*/
				int check_two = myProtein.indexOf(stop_codon_one, check + 3);
				while (check_two > 0)
				{
					if ((check_two - check) % 3 == 0)
					{
						return myProtein.substring(check, check_two + 3);
					}
					else
					{
						check_two = myProtein.indexOf(stop_codon_one, check_two + 3);
					}
				}
				
				/* find the occurence of the TGA codon */
				int check_three = myProtein.indexOf(stop_codon_two, check + 3);
				while (check_three > 0)
				{
					if ((check_three - check) % 3 == 0)
					{
						return myProtein.substring(check, check_three + 3);
					}
					else
					{
						check_three = myProtein.indexOf(stop_codon_one, check_three + 3);
					}
				}
				
				/* finding the TAA codon */
				int check_four = myProtein.indexOf(stop_codon_three, check + 3);
				while (check_four > 0)
				{
					if ((check_four - check) % 3 == 0)
					{
						return myProtein.substring(check, check_four + 3);
					}
					else
					{
						check_four = myProtein.indexOf(stop_codon_one, check_four + 3);
					}
				}
				
			}
			else
			{
				return "No Gene Found!";
			}
		return "No Gene Found!";
	}
		
	/**
	 * The main driver function.
	 * @param args
	 */
	/*public static void main (String [] args)
	{
		DNA myDNA_one = new DNA();
		myDNA_one.setStructure("AATGCTAGTTTAAATCTGA");
		System.out.println("Test One: " + GeneProcessor.CheckDNA(myDNA_one));
		
		DNA myDNA_two = new DNA();
		myDNA_two.setStructure("ataaactatgttttaaatgt");
		System.out.println("Test Two: " + GeneProcessor.CheckDNA(myDNA_two));
		
		DNA myDNA_three = new DNA();
		myDNA_three.setStructure("acatgataacctaag");
		System.out.println("Test Three: " + GeneProcessor.CheckDNA(myDNA_three));
	}*/
}
