import java.util.*;
class Node{
		String f_name,l_name;
		int run,six,four;
		Node next;
		Node(String fname,String lname,int runs,int fours,int sixes){
			f_name = fname;
			l_name = lname;
			run = runs;
			four = fours;
			six = sixes;
			next = null;
		}
	}
class ScoreCard{
	Node head;	
	public static func15 insert(func15 list){
		int runs,sixes,fours,total;
		String lname,fname;
		System.out.print("\n INSERT BATSMAN DETAIL ");
		Scanner sc = new Scanner(System.in);
		System.out.print("\n ENTER FIRST NAME OF BATSMAN : ");
		fname = sc.nextLine();
		System.out.print("\n ENTER LAST NAME OF BATSMAN : ");
		lname = sc.nextLine();
		System.out.print("\n ENTER RUNS SCORED BY BATSMAN : ");
		runs = sc.nextInt();
		System.out.print("\n ENTER FOURS HIT BY BATSMAN : ");
		fours = sc.nextInt();
		System.out.print("\n ENTER SIXES HIT BY BATSMAN : ");
		sixes = sc.nextInt();
		total  = (fours*4) + (sixes*6);
		if(total<=runs){
			Node new_node = new Node(fname,lname,runs,fours,sixes);
			new_node.next = null;

			if (list.head == null) {
	            list.head = new_node;
	        }
	        // Insert or append the new node
	        else {
	            Node last = list.head;
	            while (last.next != null) {
	                last = last.next;
	            }
	            last.next = new_node;
        	}
			System.out.println("\n BATSMAN DATA HAS BEEN RECORDED SUCCESSFULLY");
			return list;
		}else{
			System.out.println("\n ERROR FOUND!!");
			System.out.println("\n PLEASE ENTER CORRECT RUNS SCORED BY BATSMAN");
			return insert(list);
		}
		
	}
	public static func15 printList(func15 list)
	{
        Node currNode = list.head;    
        System.out.println("\n\n SCOREBOARD :- ");
        System.out.println("===================================================================================================================");
        int i=0;
        while (currNode != null) {
            System.out.println(" "+ ++i+" =>>  FIRST NAME : "+currNode.f_name + " >>  LAST NAME : "+currNode.l_name + " >>  TOTAL RUNS : "+currNode.run + " >>  FOURS : "+currNode.four + " >>  SIXES : "+currNode.six);
            currNode = currNode.next;
        }
        System.out.println("\n===================================================================================================================");
        return list;
    }
    public static func15 updateRun(func15 list){
    	Scanner sc = new Scanner(System.in);
    	String name;
    	int n,total=0,flag=0;
    	Node currNode = list.head;
    	System.out.println("\n\n BATSMAN RUN UPDATION :- \n");
    	System.out.print("\n ENTER FIRST NAME OF BATSMAN : ");
    	name = sc.nextLine();
    	while(currNode != null){
    		if(currNode.f_name.equals(name)){
    			System.out.println("\n BATSMAN FOUND\n");
    			System.out.print("\n\n 1. SCORED A SINGLE \n 2. SCORED A DOUBLE \n 3. SCORED A TRIPLE \n 4. HIT A FOUR \n 5. HIT A SIX \n ENTER THE TYPE OF RUN SCORED BY BATSMAN : ");
    			n = sc.nextInt();
    			total = currNode.run;
    			switch(n){
    				case 1 : currNode.run = total+1;
    						 System.out.println("\n SCORE UPDATED");
    						 break;
    				case 2 : currNode.run = total+2;
    						 System.out.println("\n SCORE UPDATED");
    						 break;
    				case 3 : currNode.run = total+3;
    						 System.out.println("\n SCORE UPDATED");
    						 break;
    				case 4 : currNode.run = total+4;
    						 currNode.four = currNode.four+1;
    						 System.out.println("\n SCORE UPDATED");
    						 break;
    				case 5 : currNode.run = total+6;
    						 currNode.six = currNode.six+1;
    						 System.out.println("\n SCORE UPDATED");
    						 break;
    				default : System.out.println("\n INVALID SELECTION");
    						  break;
    			}
    			flag=1;
    		}
    		currNode = currNode.next;
    	}
    	if(flag == 0)
    		System.out.println("\n NO SUCH BATSMAN FOUND");
    	return list;
    }
    public static func15 displayRun(func15 list){
    	Scanner sc = new Scanner(System.in);
    	String name;
    	int flag=0;
    	Node currNode = list.head;
    	System.out.println("\n\n BATSMAN DETAIL :- \n");
    	System.out.print("\n ENTER FIRST NAME OF BATSMAN : ");
    	name = sc.nextLine();
    	while(currNode != null){
    		if(currNode.f_name.equals(name)){
    			System.out.println("\nDETAIL OF "+currNode.f_name+" :-");
    			System.out.println(" =>>  FIRST NAME : "+currNode.f_name + " >>  LAST NAME : "+currNode.l_name + " >>  TOTAL RUNS : "+currNode.run + " >>  FOURS : "+currNode.four + " >>  SIXES : "+currNode.six);
    			flag=1;
    		}
    		currNode = currNode.next;
    	}
    	if(flag == 0)
    		System.out.println("\n NO SUCH BATSMAN FOUND");
    	return list;
    }
	public static void main(String args[]){
		func15 f = new func15();
		int n;
		Scanner sc = new Scanner(System.in);
		do{
			System.out.println("\n 1. INSERT BATSMAN \n 2. UPDATE RUN OF BATSMAN \n 3. DISPLAY RUN OF A BATSMAN \n 4. SHOW SCOREBOARD \n 5. EXIT");
			System.out.print(" ENTER YOUR CHOICE : ");
			n = sc.nextInt();
			switch(n){
				case 1 : f = insert(f);break;
				case 2 : f = updateRun(f);break;
				case 3 : f = displayRun(f);break;
				case 4 : printList(f);break;
				default : System.exit(0);
			}
		}while(n != 5);
	}
}
