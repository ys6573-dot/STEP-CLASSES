public class InventoryBalancer {

    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Sections must have equal length.");
            return;
        }

        int totalA = 0, totalB = 0;
        int highest = Integer.MIN_VALUE;
        String location = "";

        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            if (sectionA[i] > highest) {
                highest = sectionA[i];
                location = "Section A, Item " + (i + 1);
            }
        }

        for (int i = 0; i < sectionB.length; i++) {
            totalB += sectionB[i];
            if (sectionB[i] > highest) {
                highest = sectionB[i];
                location = "Section B, Item " + (i + 1);
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s)%n",
                totalA, totalB, status, highest, location);
    }

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        analyzeInventory(sectionA, sectionB);
    }
}
