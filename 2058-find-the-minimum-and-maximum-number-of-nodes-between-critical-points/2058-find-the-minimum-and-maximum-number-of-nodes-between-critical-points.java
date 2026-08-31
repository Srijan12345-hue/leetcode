class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {

        // Need at least 3 nodes
        if (head == null || head.next == null || head.next.next == null) {
            return new int[]{-1, -1};
        }

        ListNode prev = head;
        ListNode curr = head.next;

        int position = 1;

        int firstPos = -1;
        int prevPos = -1;

        int minDist = Integer.MAX_VALUE;
        int maxDist = -1;

        while (curr.next != null) {

            ListNode next = curr.next;

            // Check whether curr is a critical point
            boolean critical =
                    (curr.val > prev.val && curr.val > next.val) ||
                    (curr.val < prev.val && curr.val < next.val);

            if (critical) {

                // First critical point
                if (firstPos == -1) {
                    firstPos = position;
                }

                // If this is not the first critical point
                if (prevPos != -1) {
                    minDist = Math.min(minDist, position - prevPos);

                    // Distance from first to current
                    maxDist = position - firstPos;
                }

                prevPos = position;
            }

            prev = curr;
            curr = next;
            position++;
        }

        // Fewer than 2 critical points
        if (maxDist == -1) {
            return new int[]{-1, -1};
        }

        return new int[]{minDist, maxDist};
    }
}