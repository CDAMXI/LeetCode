# LeetCode Practice Solutions

This repository contains all the solutions I have developed for LeetCode problems. It includes:

- **Required Classes for Compilation**: All auxiliary classes and definitions needed to run the solutions independently.
- **Attempts and Versions**: Each exercise may include multiple attempts to showcase the thought process and improvements made.

## Repository Structure

- **📂 Folders by Category**: Problems are organized into folders by category for easy navigation.
- **📄 Descriptive File Names**: Each code file is named after the problem's title and its corresponding version.
- **🗂️ Common Data Structures**: All common data structures are located in ```srccode``` folder.

## Example Solution
```java
// ExampleProblem.java
public class ExampleProblem {
    public static void main(String[] args) {
        // Call the example method with test arguments
        System.out.println(exampleMethod(new int[] {1, 2, 3}));
    }

    public static int exampleMethod(int[] nums) {
        // Example implementation: calculate the sum of the array
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }
}
```

## How to Compile and Run
Each solution includes all the necessary classes to compile it as a standalone program. To run a solution using the terminal:
1. Compile the file using ```javac FileName.java```.
2. Run the compiled file with ```java FileName```.

## Next Steps
- Continue adding solutions to new problems.
- Improve the efficiency of existing solutions.

## Notes on Solution Quality:
- ⚠️ Earlier attempts may have edge-case failures due to approach limitations.
- ✅ Highest version number = most optimized!
- 🛠️ Contributions welcome! Open to optimizations or alternative approaches.
- 🧪 All exercises include example test cases in the main method.

## Side Notes
- 📌 Some problems are inspired by real-world needs or common programming exercises and may not exist as standalone LeetCode problems. Said exercises are:
    - "IntegerToBinary"
    - "BinaryToInteger"
    - "ValidSpanishID"
    - "CalculateLetterInSpanishID"
