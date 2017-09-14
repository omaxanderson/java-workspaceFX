/*	O Maxwell Anderson
 *  CSE 274
 *  Dr. Duraisamy
 *  Node.java
 *  Node class: each node has a root, a left child, a right child, and
 *  an identifier string.
 */

public class Node {

	//=========== Variables ==============
	public Node rootNode;
	public Node leftChild, rightChild;
	public String s;
	
	//=========== Constructor ============
	public Node(String s) {
		this.s = s;
	}
	
	//=========== Getters and Setters ============
	public void setLeftChild(Node n ) {
		this.leftChild = n;
	}
	
	public void setRightChild(Node n) {
		this.rightChild = n;
	}
	
	public Node getRightChild() {
		return rightChild;
	}
	
	public Node getLeftChild() {
		return leftChild;
	}
	
	public void setRootNode(Node n) {
		this.rootNode = n;
	}
	
	public Node getRoodNode() {
		return rootNode;
	}
	
}
