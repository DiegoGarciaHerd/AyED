package tp2.ejercicio2;

import tp1.ejercicio8.Queue;

public class BinaryTree <T> {
	
	private T data;
	private BinaryTree<T> leftChild;   
	private BinaryTree<T> rightChild; 

	
	public BinaryTree() {
		super();
	}

	public BinaryTree(T data) {
		this.data = data;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	/**
	 * Preguntar antes de invocar si hasLeftChild()
	 * @return
	 */
	public BinaryTree<T> getLeftChild() {
		return leftChild;
	}
	/**
	 * Preguntar antes de invocar si hasRightChild()
	 * @return
	 */
	public BinaryTree<T> getRightChild() {
		return this.rightChild;
	}

	public void addLeftChild(BinaryTree<T> child) {
		this.leftChild = child;
	}

	public void addRightChild(BinaryTree<T> child) {
		this.rightChild = child;
	}

	public void removeLeftChild() {
		this.leftChild = null;
	}

	public void removeRightChild() {
		this.rightChild = null;
	}

	public boolean isEmpty(){
		return (this.isLeaf() && this.getData() == null);
	}

	public boolean isLeaf() {
		return (!this.hasLeftChild() && !this.hasRightChild());

	}
		
	public boolean hasLeftChild() {
		return this.leftChild!=null;
	}

	public boolean hasRightChild() {
		return this.rightChild!=null;
	}
	
	@Override
	public String toString() {
		return this.getData().toString();
	}
	public  int contarHojas() {
		   if (isLeaf()) {
			   return 1;
		   }
		   int countLeft = 0;
		   int countRight = 0;
		   if (hasLeftChild()) {
			   countLeft = this.getLeftChild().contarHojas();
		   }
		   if (hasRightChild()) {
			   countRight = this.getRightChild().contarHojas();
		   }
		   
		   return countLeft + countRight;
		}
			
			
	    	 
	    public BinaryTree<T> espejo(){
	    	BinaryTree<T> tree = new BinaryTree<T>(this.getData());
	    	if (!this.isLeaf()) {
	    		if (this.hasLeftChild()) {
	    			tree.addRightChild(this.getLeftChild().espejo());
	    		} 
	    		if (this.hasRightChild()) {
	    			tree.addLeftChild(this.getRightChild().espejo());
	    		} 
	    		    		
	    	}
	 	   	return tree;
	    }

		// 0<=n<=m
		public void entreNiveles(int n, int m){
			Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
			Queue<Integer> levels  = new Queue<Integer>();
			queue.enqueue(this);
			levels.enqueue(0);
			while (!queue.isEmpty()) {
				BinaryTree<T> e = queue.dequeue();
				int l = levels.dequeue();
				if ((l>=n) && (l<=m)) {				
					System.out.println("l"+l+": "+e.toString());
				}

				if ((e.hasLeftChild()) && ((l+1)<=m)) {
					levels.enqueue(l+1);
					queue.enqueue(e.getLeftChild());
				}
				if ((e.hasRightChild()) && ((l+1)<=m)) {
					levels.enqueue(l+1);
					queue.enqueue(e.getRightChild());
				}
			}
		}

		public void imprimirPorNiveles(){
			Queue<BinaryTree<T>> queue = new Queue<BinaryTree<T>>();
			Queue<Integer> levels  = new Queue<Integer>();
			queue.enqueue(this);
			levels.enqueue(0);
			while (!queue.isEmpty()) {
				BinaryTree<T> e = queue.dequeue();
				int l = levels.dequeue();
				System.out.println("l"+l+": "+e.toString());
				

				if (e.hasLeftChild()) {
					levels.enqueue(l+1);
					queue.enqueue(e.getLeftChild());
				}
				if (e.hasRightChild()) {
					levels.enqueue(l+1);
					queue.enqueue(e.getRightChild());
				}
			}
		}
	

	public void printLevelTraversal() {
		BinaryTree<T> a = null;
		Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
		cola.enqueue(this);
		cola.enqueue(null);
		while (!cola.isEmpty()) {
			a = cola.dequeue();
			if (a != null) {
				System.out.print(a.getData() + " | ");
            if (a.hasLeftChild()) {
                cola.enqueue(a.getLeftChild());
            }
            if (a.hasRightChild()) {
                cola.enqueue(a.getRightChild());
            }
        } else if (!cola.isEmpty()) {
            System.out.println();
            cola.enqueue(null);
        }
    }
}
}
	
/*

	public void entreNiveles(int n, int m){
		BinaryTree <T> ab = null;
		Queue <BinaryTree<T>> queue=new Queue<BinaryTree<T>>(); //COLA FIFO
		
		queue.enqueue(this);
		int nivel=0;
		if(!queue.isEmpty()) {
			ab = queue.dequeue(); 
			if (ab != null) {
				if((nivel>=n)&&(nivel <= m)) {
					System.out.println(ab.getData());
				}
				
				if(this.hasLeftChild()) {
					queue.enqueue(this.getLeftChild());
				}
				if(this.hasRightChild()) {
					queue.enqueue(this.getRightChild());	
				}
			}
			else if(!this.isEmpty()) {
				nivel++;
				queue.enqueue(null);  // Termino un nivel
			}
			
		}
	
	
*/
