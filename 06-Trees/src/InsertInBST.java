public class InsertInBST {

	public static void main(String[] args) {
		BNode root = null;
		root = insertRecr(root, 11);
		root = insertRecr(root, 5);
		root = insertRecr(root, 18);
		root = insertRecr(root, 2);
		root = insertRecr(root, 9);
		root = insertRecr(root, 15);
		printInorder(root);
	}

	public static BNode insertRecr(BNode node, int data) {
		
		if (node == null) 
			return (new BNode(data));
		
		if (data < node.data)
				node.left = insertRecr(node.left, data);
			else
				node.right = insertRecr(node.right, data);

			return node;
		
	}

	public static BNode insertIter(BNode node, int data) {

		if (node == null)
			return node = new BNode(data);

		BNode parent = null;
		BNode current = node;
		while (current != null) {
			parent = current;
			if (data < current.data) {
				current = current.left;
			} else {
				current = current.right;
			}
		}

		if (data < parent.data) {
			parent.left = new BNode(data);
		} else {
			parent.right = new BNode(data);
		}
		return node;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
