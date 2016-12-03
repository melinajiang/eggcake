package synchronized_11_7;

public class Egg {
	private int eggCake=0;

	public int getEggCake() {
		return eggCake;
	}

	public void addEggCake() {
		this.eggCake++;
	}	
	public void consumeEggCake() {
		this.eggCake--;
	}
	
}
