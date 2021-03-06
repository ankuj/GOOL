package gool.ast.type;

import gool.generator.GoolGeneratorController;

/**
 * This is the basic type Void of the intermediate language.
 */
public final class TypeVoid extends PrimitiveType {

	public static final TypeVoid INSTANCE = new TypeVoid();
	
	private TypeVoid() {
	}
	@Override
	public String callGetCode() {
		return getName();
	}
	
	@Override
	public String getName() {
		return GoolGeneratorController.generator().getCode(this);
	}
}
