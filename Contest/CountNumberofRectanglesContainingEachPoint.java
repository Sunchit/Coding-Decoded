class Solution {
	public int[] countRectangles(int[][] rectangles, int[][] points) {
		int[] res = new int[points.length];
		// Create a map
		List<List<Integer>> map = new ArrayList<>(101);
		// add all the reactangle that ends at a particular height
		for(int i = 0; i < 101; i++){
			map.add(new ArrayList<>());
		}

		for(int[] rec : rectangles){
			int l = rec[0];
			int h = rec[1];
			map.get(h).add(l);
		}
		// sort the x coordinates for each height
		for(int i = 0; i < 101; i++){
			Collections.sort(map.get(i));
		}

		for(int i = 0; i < points.length; i++){
			int count = 0;
			int x = points[i][0];
			int y = points[i][1];

			for(int j = y; j < 101; j++){
				List<Integer> rectanglesEndingAtHeightJ = map.get(j);
				int index = binarySearch(rectanglesEndingAtHeightJ, x);
				count += rectanglesEndingAtHeightJ.size() - index;
			}

			res[i] = count;
		}

		return res;
	}

	private int binarySearch(List<Integer> list, int x){
		int left = 0;
		int right = list.size();
		while(left < right){
			int mid = left + (right - left) / 2;
			if(list.get(mid) >= x){
				right = mid;
			} else{
				left = mid + 1;
			}
		}
		return left;
	}
}
