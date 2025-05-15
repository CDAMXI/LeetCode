import java.util.regex.*;

public class SimplifyPathv1{
    public static void main(String[] args){
        System.out.println(simplifyPath("/../"));
        System.out.println(simplifyPath("/home/../.."));
    }

    public static String simplifyPath(String path){
        if(path.endsWith("/")){path = path.substring(0, path.length() - 1);}
        if(path.chars().filter(c -> c == '/').count() > 1){path = path.replaceAll("/+", "/");}
        Pattern pattern = Pattern.compile("/\\.\\.{2,}/");
         Matcher matcher = pattern.matcher(path);
        if(matcher.find()){path = path.replaceAll("/\\.\\.+/", "/");}
        return path;
    }
}
