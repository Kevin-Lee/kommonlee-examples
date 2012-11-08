/**
 * This project is licensed under the Apache License, Version 2.0
 * if the following condition is met:
 * (otherwise it cannot be used by anyone but the author, Kevin, only)
 *
 * The original KommonLee project is owned by Lee, Seong Hyun (Kevin).
 *
 * -What does it mean to you?
 * Nothing, unless you want to take the ownership of
 * "the original project" (not yours or forked & modified one).
 * You are free to use it for both non-commercial and commercial projects
 * and free to modify it as the Apache License allows.
 *
 * -So why is this condition necessary?
 * It is only to protect the original project (See the case of Java).
 *
 *
 * Copyright 2009 Lee, Seong Hyun (Kevin)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.elixirian.kommonlee.examples.asm.analysis;

import static org.elixirian.kommonlee.util.Objects.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.Map.Entry;

import org.elixirian.kommonlee.asm.analysis.AsmMethodAndConstructorAnalyser;
import org.elixirian.kommonlee.asm.analysis.ConstructorAnalyser;
import org.elixirian.kommonlee.asm.analysis.MethodAnalyser;
import org.elixirian.kommonlee.asm.analysis.MethodAndConstructorAnalyser;

/**
 * <pre>
 *     ___  _____                                              _____
 *    /   \/    / ______ __________________  ______ __ ______ /    /   ______  ______
 *   /        / _/ __  // /  /   / /  /   /_/ __  // //     //    /   /  ___ \/  ___ \
 *  /        \ /  /_/ _/  _  _  /  _  _  //  /_/ _/   __   //    /___/  _____/  _____/
 * /____/\____\/_____//__//_//_/__//_//_/ /_____//___/ /__//________/\_____/ \_____/
 * </pre>
 *
 * <pre>
 *     ___  _____                                _____
 *    /   \/    /_________  ___ ____ __ ______  /    /   ______  ______
 *   /        / /  ___ \  \/  //___// //     / /    /   /  ___ \/  ___ \
 *  /        \ /  _____/\    //   //   __   / /    /___/  _____/  _____/
 * /____/\____\\_____/   \__//___//___/ /__/ /________/\_____/ \_____/
 * </pre>
 *
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2012-11-08)
 */
public class AsmMethodAndConstructorAnalyserExample
{
  private static void getAllMethodsWithParameterNames()
  {
    System.out.println("getAllMethodsWithParameterNames");
    // JDK: NO WAY!

    // KommonLee
    final MethodAnalyser methodAnalyser = new AsmMethodAndConstructorAnalyser();
    final Map<Method, String[]> methodToParamNames = methodAnalyser.findMethodsWithParameterNames(Person.class);

    for (final Entry<Method, String[]> entry : methodToParamNames.entrySet())
    {
      System.out.println("method: " + entry.getKey());
      System.out.println("paramsNames: " + toStringOf(entry.getValue()));
      System.out.println();
    }
  }

  private static void getAllConstructorsWithParameterNames()
  {
    System.out.println("getAllConstructorsWithParameterNames");
    // JDK: NO WAY!

    // KommonLee
    final ConstructorAnalyser constructorAnalyser = new AsmMethodAndConstructorAnalyser();
    final Map<Constructor<Person>, String[]> constructorToParamNames =
      constructorAnalyser.findConstructorsWithParameterNames(Person.class);

    for (final Entry<Constructor<Person>, String[]> entry : constructorToParamNames.entrySet())
    {
      System.out.println("constructor: " + entry.getKey());
      System.out.println("paramsNames: " + toStringOf(entry.getValue()));
      System.out.println();
    }
  }

  private static void getAllConstructorsAndMethodsWithParameterNames()
  {
    System.out.println("getAllConstructorsAndMethodsWithParameterNames");
    // JDK: NO WAY!

    // KommonLee
    final MethodAndConstructorAnalyser methodAndConstructorAnalyser = new AsmMethodAndConstructorAnalyser();
    final Map<Member, String[]> memberToParamNames =
      methodAndConstructorAnalyser.findMethodsAndConstructorsWithParameterNames(Person.class);

    for (final Entry<Member, String[]> entry : memberToParamNames.entrySet())
    {
      final Member member = entry.getKey();
      System.out.println("class: " + member.getClass());
      System.out.println("member: " + member);
      System.out.println("paramsNames: " + toStringOf(entry.getValue()));
      System.out.println();
    }
  }

  public static void main(final String[] args)
  {
    getAllMethodsWithParameterNames();
    System.out.println("========================================================================");
    getAllConstructorsWithParameterNames();
    System.out.println("========================================================================");
    getAllConstructorsAndMethodsWithParameterNames();
  }
}
