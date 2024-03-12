import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Node {
    Integer data;
    Node left, right;

    Node(Integer value) {
        data = value;
        left = right = null;
    }
}

public class LCA {

    Node root;

    private List<Integer> path1 = new ArrayList<>();
    private List<Integer> path2 = new ArrayList<>();

    int findLCA(Integer n1, Integer n2) {
        path1.clear();
        path2.clear();
        return detectLCA(root, n1, n2);
    }

    private int detectLCA(Node root, Integer n1, Integer n2) {
        if (!Path(root, n1, path1) || !Path(root, n2, path2)) {
            System.out.println((path1.size() > 0) ? "n1 is present" : "n1 is missing");
            System.out.println((path2.size() > 0) ? "n2 is present" : "n2 is missing");
            return -1;
        }

        int i;
        for (i = 0; i < path1.size() && i < path2.size(); i++) {
            if (!path1.get(i).equals(path2.get(i)))
                break;
        }

        return path1.get(i - 1);
    }

    private boolean Path(Node root, Integer n, List<Integer> path) {
        if (root == null) {
            return false;
        }

        path.add(root.data);

        if (root.data.equals(n) || Path(root.left, n, path) || Path(root.right, n, path)) {
            return true;
        }

        path.remove(path.size() - 1);

        return false;
    }

    private void insert(Integer value) {
        root = insert(root, value);
    }

    private Node insert(Node root, Integer value) {
        if (value == null) {
            return null;
        }

        if (root == null) {
            root = new Node(value);
            return root;
        }

        if (value < root.data) {
            root.left = insert(root.left, value);
        } else if (value > root.data) {
            root.right = insert(root.right, value);
        }

        return root;
    }

    private void consTree(Integer[] values) {
        if (values.length == 0 || values[0] == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        root = new Node(values[0]);
        queue.add(root);

        for (int i = 1; i < values.length; i += 2) {
            Node currentNode = queue.poll();

            if (values[i] != null) {
                currentNode.left = new Node(values[i]);
                queue.add(currentNode.left);
            }

            if (i + 1 < values.length && values[i + 1] != null) {
                currentNode.right = new Node(values[i + 1]);
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        LCA tree = new LCA();

        System.out.println("Enter the values of the nodes (null accepted):");
        String[] inputStr = scanner.nextLine().split(",");
        Integer[] input = new Integer[inputStr.length];
        for (int i = 0; i < inputStr.length; i++) {
            if (inputStr[i].equalsIgnoreCase("null")) {
                input[i] = null;
            } else {
                input[i] = Integer.parseInt(inputStr[i].trim());
            }
        }

        tree.consTree(input);

        System.out.println("Enter the values of p and q:");
        Integer p = scanner.nextInt();
        Integer q = scanner.nextInt();

        int lca = tree.findLCA(p, q);
        if (lca != -1) {
            System.out.println("The LCA of " + p + " and " + q + " is: " + lca);
        } else {
            System.out.println("LCA cannot be found.");
        }
    }
}
