package net.sandius.rembulan.core;

import net.sandius.rembulan.util.Check;

public class ObjectStack {

	protected final Object[] values;
	protected int top;

	private ObjectStack(int maxSize) {
		Check.positive(maxSize);

		this.values = new Object[maxSize];
		this.top = 0;
	}

	public static ObjectStack newEmptyStack(int maxSize) {
		return new ObjectStack(maxSize);
	}

	public int getMaxSize() {
		return values.length;
	}

	public int getTop() {
		return top;
	}

	public void setTop(int to) {
		Check.inRange(to, 0, values.length);

		if (to < top) {
			for (int i = to; i < top; i++) {
				// clear values above the new top
				values[i] = null;
			}
		}
		top = to;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public void push(Object[] args) {
		Check.notNull(args);

		if (top + args.length > values.length) {
			throw new IllegalArgumentException("Not enough space in object stack: pushing "
					+ args.length + " values, " + (values.length - top) + " slots free" );
		}

		System.arraycopy(args, 0, values, top, args.length);
		top += args.length;
	}

	public Object get(int i) {
		return values[i];
	}

	public void set(int i, Object o) {
		values[i] = o;
	}

}
