package swamptarlooter.util;

public class Timer {
	
	private long start;
	private long finish;
	private long duration;

	public Timer(final long duration) {
		this.duration = duration;
		start = System.currentTimeMillis();
		finish = start + duration;
	}

	public long getElapsed() {
		return System.currentTimeMillis() - start;
	}

	public long getRemaining() {
		if (!hasExpired()) {
			return finish - System.currentTimeMillis();
		} else {
			return 0;
		}
	}

	public boolean hasExpired() {
		return System.currentTimeMillis() > finish;
	}

	public void reset() {
		finish = System.currentTimeMillis() + duration;
	}

}
