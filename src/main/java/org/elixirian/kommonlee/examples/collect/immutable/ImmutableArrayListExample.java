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
package org.elixirian.kommonlee.examples.collect.immutable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.elixirian.kommonlee.collect.immutable.ImmutableArrayList;
import org.elixirian.kommonlee.collect.immutable.ImmutableList;
import org.elixirian.kommonlee.type.functional.Condition1;
import org.elixirian.kommonlee.type.functional.Function1;

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
 * @version 0.0.1 (2012-11-03)
 */
public class ImmutableArrayListExample
{
  private static void newListWithElements()
  {
    // Traditional
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-14);
    integerList.add(-10);
    integerList.add(-1);
    integerList.add(0);
    integerList.add(1);
    integerList.add(2);
    integerList.add(10);
    integerList.add(35);
    integerList.add(100);
    final List<Integer> unmodifiableIntegerList = Collections.unmodifiableList(integerList);
    System.out.println("## Traditional");
    System.out.println(unmodifiableIntegerList);

    // KommonLee
    final ImmutableList<Integer> immutableIntegerList = ImmutableArrayList.listOf(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    System.out.println("\n## KommonLee");
    System.out.println(immutableIntegerList);
  }

  private static void selectSpecificElementsFromList()
  {
    /* get all positive integer. */

    // Traditional
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-14);
    integerList.add(-10);
    integerList.add(-1);
    integerList.add(0);
    integerList.add(1);
    integerList.add(2);
    integerList.add(10);
    integerList.add(35);
    integerList.add(100);
    final List<Integer> unmodifiableIntegerList = Collections.unmodifiableList(integerList);

    final List<Integer> positiveIntegerList = new ArrayList<Integer>();
    for (final Integer i : unmodifiableIntegerList)
    {
      if (0 < i.intValue())
      {
        positiveIntegerList.add(i);
      }
    }
    final List<Integer> unmodifiablePositiveIntegerList = Collections.unmodifiableList(positiveIntegerList);
    System.out.println("## Traditional");
    System.out.println("unmodifiableIntegerList: \n" + unmodifiableIntegerList);
    System.out.println("positiveIntegerList: \n" + positiveIntegerList);
    System.out.println("unmodifiablePositiveIntegerList: \n" + unmodifiablePositiveIntegerList);

    // KommonLee
    final ImmutableList<Integer> immutableIntegerList = ImmutableArrayList.listOf(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final ImmutableList<Integer> immutablePositiveIntegerList = immutableIntegerList.select(new Condition1<Integer>() {
      @Override
      public boolean isMet(final Integer integer)
      {
        return 0 < integer.intValue();
      }
    });
    System.out.println("\n## KommonLee");
    System.out.println("immutableIntegerList: \n" + immutableIntegerList);
    System.out.println("positive Integers from immutableIntegerList: \n" + immutablePositiveIntegerList);
  }

  private static void mapElementsInList()
  {
    /* get all positive integer. */

    // Traditional
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-14);
    integerList.add(-10);
    integerList.add(-1);
    integerList.add(0);
    integerList.add(1);
    integerList.add(2);
    integerList.add(10);
    integerList.add(35);
    integerList.add(100);
    final List<Integer> unmodifiableIntegerList = Collections.unmodifiableList(integerList);

    final List<String> mappedList = new ArrayList<String>();
    for (final Integer integer : unmodifiableIntegerList)
    {
      mappedList.add("The number is " + integer + ".");
    }
    final List<String> unmodifiableMappedList = Collections.unmodifiableList(mappedList);
    System.out.println("## Traditional");
    System.out.println("unmodifiableIntegerList: \n" + unmodifiableIntegerList);
    System.out.println("mappedList: \n" + mappedList);
    System.out.println("unmodifiableMappedList: \n" + unmodifiableMappedList);

    // KommonLee
    final ImmutableList<Integer> immutableIntegerList = ImmutableArrayList.listOf(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final ImmutableList<String> immutableMappedList = immutableIntegerList.map(new Function1<Integer, String>() {
      @Override
      public String apply(final Integer integer)
      {
        return "The number is " + integer + ".";
      }
    });
    System.out.println("\n## KommonLee");
    System.out.println("immutableIntegerList: \n" + immutableIntegerList);
    System.out.println("mappedList from immutableIntegerList: \n" + immutableMappedList);
  }

  public static void main(final String[] args)
  {
    System.out.println("newListWithElements()");
    newListWithElements();

    System.out.println("\nselectSpecificElementsFromList()");
    selectSpecificElementsFromList();

    System.out.println("\nmapElementsInList()");
    mapElementsInList();
  }

}
