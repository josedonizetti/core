/*
 * Copyright 2012 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Eclipse Public License version 1.0, available at
 * http://www.eclipse.org/legal/epl-v10.html
 */

package org.jboss.forge.parser.java;

import org.jboss.forge.parser.Origin;

import java.util.List;

/**
 * @author <a href="mailto:lincolnbaxter@gmail.com">Lincoln Baxter, III</a>
 * 
 */
@SuppressWarnings("rawtypes")
public interface JavaSource<T extends JavaSource<T>> extends
         Packaged<T>,
         Importer<T>,
         Named<T>,
         VisibilityScoped<T>,
         AnnotationTarget<T, T>,
         MemberHolder<T, Member>,
         Origin<T>
{
   /**
    * Set the qualified-name of this {@link T} instance, where the qualified-name contains both the Java package and
    * simple class name of the type represented by this {@link T} instance.
    * <p/>
    * <strong>For example</strong>, calling: {@link #getQualifiedName()} is equivalent to calling "{@link #getPackage()}
    * + "." + {@link #getName()}", which in turn is equivalent to calling: {@link Class#getName()}
    */
   public String getQualifiedName();

   /**
    * Get a list of all {@link SyntaxError}s detected in the current {@link T}. Note that when errors are present, the
    * class may still be modified, but changes may not be completely accurate.
    */
   public List<SyntaxError> getSyntaxErrors();

   /**
    * Return whether or not this {@link T} currently has any {@link SyntaxError} s.
    */
   public boolean hasSyntaxErrors();

   /**
    * Return true if this {@link JavaSource} represents a {@link JavaClass}
    */
   public boolean isClass();

   /**
    * Return true if this {@link JavaSource} represents a {@link JavaEnum}
    */
   public boolean isEnum();

   /**
    * Return true if this {@link JavaSource} represents a {@link JavaClass} interface.
    */
   public boolean isInterface();

   /**
    * Return true if this {@link JavaSource} represents a {@link JavaAnnotation}
    */
   public boolean isAnnotation();

   /**
    * Return the {@link SourceType} of this {@link JavaSource} instance.
    */
   public SourceType getSourceType();
}
