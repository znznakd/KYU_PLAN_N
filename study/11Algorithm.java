public int maxDona(int[] donations) {
    
    int max = 0;
    int[] dpFi = new int[donations.length];
    
    for (int i = 0; i < donations.length-1; i++) {
        dpFi[i] = donations[i];
        if (i >= 3) {
            dpFi[i] += dpFi[i-3] > dpFi[i-2] ? dpFi[i-3] : dpFi[i-2];
        } else if (i >= 2) {
            dpFi[i] += dpFi[i-2];
        }
        if (max < dpFi[i]) max = dpFi[i];
    }
    
    int[] dpSe = new int[donations.length];
    
    for (int i = 1; i < donations.length; i++) {
        dpSe[i] = donations[i];
        if (i >= 3) {
            dpSe[i] += dpSe[i-3] > dpSe[i-2] ? dpSe[i-3] : dpSe[i-2];
        } else if (i >= 2) {
            dpSe[i] += dpSe[i-2];
        }
        if (max < dpSe[i]) max = dpSe[i];
    }
    
    return max;
}
