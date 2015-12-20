package net.sandius.rembulan.util;

import java.util.ArrayList;

public class QuintupleCachingObjectSink extends AbstractObjectSink {

	private Object _0;
	private Object _1;
	private Object _2;
	private Object _3;
	private Object _4;

	private final ArrayList<Object> _var;

	private int size;

	public QuintupleCachingObjectSink() {
		super();
		_var = new ArrayList<>();
	}

	@Override
	public int size() {
		return size;
	}

	protected void setCacheAndClearList(Object a, Object b, Object c, Object d, Object e) {
		_0 = a;
		_1 = b;
		_2 = c;
		_3 = d;
		_4 = e;
		if (size > 5) {
			_var.clear();
		}
		resetTailCall();
	}

	@Override
	public void reset() {
		setCacheAndClearList(null, null, null, null, null);
		size = 0;
	}

	@Override
	public void setTo(Object a) {
		setCacheAndClearList(a, null, null, null, null);
		size = 1;
	}

	@Override
	public void setTo(Object a, Object b) {
		setCacheAndClearList(a, b, null, null, null);
		size = 2;
	}

	@Override
	public void setTo(Object a, Object b, Object c) {
		setCacheAndClearList(a, b, c, null, null);
		size = 3;
	}

	@Override
	public void setTo(Object a, Object b, Object c, Object d) {
		setCacheAndClearList(a, b, c, d, null);
		size = 4;
	}

	@Override
	public void setTo(Object a, Object b, Object c, Object d, Object e) {
		setCacheAndClearList(a, b, c, d, e);
		size = 5;
	}

	@Override
	public void push(Object o) {
		switch (size++) {
			case 0:
				_0 = o;
				break;
			case 1:
				_1 = o;
				break;
			case 2:
				_2 = o;
				break;
			case 3:
				_3 = o;
				break;
			case 4:
				_4 = o;
				break;
			default:
				_var.add(o);
				break;
		}
	}

	private static final Object[] EMPTY_ARRAY = new Object[0];

	@Override
	public Object[] toArray() {
		switch (size) {
			case 0: return EMPTY_ARRAY;
			case 1: return new Object[] { _0 };
			case 2: return new Object[] { _0, _1 };
			case 3: return new Object[] { _0, _1, _2 };
			case 4: return new Object[] { _0, _1, _2, _3 };
			case 5: return new Object[] { _0, _1, _2, _3, _4 };
			default:
				Object[] result = new Object[size];
				result[0] = _0;
				result[1] = _1;
				result[2] = _2;
				result[3] = _3;
				result[4] = _4;
				Object[] tmp = _var.toArray();
				System.arraycopy(tmp, 0, result, 5, tmp.length);
				return result;
		}
	}

	@Override
	public Object[] tailAsArray() {
		switch (size) {
			case 0: throw new IllegalArgumentException();
			case 1: return EMPTY_ARRAY;
			case 2: return new Object[] { _1 };
			case 3: return new Object[] { _1, _2 };
			case 4: return new Object[] { _1, _2, _3 };
			case 5: return new Object[] { _1, _2, _3, _4 };
			default:
				Object[] result = new Object[size - 1];
				result[0] = _1;
				result[1] = _2;
				result[2] = _3;
				result[3] = _4;
				Object[] tmp = _var.toArray();
				System.arraycopy(tmp, 0, result, 4, tmp.length);
				return result;
		}
	}

	@Override
	public Object get(int idx) {
		switch (idx) {
			case 0: return _0;
			case 1: return _1;
			case 2: return _2;
			case 3: return _3;
			case 4: return _4;
			default: return idx < size && idx > 4 ? _var.get(idx - 5) : null;
		}
	}

	@Override
	public Object _0() {
		return _0;
	}

	@Override
	public Object _1() {
		return _1;
	}

	@Override
	public Object _2() {
		return _2;
	}

	@Override
	public Object _3() {
		return _3;
	}

	@Override
	public Object _4() {
		return _4;
	}

}
