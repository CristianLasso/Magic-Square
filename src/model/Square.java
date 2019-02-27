package model;

public class Square {
	
	//Atributtes
	private int[][] square;
	private int order;
	
	//Constructor
	public Square() {
		
	}
	
	//Methods
	public int[][] getS() {
		return square;
	}
	
	public void setS(int[][] square) {
		this.square = square;
	}
	
	public int getOrder() {
		return order;
	}
	
	public void setOrder(int order) {
		this.order = order;
	}
	
	public boolean check() {
		boolean v = false;
		if(order%2 != 0) {
			v = true;
		}
		return v;
	}
	
	public int[][] generate(int order) {
		square = new int[order][order];
		return square;
	}
	
	//Main Method
	public void fill(int first, int way, int[][] square, int order) {
		int n = 1;
		//Up
		if(first == 1) {
			int row = 0;
			int column = (order-1)/2;
			square[row][column] = n;
			//NO
			if(way == 1) {
				for(int i = 0; i<square.length-1; i++) {
					for(int j = 0; j<square.length+1; j++) {
						int sRow = row;
						int sColumn = column;
						if(row-1 < 0 && column-1 < 0) {
							row = square.length-1;
							column = square.length-1;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(row-1 < 0 && column-1 >= 0) {
							row = square.length-1;
							column--;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(column-1 < 0 && row-1 >= 0) {
							column = square.length-1;
							row--;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(column-1 >= 0 && row-1 >= 0){
							row--;
							column--;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}
						n++;
					}
				}
			//NE
			}else if(way == 2) {
				for(int i = 0; i<square.length-1; i++) {
					for(int j = 0; j<square.length+1; j++) {
						int sRow = row;
						int sColumn = column;
						if(row-1 < 0 && column+1 > square.length-1) {
							row = square.length-1;
							column = 0;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(row-1 < 0 && column+1 <= square.length-1) {
							row = square.length-1;
							column++;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(column+1 > square.length-1 && row-1 >= 0) {
							column = 0;
							row--;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}else if(column+1 <= square.length-1 && row-1 >= 0){
							row--;
							column++;
							if(square[row][column] == 0) {
								square[row][column] = n+1;
							}else {
								square[++sRow][sColumn] = n+1;
								row = sRow;
								column = sColumn;
							}
						}
						n++;
					}
				}
			}
			//Down
		}else if(first == 2) {
				int row = square.length-1;
				int column = (order-1)/2;
				square[row][column] = n;
				//SO
				if(way == 3) {
					for(int i = 0; i<square.length-1; i++) {
						for(int j = 0; j<square.length+1; j++) {
							int sRow = row;
							int sColumn = column;
							if(row+1 > square.length-1 && column-1 < 0) {
								row = 0;
								column = square.length-1;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(row+1 > square.length-1 && column-1 >= 0) {
								row = 0;
								column--;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(column-1 < 0 && row+1 <= square.length-1) {
								column = square.length-1;
								row++;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(column-1 >= 0 && row+1 <= square.length-1){
								row++;
								column--;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}
							n++;
						}
					}
				//SE
				}else if(way == 4) {
					for(int i = 0; i<square.length-1; i++) {
						for(int j = 0; j<square.length+1; j++) {
							int sRow = row;
							int sColumn = column;
							if(row+1 > square.length-1 && column+1 > square.length-1) {
								row = 0;
								column = 0;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(row+1 > square.length-1 && column+1 <= square.length-1) {
								row = 0;
								column++;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(column+1 > square.length-1 && row+1 <= square.length-1) {
								column = 0;
								row++;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}else if(column+1 <= square.length-1 && row+1 <= square.length-1){
								row++;
								column++;
								if(square[row][column] == 0) {
									square[row][column] = n+1;
								}else {
									square[--sRow][sColumn] = n+1;
									row = sRow;
									column = sColumn;
								}
							}
							n++;
						}
					}
				}
		}
	}
	
}
