public class WinnerTree {
    public static void main(String[] args) {
        int[] players = { 3, 7, 1, 9, 4, 2, 8, 5 };

        int numPlayers=players.length;
        int[] tree=new int[2*numPlayers-1];
        

        // Copy player indices to the leaf nodes of the tree
        for (int i = 0; i < numPlayers; i++) {
            tree[numPlayers - 1 + i] = i;
        }

        // Build the winner tree from the bottom up
        for (int i = numPlayers - 2; i >= 0; i--) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;
            tree[i] = players[tree[leftChildIndex]] < players[tree[rightChildIndex]] ? tree[rightChildIndex]
                    : tree[leftChildIndex];
        }
        System.out.println("The winner is: " + players[tree[0]]);
    }
}
