/*	O Maxwell Anderson
 *  CSE 274
 *  Dr. Duraisamy
 *  tester.java
 *  Creates two binary trees that will print out in alphabetical
 *  order when using an in-order traverse.
 */



import java.util.ArrayList;

public class tester {

	static ArrayList<Node> list = new ArrayList<Node>();
	static Node a = new Node("A");
	static Node b = new Node("B");
	static Node c = new Node("C");
	static Node d = new Node("D");
	static Node e = new Node("E");
	static Node f = new Node("F");
	static Node g = new Node("G");
	static Node h = new Node("H");
	
	
	public static void main(String[] args) {
		//simply puts all the nodes in an arraylist
		fillList();
		
		
		System.out.println("===== Full Tree =====");
		//since there aren't enough nodes for a true full tree, this creates a complete tree
		createFullTree();
		
		//finds the node with a null rootNode, aka the root of the tree
		for(Node n : list) {
			if (n.rootNode == null) {
				inOrderTraverse(n);
			}
		}
	
		
		System.out.println("===== Max-Height Tree =====");
		createMaxHeightTree();
		for(Node n : list) {
			if (n.rootNode == null) {
				inOrderTraverse(n);
			}
		}
		

	}

	
	//creates a *complete* binary tree
	//			e
	//		  /   \
	//		 c     g
	// 		/ \   / \
	//     b   d f   h
	//    /
	//   a
	public static void createFullTree() {
		a.setRootNode(b);
		a.setLeftChild(null);
		a.setRightChild(null);
		
		b.setRootNode(c);
		b.setLeftChild(a);
		b.setRightChild(null);
		
		c.setRootNode(e);
		c.setLeftChild(b);
		c.setRightChild(d);
		
		d.setRootNode(c);
		d.setLeftChild(null);
		d.setRightChild(null);
		
		e.setRootNode(null);
		e.setLeftChild(c);
		e.setRightChild(g);
		
		f.setRootNode(g);
		f.setLeftChild(null);
		f.setRightChild(null);
		
		g.setRootNode(e);
		g.setLeftChild(f);
		g.setRightChild(h);

		h.setRootNode(g);
		h.setLeftChild(null);
		h.setRightChild(null);
		
	}
	
	//creates a maximum height tree
	//  			h
	//			   /
	//			  g
	//			 /
	//			f
	//		   /
	//		  e
	//		etc...
	public static void createMaxHeightTree() {
		a.setRootNode(b);
		a.setLeftChild(null);
		a.setRightChild(null);
		
		b.setRootNode(c);
		b.setLeftChild(a);
		b.setRightChild(null);
		
		c.setRootNode(d);
		c.setLeftChild(b);
		c.setRightChild(null);
		
		d.setRootNode(e);
		d.setLeftChild(c);
		d.setRightChild(null);
		
		e.setRootNode(f);
		e.setLeftChild(d);
		e.setRightChild(null);
		
		f.setRootNode(g);
		f.setLeftChild(e);
		f.setRightChild(null);
		
		g.setRootNode(h);
		g.setLeftChild(f);
		g.setRightChild(null);

		h.setRootNode(null);
		h.setLeftChild(g);
		h.setRightChild(null);
	}
	
	//in-order traverse of a binary tree
	public static void inOrderTraverse(Node n) {
		if (n != null) {
			inOrderTraverse(n.leftChild);
			System.out.println(n.s);
			inOrderTraverse(n.rightChild);
		}
	}
	
	//fills the arraylist so we can iterate through them later
	public static void fillList() {
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);
		list.add(g);
		list.add(h);
	}
}
