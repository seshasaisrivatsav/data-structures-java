package arraysAndStrings;

import java.util.HashSet;



class TwoSum {
	
	public static void main(String[] args) {
		int[] nums = {2, 7, 11, 15};
		int target = 9;
		for(int i=0; i<twoSum(nums, target).length; i++) {
			System.out.println(twoSum(nums, target)[i]);
			
		}
		
		
	}
    public static int[] twoSum(int[] nums, int target) {
        
        int[] res = new int[2];
        
        HashSet<Integer> NumSumHM = new HashSet<Integer>();
        
        for(int i=0; i<nums.length; i++){
            if(NumSumHM.contains(target-nums[i])){
                res[0]= locateIndex(target-nums[i], nums);
                res[1]= i;
            }else{
                NumSumHM.add(nums[i]);
            }
        }
        
        return res;
        
        
        
    }
    
    
    public static int locateIndex(int a, int[] nums){
    		int b =1;
        for(int i=0; i<nums.length; i++){
            if(a == nums[i]){
                return i;
            }
        }
        return b;
		 
    }
}