 public int solution(int[] left, int[] right) {
    	int max = 0;
    	int[][] cache = new int[left.length+1][right.length+1];
    	
    	for (int i = 0; i <= left.length; i++) {
    		for (int j = 0; j <= right.length; j++) {
    			cache[i][j] = -1;
    		}
    	}
    	
    	cache[0][0] = 0;
    	
    	for (int i = 0; i < left.length; i++) {
    		for (int j = 0; j < right.length; j++) {
    			if (cache[i][j] == -1) {
    				continue;
    			}
    			if (left[i] > right[j] && cache[i][j+1] < cache[i][j] + right[j]) {
    				cache[i][j+1] = cache[i][j] + right[j];
    			}
    			if (cache[i+1][j+1] < cache[i][j]) {
    				cache[i+1][j+1] = cache[i][j];
    			}
    			if (cache[i+1][j] < cache[i][j]) {
    				cache[i+1][j] = cache[i][j];
    			}
    		}
    	}
    	
    	for (int i = 0; i <= left.length; i++) {
    		if (cache[i][right.length] > max) {
    			max = cache[i][right.length];
    		}
    		if (cache[left.length][i] > max) {
    			max = cache[left.length][i];
    		}
    	}
    	return max;
    }
