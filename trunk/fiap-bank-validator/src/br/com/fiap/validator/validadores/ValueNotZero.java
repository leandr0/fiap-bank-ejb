/**
 * 
 */
package br.com.fiap.validator.validadores;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.hibernate.validator.ValidatorClass;

/**
 * @author leandro.goncalves
 *
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ValidatorClass(NumberNotZero.class)
public @interface ValueNotZero {

	public String message();	
}

