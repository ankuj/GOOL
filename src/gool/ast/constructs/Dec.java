package gool.ast.constructs;

import gool.ast.type.IType;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;


/**
 * This interface accounts for all declarations in abstract GOOL.
 * Because declarations are usually considered as statements in OO languages, 
 * so we leave it to extend Statement.
 */
public abstract class Dec extends Statement {
	private static final List<Modifier> ACCESS_MODIFIERS = Arrays.asList(Modifier.PUBLIC, Modifier.PRIVATE, Modifier.PROTECTED);
	/**
	 * The list of modifiers.
	 */
	private Collection<Modifier> modifiers = new HashSet<Modifier>();
	private IType type;
	private String name;
	
	public Dec(IType type, String name) {
		this.type = type;
		this.name = name;
	}
	
	public IType getType() {
		return type;
	}
	
	public void setType(IType type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Collection<Modifier> getModifiers() {
		return modifiers;
	}
	
	public void setModifiers(Collection<Modifier> modifiers) {
		this.modifiers = modifiers;
	}
	
	public void addModifier(Modifier modifier) {
		this.modifiers.add(modifier);
	}
	
	public void addModifiers(Collection<Modifier> modifiers) {
		this.modifiers.addAll(modifiers);
	}
	
	public Modifier getAccessModifier() {
		// make private if it does not have any of the allowed modifiers.
		Modifier modifier = Modifier.PRIVATE;
		
		for (Modifier m : modifiers) {
			if (ACCESS_MODIFIERS.contains(m)) {
				modifier = m;
				break;
			}
		}
		
		return modifier;
	}
}
