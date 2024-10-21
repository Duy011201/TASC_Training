package CreationalPattern.SingletonPattern;

public class BillPugh {
	private BillPugh() {}

	private static class SingletonHelper {
		private static final BillPugh INSTANCE = new BillPugh();
	}

	public static BillPugh getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
