
public class BinarySearchTreeNode<E> {
	protected E data;
	protected BinarySearchTreeNode<E> parent;
	protected BinarySearchTreeNode<E> left;
	protected BinarySearchTreeNode<E> right;
	
	public BinarySearchTreeNode(E data){
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	
	public BinarySearchTreeNode(E data, BinarySearchTreeNode<E> parent, BinarySearchTreeNode<E> left, BinarySearchTreeNode<E> right){
		this.data = data;
		this.parent = null;
		this.left = null;
		this.right = null;
	}
	

	public E getData(){
		return data;
	}
	
	public void setData(E data){
		this.data = data;
	}
	
	public BinarySearchTreeNode<E> getParent(){
		return parent;
	}
	
	public void setParent(BinarySearchTreeNode<E> parent){
		this.parent = parent;
	}
	
	public BinarySearchTreeNode<E> getLeft(){
		return left;
	}
	
	public void setLeft(BinarySearchTreeNode<E> childNode){
		for (BinarySearchTreeNode<E> n = this; n != null; n = n.parent){
			if (n == childNode){
				throw new IllegalArgumentException();
			}
		}
		
		if (this.left != null){
			left.parent = null;
		}
		if (childNode != null){
			childNode.parent = this;
		}
		this.left = childNode;
	}
	
	public BinarySearchTreeNode<E> getRight(){
		return right;
	}
	
	public void setRight(BinarySearchTreeNode<E> childNode){
		for (BinarySearchTreeNode<E> n = this; n != null; n = n.parent){
			if (n == childNode){
				throw new IllegalArgumentException();
			}
		}
		
		if (right != null){
			right.parent = null;
		}
		if (childNode !=null){
			childNode.parent = this;
		}
		this.right = childNode;
	}
	
	public void removeFromParent(){
		if (parent != null){
			if (parent !=null){
				if (parent.left == this){
					parent.left = null;	
				}
				else if (parent.right == this){
					parent.right = null;
				}
				this.parent = null;
			}
		}
	}
	
	public int numChildren(){
		int count = 0;
		if (this.getLeft() != null)
				count++;
		if (this.getRight() != null)
			count++;
		return count;
	}


	
}
