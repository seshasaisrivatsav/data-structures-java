/*
  https://leetcode.com/problems/generate-parentheses/
*/
class GenerateParanthesis {
  
    /*
      Backtracking approach
      
      1. Choice - Place ( or )
      2. Constraint - Can't place more open bracers than given. 
      3. Goal - Place 2n characters
      
      
      - Base Case - If # open brackets == # close brackets == n => add it to result and return
      - Adding open brackets = We can add as many open brackets as we want as long as they're less than n
      - Adding close brackets = if #closing brackets < # open brackets => we can add closing bracket
      
    */
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, "", res, n);
        return res;
    }
    
    public void backtrack(int open, int close, String str, List<String> res, int n) {
        if (str.length() == 2*n) {
            res.add(str);
            return;
        }
        
        if (open < n) {
            backtrack(open+1, close, str+"(", res, n);
        }
        
        if (close < open) {
            backtrack(open, close+1, str+")", res, n);
        }
    }
}
