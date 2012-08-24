package am.part1.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import am.part1.AdCallProcessor;

public class AdCallProcessorTest {
	
	private static final float ALLOWANCE = 0.1f;
	
	@Test
	public void testPlacementId1(){
		AdCallProcessor processor = new AdCallProcessor();
		for(int i = 0; i < 100; i++){
			Assert.assertEquals(processor.chooseAd(1), 100);
		}

	}

	private static final float EXPECTED_PLACEMENTID2_ADID100_MAX_PERCENTAGE = (10f/50f) * (1f + ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID2_ADID100_MIN_PERCENTAGE = (10f/50f) * (1f - ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID2_ADID101_MAX_PERCENTAGE = (20f/50f) * (1f + ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID2_ADID101_MIN_PERCENTAGE = (20f/50f) * (1f - ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID2_ADID102_MAX_PERCENTAGE = (20f/50f) * (1f + ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID2_ADID102_MIN_PERCENTAGE = (20f/50f) * (1f - ALLOWANCE);

	@Test
	public void testPlacementId2(){
		AdCallProcessor processor = new AdCallProcessor();
		int countAdId100 = 0;
		int countAdId101 = 0;
		int countAdId102 = 0;
		for(int i = 0; i < 1000; i++){
			int addId = processor.chooseAd(2);

			if(addId == 100){
				countAdId100++;
			}else if(addId == 101){
				countAdId101++;
			}else if(addId  == 102){
				countAdId102++;
			}else{
				Assert.fail("add_id " + addId + "is not expected.");
			}

		}
		
		float percentageAdId100 = countAdId100/1000f;
		float percentageAdId101 = countAdId101/1000f;
		float percentageAdId102 = countAdId102/1000f;

		if(percentageAdId100 > EXPECTED_PLACEMENTID2_ADID100_MAX_PERCENTAGE || percentageAdId100 < EXPECTED_PLACEMENTID2_ADID100_MIN_PERCENTAGE){
			Assert.fail("percentageAdId100 " + percentageAdId100 + " is out of expectation");
		}

		if(percentageAdId101 > EXPECTED_PLACEMENTID2_ADID101_MAX_PERCENTAGE || percentageAdId101 < EXPECTED_PLACEMENTID2_ADID101_MIN_PERCENTAGE){
			Assert.fail("percentageAdId101 " + percentageAdId101 + " is out of expectation");
		}

		if(percentageAdId102 > EXPECTED_PLACEMENTID2_ADID102_MAX_PERCENTAGE || percentageAdId102 < EXPECTED_PLACEMENTID2_ADID102_MIN_PERCENTAGE){
			Assert.fail("percentageAdId102 " + percentageAdId102 + " is out of expectation");
		}

	}

	private static final float EXPECTED_PLACEMENTID3_ADID100_MAX_PERCENTAGE = (15f/20f) * (1f + ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID3_ADID100_MIN_PERCENTAGE = (15f/20f) * (1f - ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID3_ADID103_MAX_PERCENTAGE = (5f/20f) * (1f + ALLOWANCE);
	private static final float EXPECTED_PLACEMENTID3_ADID103_MIN_PERCENTAGE = (5f/20f) * (1f - ALLOWANCE);

	@Test
	public void testPlacementId3(){
		AdCallProcessor processor = new AdCallProcessor();
		int countAdId100 = 0;
		int countAdId103 = 0;
		for(int i = 0; i < 1000; i++){
			int addId = processor.chooseAd(3);

			if(addId == 100){
				countAdId100++;
			}else if(addId  == 103){
				countAdId103++;
			}else{
				Assert.fail("add_id " + addId + "is not expected.");
			}

		}
		
		float percentageAdId100 = countAdId100/1000f;
		float percentageAdId103 = countAdId103/1000f;

		if(percentageAdId100 > EXPECTED_PLACEMENTID3_ADID100_MAX_PERCENTAGE || percentageAdId100 < EXPECTED_PLACEMENTID3_ADID100_MIN_PERCENTAGE){
			Assert.fail("percentageAdId100 " + percentageAdId100 + " is out of expectation");
		}

		if(percentageAdId103 > EXPECTED_PLACEMENTID3_ADID103_MAX_PERCENTAGE || percentageAdId103 < EXPECTED_PLACEMENTID3_ADID103_MIN_PERCENTAGE){
			Assert.fail("percentageAdId102 " + percentageAdId103 + " is out of expectation");
		}

	}

}
