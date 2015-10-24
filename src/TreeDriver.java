import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeDriver {
	
		public static void main(String args[]){
//			// Create String BST
//			BinarySearchTree<String> tree = new BinarySearchTree<String>();
//			BinarySearchTreeNode<String> node;
//			// Fill String BST
//			System.out.println("=====String BST=====");
//			node = tree.addRoot("H");
//			tree.add(node, "D");
//			tree.add(node, "L");
//			tree.add(node, "B");
//			tree.add(node, "F");
//			tree.add(node, "J");
//			tree.add(node, "N");
//			tree.add(node, "A");
//			tree.add(node, "C");
//			tree.add(node, "E");
//			tree.add(node, "G");
//			tree.add(node, "I");
//			tree.add(node, "K");
//			tree.add(node, "M");
//			tree.add(node, "O");
//			// Different outputs of the String BST
//			System.out.println("traversePreoder:");
//			tree.traversePreoder();
//			System.out.println();
//			System.out.println("traversePostoder:");
//			tree.traversePostoder();
//			System.out.println();
//			System.out.println("traverseInoder:");
//			tree.traverseInoder();
//			System.out.println();
//			// Search Nodes of the String BST
//			System.out.println("Search nodes 'G' and 'X'");
//			System.out.println(tree.search(node, "G"));
//			System.out.println(tree.search(node, "X"));
//			// Find Nodes of the String BST
//			System.out.println("Find nodes 'G' and 'X'");
//			System.out.println(tree.find(node, "G"));
//			System.out.println(tree.find(node, "X"));
//			// Size of the String BST
//			System.out.println("Size: " + tree.size());
//			// Height of the String BST
//			System.out.println("Height: " + tree.height(node));
//			// Print String BST
//			System.out.println();
//			System.out.println("---------------------");
//			System.out.println("Visualization:");
//			tree.BFS(node);
//			System.out.println();
//			System.out.println();
//			//=============================================
//			// Create Integer BST
//			System.out.println("=====Integer BST=====");
//			BinarySearchTree<Integer> tree_int = new BinarySearchTree<Integer>();
//			BinarySearchTreeNode<Integer> node_int;
//			// Fill Integer BST
//			node_int = tree_int.addRoot(5);
//			tree_int.add(node_int, 3);
//			tree_int.add(node_int, 2);
//			tree_int.add(node_int, 4);
//			tree_int.add(node_int, 1);
////			tree_int.add(node_int, 2);
////			tree_int.add(node_int, 1);
////			tree_int.add(node_int, 4);
//						
//			// Print Integer BST
//			System.out.println("Visualization:");
//			tree_int.BFS(node_int);
//
//			System.out.println("Deleting Node");
//			// Delete Node
//			tree_int.delete(node_int, 2);
//			// Print Integer BST
//			tree_int.BFS(node_int);
//			System.out.println();
//			System.out.println("traversePreoder:");
//			tree_int.traversePreoder();
//			System.out.println();
//			//=============================================
//			System.out.println();
//			System.out.println("Task #3,4");
//			Integer[] data = new Integer[] {1, 3, 4, 5, 6, 7, 8, 14, 56, 67, 70 };
//			List<Integer> datalist = Arrays.asList(data);
//			BinarySearchTree<Integer> tree_int2 = new BinarySearchTree<Integer>();
//			BinarySearchTreeNode<Integer> node_int2;
//			node_int2 = tree_int2.addRoot(datalist.get(0));
//			for (int i=1; i<datalist.size(); i++)
//				tree_int2.add(node_int2, datalist.get(i));
//			System.out.println("Height: " + tree_int2.height(node_int2));
//			//I know, probably, it may looks horrible, but it has sense
//			//Visualization isn't pleasant because it's unbalanced tree
//			System.out.println("Hint: Scroll right to see the whole tree");
//			tree_int.BFS(node_int2);
//			
//			BinarySearchTree<Integer> tree_int3 = new BinarySearchTree<Integer>();
//			BinarySearchTreeNode<Integer> node_int3 = tree_int3.addRoot(datalist.get((datalist.size()-1)/2));
//			array2BST(tree_int3, node_int3, datalist, 0, datalist.size()-1);
//			System.out.println();
//			System.out.println();
//
//			System.out.println("Height: " + tree_int3.height(node_int3));
//			tree_int3.BFS(node_int3);
//			
//			
//			
//		
//			AVLTree<Integer> tree_int4 = new AVLTree<Integer>();
//			BinarySearchTreeNode<Integer> node_int4;
//			node_int4 = tree_int4.addRoot(5);
//			System.out.println();
//			node_int4 = tree_int4.insert(node_int4, 3);
//			tree_int4.BFS(node_int4);
//			System.out.println();
//			node_int4 = tree_int4.insert(node_int4, 6);
////			tree_int4.insert(node_int4, 7);
////			tree_int4.insert(node_int4, 9);
//			tree_int4.BFS(node_int4);
//			System.out.println();
//			node_int4 = tree_int4.insert(node_int4, 2);
//			tree_int4.BFS(node_int4);
//			System.out.println();
//			node_int4 = tree_int4.insert(node_int4, 1);
//			tree_int4.BFS(node_int4);
//			System.out.println();
//			node_int4 = tree_int4.insert(node_int4, 4);
//			System.out.println();
//			System.out.println();
//			System.out.println();
//			System.out.println("Height 4: " + tree_int4.height(node_int4));
//			tree_int4.BFS(node_int4);
//			
//			System.out.println();
			System.out.println("===============================================");
			System.out.println("============Tutorial #10: Task 1===============");
			AVLTree<String> tree_month = new AVLTree<String>();
			BinarySearchTreeNode<String> node_month;
			node_month = tree_month.addRoot("Mar");
			String[] monthArray = { "May", "Nov", "Aug", "Apr", "Jan", "Dec", "July",
					"Feb", "Jun", "Oct", "Sept"};
			
			for (String month: monthArray)
				node_month = tree_month.insert(node_month, month);
			
			tree_month.BFS(node_month);
			System.out.println();
			
			System.out.println("Deleting April");
			node_month = tree_month.delete(node_month,"Apr");
			tree_month.BFS(node_month);
			System.out.println();
			
			System.out.println("Deleting August");
			node_month = tree_month.delete(node_month,"Aug");
			tree_month.BFS(node_month);
			System.out.println();
			
			System.out.println("Deleting December");
			node_month = tree_month.delete(node_month,"Dec");
			tree_month.BFS(node_month);
			System.out.println();
			
			System.out.println("January found: " + tree_month.search(node_month, "Jan")+" - "+tree_month.find(node_month, "Jan"));
			System.out.println("December found: " + tree_month.search(node_month, "Dec")+" - "+tree_month.find(node_month, "Dec"));
			
			System.out.println("============Tutorial #10: Task 2===============");
			
			AVLTree<Integer> tree_int6 = new AVLTree<Integer>();
			BinarySearchTreeNode<Integer> node_int6;
			
			ArrayList<Integer> time_add = new ArrayList<Integer>();
			long startTime = System.currentTimeMillis();
			node_int6 = tree_int6.addRoot(0);
			long timeSpent = System.currentTimeMillis() - startTime;
			time_add.add((int) timeSpent);


			int el_amount = 20000;
			for (int i=1; i<=el_amount; i++){
				//comment 2 lines below to prevent showing info
				if (i%1000 == 0)
					System.out.println(i + " elements have been added");
				
				startTime = System.currentTimeMillis();
				node_int6 = tree_int6.insert(node_int6, i);
				timeSpent = System.currentTimeMillis() - startTime;
				time_add.add((int) timeSpent);
			}
			
//			tree_int6.BFS(node_int6);
			
			ArrayList<Integer> time_del = new ArrayList<Integer>();
			for (int i=el_amount; i>=0; i--){
				//comment 2 lines below to prevent showing info
//				tree_int6.BFS(node_int6);
//				System.out.println("Del: " + i);
				
				if (i%1000 == 0)
					System.out.println(el_amount-i + " elements have been deleted");
				
				startTime = System.currentTimeMillis();
				node_int6 = tree_int6.delete(node_int6, i);
				timeSpent = System.currentTimeMillis() - startTime;
				time_del.add((int) timeSpent);
			}
			System.out.println(time_del.get(0));
			System.out.println(time_del.get(time_del.size()-1));
			
			DrawGraph.createAndShowGui(time_add, time_del);
			
			
		}

}
