package am.part1.test;

import junit.framework.Assert;

import org.testng.annotations.Test;

import am.part2.DomainManager;

public class DomainManagerTest {
	
	
	@Test
	public void test(){
		DomainManager manager = new DomainManager("src/test/resources/domain_classifications.txt");

		String[] categories = manager.lookupCategories("yahoo.com");
		Assert.assertEquals("sports", categories[0]);
		Assert.assertEquals("news", categories[1]);
		Assert.assertEquals("finance", categories[2]);
		Assert.assertEquals("portal", categories[3]);
		Assert.assertEquals("mail", categories[4]);

		categories = manager.lookupCategories("google.com");
		Assert.assertEquals("search", categories[0]);
		Assert.assertEquals("mobile", categories[1]);
		Assert.assertEquals("mail", categories[2]);

	}

}
