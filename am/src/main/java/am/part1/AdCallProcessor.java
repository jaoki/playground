package am.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AdCallProcessor {

	public PlacementAdMapping[] getAdsForPlacement(int placement_id){
		List<PlacementAdMapping> ads = new ArrayList<PlacementAdMapping>();
		
		PlacementAdMapping[] data = PlacementAdMapping.getData();

		for(PlacementAdMapping item: data){
			if(item.placement_id == placement_id){
				ads.add(item);
			}
		}
		return ads.toArray(new PlacementAdMapping[0]);
	}

	public int chooseAd(int placement_id){
		PlacementAdMapping[] targets = getAdsForPlacement(placement_id);
		if(targets.length == 0){
			throw new RuntimeException("placemnt_id does not exist. TODO this should be an appropriate Exception.");
		}

		int weightTotal = 0;
		for(PlacementAdMapping target : targets){
			weightTotal += target.weight;
		}

		Random random = new Random();
		int winner = random.nextInt(weightTotal);

		for(int i = 0; i < targets.length; i++){
			winner -= targets[i].weight;
			if(winner < 0){
				return targets[i].add_id;
			}
		}

		throw new RuntimeException("ads are not found");

	}


}
