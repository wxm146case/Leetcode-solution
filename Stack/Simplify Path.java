//71. Simplify Path

class Solution {
    public String simplifyPath(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        String[] arrays = path.split("/");
        Stack<String> stack = new Stack<>();
        
        for (String str : arrays) {
            if (str.equals("..") && !stack.isEmpty()) {
                stack.pop();
            } else if (str.equals("..") || str.equals(".") || str.equals("")) {
                continue;
            } else {
                stack.push(str);
            }
        }
        StringBuffer res = new StringBuffer();
        while (!stack.isEmpty()) {
            String dir = stack.pop();
            res.insert(0, "/" + dir);
        }
        
        return (res.length() == 0) ? "/" : res.toString();
    }
}