package net.sandius.rembulan.compiler.gen;

import net.sandius.rembulan.compiler.types.FunctionType;
import net.sandius.rembulan.compiler.types.Type;
import net.sandius.rembulan.lbc.Prototype;
import net.sandius.rembulan.lbc.PrototypePrinter;
import net.sandius.rembulan.util.Check;

public class PrototypeContext {

	private final CompilationContext compilationContext;
	private final Prototype prototype;

	public PrototypeContext(CompilationContext compilationContext, Prototype prototype) {
		this.compilationContext = Check.notNull(compilationContext);
		this.prototype = Check.notNull(prototype);
	}

	public CompilationContext compilationContext() {
		return compilationContext;
	}

	public static Type constantType(Object k) {
		if (k == null) return LuaTypes.NIL;
		else if (k instanceof Boolean) return LuaTypes.BOOLEAN;
		else if (k instanceof Double || k instanceof Float) return LuaTypes.NUMBER_FLOAT;
		else if (k instanceof Number) return LuaTypes.NUMBER_INTEGER;
		else if (k instanceof String) return LuaTypes.STRING;
		else {
			throw new IllegalStateException("Unknown constant: " + k);
		}
	}

	public Type constType(int index) {
		return constantType(prototype.getConstants().get(index));
	}

	public FunctionType nestedPrototypeType(int index) {
		return compilationContext().typeOf(nestedPrototype(index));
	}

	public String nestedPrototypeName(int index) {
		return compilationContext().prototypeClassName(nestedPrototype(index));
//		return PrototypePrinter.pseudoAddr(nestedPrototype(index));
	}

	@Deprecated
	public Prototype nestedPrototype(int index) {
		return prototype.getNestedPrototypes().get(index);
	}

}