class ArrayStackInt
{
    int top;
    int capacity;
    int[] array;
	public ArrayStackInt(int capacity) {
		this.capacity = capacity;
		this.top = -1;
		this.array =  new int[capacity];
		
	}
	
	// Stack is full when top is equal to the last index
		public  boolean isFull()
		{   return this.top == this.capacity - 1; }
		 
		// Stack is empty when top is equal to -1
		public  boolean isEmpty()
		{   return this.top == -1;  }
		 
		// Function to add an item to stack.  It increases top by 1
		public  void push(int item)
		{
		    if (isFull())
		        return;
		    this.array[++this.top] = item;
		    //System.out.printf("%d pushed to stack\n", item);
		}
		 
		// Function to remove an item from stack.  It decreases top by 1
		public int pop()
		{
		    if (isEmpty())
		        return Integer.MIN_VALUE;
		    return this.array[this.top--];
		}
		 
		// Function to get top item from stack
		public  int peek()
		{
		    if (isEmpty())
		        return Integer.MIN_VALUE;
		    return this.array[this.top];
		}
    
    
}

