public class Main {
    public static void main(String[] args) {
        //System.out.println(findTheIndexOfTheFirstOccurenceInAString("sadbutaadts", "ts"));

//        int[] arr1 = {1,3,5,7,0,0,0};
//        int[] arr2 = {2,4,6};
//        System.out.println(Arrays.toString(mergeSortedArray(arr1, arr2, arr1.length - arr2.length, arr2.length)));

        Node node11 = new Node(1);
        Node node12 = new Node(3);
        Node node13 = new Node(5);
        Node node14 = new Node(7);

        node11.next = node12;
        node12.next = node13;
        node13.next = node14;

        Node node21 = new Node(2);
        Node node22 = new Node(4);
        Node node23 = new Node(6);

        node21.next = node22;
        node22.next = node23;

        mergeTwoSortedLists(node11, node21);
    }

    private static void mergeTwoSortedLists(Node node1, Node node2) {
        Node prev = new Node(0);
        Node current = prev;

        while (node1 != null && node2 != null) {
            if (node1.val <= node2.val) {
                current.next = node1;
                node1 = node1.next;
            } else if (node1.val > node2.val) {
                current.next = node2;
                node2 = node2.next;
            }

            current = current.next;
        }

        if (node1 == null) {
            current.next = node2;
        } else {
            current.next = node1;
        }
    }

    static class Node {
        private int val;
        private Node next;

        public Node(int val) {
            this.val = val;
        }

        public int getVal() {
            return val;
        }

        public void setVal(int val) {
            this.val = val;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    private static int[] mergeSortedArray(int[] arr1, int[] arr2, int m, int n) {
        int pointer1 = m - 1;
        int pointer2 = n - 1;

        for (int i = m + n - 1; i >= 0; i--) {

            if (pointer2 < 0) {
                break;
            }

            if (arr1[pointer1] >= arr2[pointer2]) {
                arr1[i] = arr1[pointer1--];
            } else if (arr1[pointer1] < arr2[pointer2]) {
                arr1[i] = arr2[pointer2--];
            }
        }

        return arr1;
    }

    private static int findTheIndexOfTheFirstOccurenceInAString(String haystack, String needle) {

        int haystackLength = haystack.length();
        int needleLength = needle.length();
        if (haystack == null || needle == null || haystackLength < needleLength) {
            return -1;
        }

        for (int i = 0; i <= haystackLength - needleLength; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                for (int j = 0; j < needleLength; j++) {
                    if (haystack.charAt((i + j)) != needle.charAt(j)) {
                        break;
                    }

                    if (j == needleLength - 1) {
                        return i;
                    }
                }
            }
        }

        return -1;
    }
}