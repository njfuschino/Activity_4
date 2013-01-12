import java.util.ArrayList;
import java.util.Random;



public class Driver {

	public static void main(String[] args){
		ConcurrentBucketHashMap<Integer, Integer> hashMap = new ConcurrentBucketHashMap<Integer, Integer>(3);
		ArrayList<Client> clients = new ArrayList<Client>();
		
		for(int i=0; i<50; i++){ //populate buckets with 50 pairs
			hashMap.put(i, i);
		}
		
		System.out.println("HashMap size: " + hashMap.size());
		
		//create and start client threads to add/remove from buckets
		for(int i=0; i<8; i++){
			clients.add(new Client(hashMap, i, i));
		}		
		
		//activate threads
		for(int i=0; i<8; i++){	
			clients.get(i).start();
		}
	}
}
