class Solution {
    public int trap(int[] height) {
        int n=height.length;
        //traversing to find the maximum bar left side
        int Lmax[] = new int[n];
        Lmax[0]=height[0];
        for(int i=1;i<n;i++){
            Lmax[i]=Math.max(Lmax[i-1],height[i]);
        }

        //traversing to find the maximum bar right side
        int Rmax[] = new int[n];
        Rmax[Rmax.length-1]=height[n-1];
        for(int i=Rmax.length-2;i>=0;i--){
            Rmax[i]=Math.max(Rmax[i+1],height[i]);
        }
           
        // finally calculating the water trapped between the gaps using the formula
        int rainwater = 0;
        for(int i=0;i<n;i++){
            rainwater = rainwater +  Math.min(Lmax[i], Rmax[i]) - height[i];
        }

        return rainwater;

    }
}
