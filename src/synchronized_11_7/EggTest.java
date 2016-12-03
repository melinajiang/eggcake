package synchronized_11_7;

public class EggTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("these are two threads that display buying and producing eggcakes!");
		Egg kEgg=new Egg();
		EggConsumer a1=new EggConsumer("LI RUI",kEgg);
		EggProducer a2=new EggProducer("LITTLE M",kEgg);
		a2.start();
		a1.start();
	}

}
