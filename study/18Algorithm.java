package chapter;

public class HeapSort {
	private int SIZE;
	private int heapArr[];
	
	public HeapSort()
	{
		SIZE = 0;
		heapArr = new int [50];
	}
	
	public void insertHeap(int input) {
		int i = ++SIZE;
		//while((i != 1) &&  (input < heapArr[i/2])) { // max heap
		while((i != 1) && (input < heapArr[i/2])) { // min heap
			heapArr[i] = heapArr[i/2];
			i = i / 2;
		}
		heapArr[i] = input;
	}
	
	public int getHeapSize() {
		return SIZE;
	}
	
	public int deleteHeap() {
		// 힙은 보통 루트에 있는 값을 제거 
		int parent,child;
		int data, temp;
		// 루트에 있는 데이터 대입   
		data = heapArr[1];
		
		// 맨마지막 element를 temp
		temp = heapArr[SIZE];
		// 맨 위로 올렸다고 가정   
		SIZE -= 1;
		parent = 1; child = 2;
		
		while(child <= SIZE) {
			//if((child < HEAP_SIZE) && (heapArr[child] < heapArr[child+1])) // max heap
			//더 작은 자식 값을 찾는 과정. 
			if((child < SIZE) && (heapArr[child] > heapArr[child + 1])) { // min heap
				child ++;
			}
			//if(temp >= heapArr[child]) break; // max heap
			if(temp <= heapArr[child]) break; // min heap
			heapArr[parent] = heapArr[child];
			parent = child;
			child *= 2;
		}
		
		heapArr[parent] = temp;
		return data;
	}
	
	public void printHeap() {
		//System.out.printf("\n Max Heap: ");
		System.out.printf("\n Min Heap");
		for(int i=1; i<=SIZE;i++)
			System.out.printf("[%d] ", heapArr[i]);
	}
	
	public static void main(String[] args) {
		HeapSort h = new HeapSort();
		h.insertHeap(80);
		h.insertHeap(50);
		h.insertHeap(70);
		h.insertHeap(10);
		h.insertHeap(60);
		h.insertHeap(20);
		
		h.printHeap();
		
		int n,data;
		n = h.getHeapSize();
		for(int i = 1; i<=n; i++) {
			data = h.deleteHeap();
			System.out.printf("\n 출력 : [%d]", data);
		}

	}

}
