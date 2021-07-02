package solution;

public class NC113 {
    /**
     * 验证IP地址
     * @param IP string字符串 一个IP地址字符串
     * @return string字符串
     */
    public String solve (String IP) {
        if(IP.contains(".")){
            String[] strings = IP.split("\\.");
            for(String s : strings){
                if(s.charAt(0) == '0' || s.contains(":") || s.equals("")){
                    return "Neither";
                }
                int num = Integer.parseInt(s);
                if(num < 0 || num > 255){
                    return "Neither";
                }
            }
            return "IPv4";
        }
        if(IP.contains(":")){
            String[] strings = IP.split(":");
            for(String s : strings){
                if(s.length() > 1 && s.charAt(0) == '0' && s.charAt(1) == '0'){
                    return "Neither";
                }
                if(s.equals("") || s.contains("\\.")){
                    return "Neither";
                }
            }
            return "IPv6";
        }
        return "Neither";
    }
}
