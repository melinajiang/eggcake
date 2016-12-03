package synchronized_11_7;

public class EggProducer extends Thread {
	Egg eggCake;
	//private int eggCakeProduce=0;
	public EggProducer(String name,Egg eggCake) {
		// TODO Auto-generated constructor stub
		super(name);
		this.eggCake=eggCake;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		while(true){
			if (EggConsumer.eggConsume==20){
				break;
			}

			synchronized (eggCake) {
				
				while (eggCake.getEggCake()>=3) {
					try {
						sleep(1000);
						System.out.println("The Egg Cake should be consumed first!");
						eggCake.wait();
											} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
					try {
						eggCake.addEggCake();
						//eggCakeProduce++;
						int time=(int)(Math.random()*3000);
						sleep(time);
						System.out.println("Produce an Egg Cake!  "+"Used "+time+" second");
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					eggCake.notifyAll();
			}
		}
	}
	
}
