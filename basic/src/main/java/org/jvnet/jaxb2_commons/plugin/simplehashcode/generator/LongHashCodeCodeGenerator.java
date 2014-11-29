package org.jvnet.jaxb2_commons.plugin.simplehashcode.generator;

import com.sun.codemodel.JCodeModel;
import com.sun.codemodel.JExpr;
import com.sun.codemodel.JExpression;
import com.sun.codemodel.JType;
import com.sun.codemodel.JVar;

public class LongHashCodeCodeGenerator extends PrimitiveHashCodeCodeGenerator {
	public LongHashCodeCodeGenerator(JCodeModel codeModel) {
		super(codeModel);
	}

	@Override
	public JExpression hashCodeValue(JType type, JVar value) {
		// return (int)(value ^ (value >>> 32));
		return JExpr.cast(getCodeModel().INT,
				value.xor(value.shrz(JExpr.lit(32))));

	}
}