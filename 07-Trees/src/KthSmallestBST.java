import java.util.Deque;
import java.util.LinkedList;

public class KthSmallestBST {

	public static void main(String[] args) {
		BNode root = new BNode(20);
		root.left = new BNode(8);
		root.right = new BNode(22);
		root.left.left = new BNode(4);
		root.left.right = new BNode(12);
		root.left.right.left = new BNode(10);
		root.left.right.right = new BNode(14);
		root = kthSmallest(root, 1);
		System.out.println(root.data);
	}

	public static BNode kthSmallest(BNode root, int k) {
		Deque<BNode> st = new LinkedList<BNode>();
		BNode pCrawl = root;

		while (pCrawl != null) {
			st.push(pCrawl);
			pCrawl = pCrawl.left;
		}

		/* pop off stack and process each node */
		while ((pCrawl = st.pop()) != null) {

			--k;
			if (k == 0) {
				break;
			}

			/* there is right subtree */
			if (pCrawl.right != null) {
				/* push the left subtree of right subtree */
				pCrawl = pCrawl.right;
				while (pCrawl != null) {
					st.push(pCrawl);
					pCrawl = pCrawl.left;
				}
			}
		}
		return pCrawl;
	}

	public static void printInorder(BNode node) {
		if (node == null)
			return;

		printInorder(node.left);
		System.out.format("%d ", node.data);
		printInorder(node.right);
	}

}
