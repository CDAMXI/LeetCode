import java.util.*;

public class SimplifyPathv3 {
    public static void main(String[] args) {
        System.out.println(simplifyPath("/home/"));                  // /home
        System.out.println(simplifyPath("/home//foo/"));             // /home/foo
        System.out.println(simplifyPath("/home/user/Documents/../Pictures")); // /home/user/Pictures
        System.out.println(simplifyPath("/../"));                    // /
        System.out.println(simplifyPath("/.../a/../b/c/../d/./"));   // /.../b/d
    }

    public static String simplifyPath(String path) {
        // Use a stack to manage valid directory names
        Deque<String> stack = new ArrayDeque<>();

        // Split the path by "/" and process each part
        String[] parts = path.split("/");

        for (String part : parts) {
            if (part.equals("") || part.equals(".")) {
                // Ignore empty parts and current directory references
                continue;
            } else if (part.equals("..")) {
                // Pop from the stack to move up a directory, if possible
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }
            } else {
                // Push valid directory names (including '...', '....', etc.)
                stack.addLast(part);
            }
        }

        // Build the simplified path from the stack
        StringBuilder simplifiedPath = new StringBuilder();
        for (String dir : stack) {
            simplifiedPath.append("/").append(dir);
        }

        // If the stack is empty, return root "/"
        return simplifiedPath.length() == 0 ? "/" : simplifiedPath.toString();
    }
}
