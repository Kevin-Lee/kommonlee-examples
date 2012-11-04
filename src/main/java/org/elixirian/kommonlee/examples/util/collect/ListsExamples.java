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
package org.elixirian.kommonlee.examples.util.collect;

import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.util.ArrayList;
import java.util.List;

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
public class ListsExamples
{
  public static void main(final String[] args)
  {
    createNewArrayList();

    createAndAddJdk();

    createAndAddKommonLee();

    createAndAddJdk();

    createFromAnotherListJdk();

    createAndAddKommonLee();

    createFromAnotherListKommonLee();
  }

  private static void createNewArrayList()
  {
    // JDK
    final List<Integer> integerList1_1 = new ArrayList<Integer>();

    // KommonLee
    final List<Integer> integerList2_1 = newArrayList();
  }

  private static void createAndAddJdk()
  {
    // JDK
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
  }

  private static void createAndAddKommonLee()
  {
    // KommonLee
    final List<Integer> integerList = newArrayList(-14, -10, -1, 0, 1, 2, 10, 35, 100);
  }

  private static void createFromAnotherListJdk()
  {
    // JDK
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

    final List<Integer> anotherIntegerList = new ArrayList<Integer>(integerList);
    System.out.println("integerList: " + integerList);
    System.out.println("anotherIntegerList: " + anotherIntegerList);
  }

  private static void createFromAnotherListKommonLee()
  {
    // KommonLee
    final List<Integer> integerList = newArrayList(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final List<Integer> antherIntegerList = newArrayList(integerList);
  }
}
