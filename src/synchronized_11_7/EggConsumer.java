package synchronized_11_7;

public class EggConsumer extends Thread{
static int eggConsume=0;
boolean times;
Egg eggCake;
public EggConsumer(String name,Egg eggCake) {
	// TODO Auto-generated constructor stub
	super(name);
	this.eggCake=eggCake;
}
@Override
	public void run() {
		// TODO Auto-generated method stub
		while(eggConsume<20){
			synchronized (eggCake) {
			
			while((eggCake.getEggCake()==0)){
				try {
					eggCake.wait();
					sleep(1000);
					System.out.println("wait the Egg Cake to be produced!");
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			int time=(int)(Math.random()*2000);
			try {
				eggCake.consumeEggCake();
				eggConsume++;
				times=true;
				sleep(time);
				System.out.println("An Egg Cake is consumed!"+"  This is the  "+eggConsume+"  that has sold this morning!");
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			eggCake.notifyAll();
			
			while(times){
				try {
					times=false;
					eggCake.wait();
					
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			}
		}
	}

}
