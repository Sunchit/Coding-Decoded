class Solution {
	// TC: O(len(instructioons))
	// SC: O(1)
	private enum Direction {
		NORTH,
		SOUTH,
		WEST,
		EAST
	}

	public boolean isRobotBounded(String instructions) {
		int x = 0, y = 0;// starting
		Direction direction = Direction.NORTH;

		for (char instruction : instructions.toCharArray()) {
			if (instruction == 'G') {
				switch (direction) {
					case NORTH:
						y++;
						break;
					case SOUTH:
						y--;
						break;
					case WEST:
						x--;
						break;
					case EAST:
						x++;
						break;
				}
			} else if (instruction == 'L') {
				switch (direction) {
					case NORTH:
						direction = Direction.WEST;
						break;
					case SOUTH:
						direction = Direction.EAST;
						break;
					case WEST:
						direction = Direction.SOUTH;
						break;
					case EAST:
						direction = Direction.NORTH;
						break;
				}
			} else if (instruction == 'R') {
				switch (direction) {
					case NORTH:
						direction = Direction.EAST;
						break;
					case SOUTH:
						direction = Direction.WEST;
						break;
					case WEST:
						direction = Direction.NORTH;
						break;
					case EAST:
						direction = Direction.SOUTH;
						break;
				}
			}
		}

		if (x == 0 && y == 0) { return true; }
		if (direction == Direction.NORTH) { return false; }

		return true;
	}

}