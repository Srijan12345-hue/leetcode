class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {

        Arrays.sort(reservedSeats, (a, b) -> {
            if (a[0] != b[0]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int groups = (n - getReservedRows(reservedSeats)) * 2;

        int i = 0;

        while (i < reservedSeats.length) {

            int row = reservedSeats[i][0];

            boolean left = true;    // 2,3,4,5
            boolean middle = true;  // 4,5,6,7
            boolean right = true;   // 6,7,8,9

            while (i < reservedSeats.length && reservedSeats[i][0] == row) {

                int seat = reservedSeats[i][1];

                if (seat >= 2 && seat <= 5) {
                    left = false;
                }

                if (seat >= 4 && seat <= 7) {
                    middle = false;
                }

                if (seat >= 6 && seat <= 9) {
                    right = false;
                }

                i++;
            }

            if (left && right) {
                groups += 2;
            } else if (left || middle || right) {
                groups += 1;
            }
        }

        return groups;
    }

    private int getReservedRows(int[][] reservedSeats) {
        if (reservedSeats.length == 0) {
            return 0;
        }

        int count = 1;

        for (int i = 1; i < reservedSeats.length; i++) {
            if (reservedSeats[i][0] != reservedSeats[i - 1][0]) {
                count++;
            }
        }

        return count;
    }
}