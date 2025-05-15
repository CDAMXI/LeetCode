public class SimplifyPathv2 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/../"));           // Output: /
        System.out.println(simplifyPath("/home/../.."));    // Output: /
        System.out.println(simplifyPath("/a///b////c"));    // Output: /a/b/c
    }

    public static String simplifyPath(String path) {
        // 1. Standerize consecutive slashes (// -> /)
        StringBuilder cleaned = new StringBuilder();
        char prev = 0;
        for (int i = 0; i < path.length(); i++) {
            char curr = path.charAt(i);
            if (curr != '/' || prev != '/') {
                cleaned.append(curr);
            }
            prev = curr;
        }

        // 2. Process path segments
        String[] parts = cleaned.toString().split("/");
        StringBuilder result = new StringBuilder();
        
        for (String part : parts) {
            if (part.isEmpty() || part.equals(".")) {
                // Ignore empty or "." current
                continue;
            } else if (part.length() >= 2 && part.chars().allMatch(c -> c == '.')) {
                // Detecte "..", "...", "....", etc. and act as "/../"
                int slashIndex = result.lastIndexOf("/");
                if (slashIndex >= 0) {
                    result.delete(slashIndex, result.length());
                }
            } else {
                result.append('/').append(part);
            }
        }

        return result.length() == 0 ? "/" : result.toString();
    }
}
