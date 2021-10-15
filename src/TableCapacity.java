public enum TableCapacity {
	SIZE2(2), SIZE4(4), SIZE6(6), SIZE8(8), SIZE10(10);

	private int numVal;

	TableCapacity(int numVal) {
		this.numVal = numVal;
	}

	public int getNumVal() {
		return numVal;
	}
}
