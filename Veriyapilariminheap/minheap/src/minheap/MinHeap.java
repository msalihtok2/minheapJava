//Mehmet Salih Tok
//02185076032
/*
 @author msalih
*/
package minheap;

import java.util.Scanner;


public class MinHeap {
	private int[] Heap; 
	private int size; 
	private int maxsize; 

	private static final int FRONT = 1; 

	public MinHeap(int maxsize) 
	{ 
		this.maxsize = maxsize; 
		this.size = 0; 
		Heap = new int[this.maxsize + 1]; 
		Heap[0] = Integer.MIN_VALUE; 
	} 

	private int parent(int pos) 
	{ 
		return pos / 2; 
	} 

	private int leftChild(int pos) 
	{ 
		return (2 * pos); 
	} 

	private int rightChild(int pos) 
	{ 
		return (2 * pos) + 1; 
	} 

	private boolean isLeaf(int pos) 
	{ 
		if (pos >= (size / 2) && pos <= size) { 
			return true; 
		} 
		return false; 
	} 

		private void swap(int fpos, int spos) 
	{ 
		int temp; 
		temp = Heap[fpos]; 
		Heap[fpos] = Heap[spos]; 
		Heap[spos] = temp; 
	} 
 
	private void minHeapify(int pos) 
	{ 

		if (!isLeaf(pos)) { 
			if (Heap[pos] > Heap[leftChild(pos)] 
				|| Heap[pos] > Heap[rightChild(pos)]) { 

				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) { 
					swap(pos, leftChild(pos)); 
					minHeapify(leftChild(pos)); 
				} 

				else { 
					swap(pos, rightChild(pos)); 
					minHeapify(rightChild(pos)); 
				} 
			} 
		} 
	} 

	public void insert(int element) 
	{ 
		if (size >= maxsize) { 
			return; 
		} 
		Heap[++size] = element; 
		int current = size; 

		while (Heap[current] < Heap[parent(current)]) { 
			swap(current, parent(current)); 
			current = parent(current); 
		} 
	} 

	public void print() 
	{ 
		for (int i = 1; i <= size / 2; i++) { 
			System.out.print(" PARENT : " + Heap[i] 
							+ " Sol CHILD : ," + Heap[2 * i] 
							+ " Sağ CHILD : ," + Heap[2 * i + 1]); 
			System.out.println(); 
		} 
	} 

	public void minHeap() 
	{ 
		for (int pos = (size / 2); pos >= 1; pos--) { 
			minHeapify(pos); 
		} 
	} 

	public int remove() 
	{ 
		int popped = Heap[FRONT]; 
		Heap[FRONT] = Heap[size--]; 
		minHeapify(FRONT); 
		return popped; 
	}
    
    public static void main(String[] args) {
        System.out.println("Min Heap"); 
		MinHeap minheap = new MinHeap(3);
                
                
                Scanner s = new Scanner(System.in); 
                        System.out.println("İlk Değerinizi Giriniz");
                minheap.insert(s.nextInt()); 
                        System.out.println("İkinci Değerinizi Giriniz");
                minheap.insert(s.nextInt()); 
                        System.out.println("Sonuncu Değerinizi Giriniz");
                minheap.insert(s.nextInt());
                
                
               //Min Heap İse
                if( minheap.isLeaf(FRONT) ){
                    minheap.minHeap(); 
                        minheap.print(); 
                         System.out.println("Minimum Deger" + minheap.remove()); 
                }
                else{
                        System.out.println("Min Heap Değildir");
                        }   
	
		

		
		
    }
    
}
