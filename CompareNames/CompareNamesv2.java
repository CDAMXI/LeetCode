public class CompareNamesv2 {
    public static void main(String[] args) {
        System.out.println(compare("Resumen_Teoria_Redes_Protocolos_BulletsEnNegrita_250602_120554",
                                   "Resumen_Teoria_Redes_Protocolos_BulletsEnNegrita"));
    }

    /**
     * Compares two strings for equality, ignoring case.
     * If different, shows where the divergence starts.
     */
    public static String compare(String s1, String s2) {
        // Use equalsIgnoreCase directly to detect full equality
        if (s1.equalsIgnoreCase(s2)) {
            return "Both names are the same";
        }

        // Convert both strings to lowercase only once
        String lowerS1 = s1.toLowerCase();
        String lowerS2 = s2.toLowerCase();

        // Find the first differing index (up to the shorter string's length)
        int minLength = Math.min(lowerS1.length(), lowerS2.length());
        for (int i = 0; i < minLength; i++) {
            if (lowerS1.charAt(i) != lowerS2.charAt(i)) {
                return "Names are different [" + lowerS1.substring(i) + "],[" + lowerS2.substring(i) + "]";
            }
        }

        // If one string is a prefix of the other
        return "Names are different [" + lowerS1.substring(minLength) + "],[" + lowerS2.substring(minLength) + "]";
    }
}
