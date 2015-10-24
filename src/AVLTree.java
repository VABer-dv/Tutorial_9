import java.util.function.Function;

public class AVLTree<E> extends BinarySearchTree<E> {

	public BinarySearchTreeNode<E> insert(BinarySearchTreeNode<E> root, E e) {
		this.add(root, e);
		root = checkBalance(root);
		return root;
	}

	public BinarySearchTreeNode<E> delete(BinarySearchTreeNode<E> Node, E e) {
		BinarySearchTreeNode<E> temp = Node;
		Node = super.delete(Node, e);
//		System.out.println("===");
//		this.BFS(Node);
		Node=checkBalance(Node);
//		System.out.println("---");
//		this.BFS(Node);
		return Node;
	}

	private BinarySearchTreeNode<E> checkBalance(BinarySearchTreeNode<E> node) {
		int balanceL, balanceR = 0;

		if (node.getLeft() != null)
			checkBalance(node.getLeft());
		if (node.getRight() != null)
			checkBalance(node.getRight());

		balanceL = height(node.left) + 1;
		balanceR = height(node.right) + 1;
		if (Math.abs(balanceL - balanceR) < 2)
			return node;
		switch (Math.abs(balanceL - balanceR)) {
		case 1:
			return node;
		case 2:
			if (balanceL > balanceR) {
				if (height(node.left.left) >= height(node.left.right)) {
//					System.out.println("Balancing (LR)=......" + node.data);
					if (node.parent != null) {
//						System.out.println("Here");
						node=rightRotate(node);
//						return node;
					} else {
//						System.out.println("Here null");
						node = (rightRotate(node));
						return node;
					}
				} else {
//					System.out.println("Balancing (LR+RR)......");
					if (node.parent != null) {
						node.parent.left.setLeft(leftRotate(node.left));
						node.parent.setLeft(rightRotate(node));
					} else {
						node.setLeft(leftRotate(node.left));
						node = rightRotate(node);
					}
				}
			} else {
				if (height(node.right.right) >= height(node.right.left)) {
//					System.out.println("Balancing (RR)......" + node.data);
					if (node.parent != null)
						node=leftRotate(node);
					else {
						node = leftRotate(node);
					}
				} else {
//					System.out.println("Balancing (RR+LR)......" + node.data);
					if (node.parent != null) {
//						System.out.println("Here1");
						node.setRight(rightRotate(node.right));
						// this.BFS(node);
						// System.out.println("Node ="+node.data);
						leftRotate(node);
						// this.BFS(node);
					} else {
//						System.out.println("Here1 null");
						node.setRight(rightRotate(node.left));
						node = leftRotate(node);
					}
				}
			}
		}
//		System.out.println("***************");
//		this.BFS(node);
		return node;
	}

	private BinarySearchTreeNode<E> rightRotate(BinarySearchTreeNode<E> node) {
		BinarySearchTreeNode<E> temp = node.left;
		temp.parent = node.parent;
		node.left = temp.right;

		if (node.left != null)
			node.left.parent = node;
		temp.right = node;
		node.parent = temp;

		if (temp.parent != null) {
			if (temp.parent.right == node) {
				temp.parent.right = temp;
			} else {
				temp.parent.left = temp;
			}
		}
		return temp;
	}

	private BinarySearchTreeNode<E> leftRotate(BinarySearchTreeNode<E> node) {
		BinarySearchTreeNode<E> temp = node.right;
		temp.parent = node.parent;
		node.right = temp.left;
		if (node.right != null)
			node.right.parent = temp;
		temp.left = node;
		node.parent = temp;

		if (temp.parent != null) {
			if (temp.parent.right == node) {
				temp.parent.right = temp;
			} else {
				temp.parent.left = temp;
			}
		}
		return temp;
	}

}
