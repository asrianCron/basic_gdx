package com.mygdx.game;

public class GOL {
	public static void main(){

			public static void main(String[] args) {
				int size = 30;
				int[][] grid = new int[size][size];

				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[i].length; j++) {
						grid[i][j] = randInt(0, 1);
					}
				}
				print(grid);
				
				while(true){
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println();
					grid = check(grid);
					print(grid);
				}
			}

			public static int[][] check(int[][] grid) {
				int[][] changes = new int[grid.length][grid[0].length];
				for (int i = 1; i < grid.length - 1; i++) {
					for (int j = 1; j < grid[i].length - 1; j++) {
						int sumNeighbours = 0;

						sumNeighbours += grid[i][j + 1];
						sumNeighbours += grid[i + 1][j + 1];
						sumNeighbours += grid[i + 1][j];

						sumNeighbours += grid[i][j - 1];
						sumNeighbours += grid[i + 1][j - 1];
						sumNeighbours += grid[i - 1][j + 1];
						sumNeighbours += grid[i - 1][j - 1];

						sumNeighbours += grid[i - 1][j];

						if (sumNeighbours == 3) {
							changes[i][j] = 1;
						} else if (sumNeighbours > 3 || sumNeighbours < 2) {
							changes[i][j] = 0;
						}

					}

				}
				return changes;

			}

			public static void change(int[][] origGrid, int[][] changedGrid) {

			}

			public static void print(int[][] grid) {
				System.out.println("///////////");
				for (int i = 0; i < grid.length; i++) {
					for (int j = 0; j < grid[i].length; j++) {
						
						if(grid[i][j] == 1){
							System.out.print("*");
						} else {
							System.out.print("  ");
						}
						
//						System.out.print(grid[i][j] + " ");
					}
					System.out.println();
				}
			}

			public static int randInt(int min, int max) {
				return (int) Math.round(Math.random() * (max - min) + min);
			}

		}

	}
}
