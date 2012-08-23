package am;


public class Data {
	public static final PlacementAdMapping[]  data;
	static{
		data = new PlacementAdMapping[6];
		data[0] = new PlacementAdMapping(1, 100, 10);
		data[1] = new PlacementAdMapping(2, 100, 10);
		data[2] = new PlacementAdMapping(2, 101, 20);
		data[3] = new PlacementAdMapping(2, 102, 20);
		data[4] = new PlacementAdMapping(3, 100, 15);
		data[5] = new PlacementAdMapping(3, 103, 5);
	}

	public static class PlacementAdMapping{

		// Omit getters and setters
		public int placement_id;
		public int add_id;
		public int weight;

		public PlacementAdMapping(int placement_id, int add_id, int weight) {
			this.placement_id = placement_id;
			this.add_id = add_id;
			this.weight = weight;
		}

	}

}
