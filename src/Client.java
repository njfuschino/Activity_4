import java.util.Random;

	public class Client extends Thread{
		private final ConcurrentBucketHashMap<Integer, Integer> hashMap;
		private final int id;
		private final int count;
	
		public Client(ConcurrentBucketHashMap<Integer, Integer> hashMap, int id, int count){
			this.hashMap = hashMap;
			this.id = id;
			this.count = count;
		}
		
		private void remove(){
			int i=0;
			while (i<count){
				Random rand = new Random();
				int r = rand.nextInt(50);
				if(hashMap.containsKey(r)){
					hashMap.remove(r);
					i++;
				}
			}
		}
		
		private void add(){
			int i=0;
			while (i<count){
				Random rand = new Random();
				int r = rand.nextInt(50);
				if(!hashMap.containsKey(r)){
					hashMap.put(r, r);
					i++;
				}
			}
		}
		
		public void run(){
			if( id % 2 == 0){
				add();
			}
			else{
				remove();
			}
			//size should include changes made by other threads
			//(should equal last printed size plus ADD(s) and minus REMOVE(s)
			System.out.println("size: " + hashMap.size()); 
		}	
		
	}
