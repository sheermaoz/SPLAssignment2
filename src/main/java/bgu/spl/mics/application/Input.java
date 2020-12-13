package bgu.spl.mics.application;

import bgu.spl.mics.application.passiveObjects.*;

public class Input {
    private Attack[] attacks;
	private int R2D2;
	private int Lando;
	private int Ewoks;
	
	/**
	 * Gets the number of ewoks available.
	 * @return number of ewoks.
	 */
	public int getEwoks() {
		return Ewoks;
	}

	/**
	 * Sets number of available ewoks to ewoks
	 * @param ewoks number of ewoks
	 */
	public void setEwoks(int ewoks) {
		Ewoks = ewoks;
	}
	
	/**
	 * Gets Lando's action time.
	 * @return Lando's time.
	 */
	public int getLando() {
		return Lando;
	}

	/**
	 * Sets Lando's action time to lando.
	 * @param lando Lando's action time.
	 */
	public void setLando(int lando) {
		Lando = lando;
	}

	/**
	 * Gets R2D2's action time.
	 * @return R2D2's time.
	 */
	public int getR2D2() {
		return R2D2;
	}

	/**
	 * Sets R2D2's action time to r2d2.
	 * @param r2d2 R2D2's action time.
	 */
	public void setR2D2(int r2d2) {
		R2D2 = r2d2;
	}

	/**
	 * Gets an array of Attacks to use for Leia.
	 * @return an array of Attacks.
	 */
	public Attack[] getAttacks() {
		return attacks;
	}

	/**
	 * Sets Leia's Attack array to attacks.
	 * @param attacks the array to use for Leia's attacks.
	 */
	public void setAttacks(Attack[] attacks) {
		this.attacks = attacks;
	}
}
