class Solution {

    int k;
    Node[] tree;

    class Node {
        int product;
        int[] count;

        Node() {
            count = new int[k];
        }
    }

    // Merge two nodes
    Node merge(Node left, Node right) {

        Node res = new Node();

        // Product of the complete segment
        res.product = (left.product * right.product) % k;

        // Prefixes completely inside left
        for (int i = 0; i < k; i++) {
            res.count[i] = left.count[i];
        }

        // Prefixes that use all of left + a prefix of right
        for (int i = 0; i < k; i++) {

            int remainder = (left.product * i) % k;

            res.count[remainder] += right.count[i];
        }

        return res;
    }

    void build(int node, int l, int r, int[] nums) {

        if (l == r) {

            tree[node] = new Node();

            int rem = nums[l] % k;

            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        build(node * 2, l, mid, nums);
        build(node * 2 + 1, mid + 1, r, nums);

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    void update(int node, int l, int r,
                int index, int value) {

        if (l == r) {

            tree[node] = new Node();

            int rem = value % k;

            tree[node].product = rem;
            tree[node].count[rem] = 1;

            return;
        }

        int mid = l + (r - l) / 2;

        if (index <= mid) {
            update(node * 2, l, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, r, index, value);
        }

        tree[node] = merge(tree[node * 2],
                           tree[node * 2 + 1]);
    }

    Node query(int node, int l, int r,
               int ql, int qr) {

        // Complete overlap
        if (ql <= l && r <= qr) {
            return tree[node];
        }

        int mid = l + (r - l) / 2;

        // Query only left
        if (qr <= mid) {
            return query(node * 2, l, mid, ql, qr);
        }

        // Query only right
        if (ql > mid) {
            return query(node * 2 + 1, mid + 1, r, ql, qr);
        }

        // Query both
        Node left = query(node * 2, l, mid, ql, qr);
        Node right = query(node * 2 + 1, mid + 1, r, ql, qr);

        return merge(left, right);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        // Build segment tree
        build(1, 0, n - 1, nums);

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Update nums[index]
            update(1, 0, n - 1, index, value);

            // Query [start, n-1]
            Node res = query(1, 0, n - 1, start, n - 1);

            // Number of prefixes having product % k == x
            ans[i] = res.count[x];
        }

        return ans;
    }
}