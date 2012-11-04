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

import static org.elixirian.kommonlee.util.collect.Sets.*;

import java.util.HashSet;
import java.util.Set;

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
public class SetsExamples
{
  public static void main(final String[] args)
  {
    createJdk();

    createKommonLee();

    createAndAddJdk();

    createAndAddKommonLee();

    createHashSetFromAnotherSetJdk();

    createHashSetFromAnotherSetKommonLee();
  }

  private static void createJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
  }

  private static void createKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet = newHashSet();
  }

  private static void createAndAddJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
    integerSet.add(-14);
    integerSet.add(-10);
    integerSet.add(-1);
    integerSet.add(0);
    integerSet.add(1);
    integerSet.add(2);
    integerSet.add(10);
    integerSet.add(35);
    integerSet.add(100);
  }

  private static void createAndAddKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet2_2 = newHashSet(-14, -10, -1, 0, 1, 2, 10, 35, 100);
  }

  private static void createHashSetFromAnotherSetJdk()
  {
    // JDK
    final Set<Integer> integerSet = new HashSet<Integer>();
    integerSet.add(-14);
    integerSet.add(-10);
    integerSet.add(-1);
    integerSet.add(0);
    integerSet.add(1);
    integerSet.add(2);
    integerSet.add(10);
    integerSet.add(35);
    integerSet.add(100);
    final Set<Integer> anotherintegerSet = new HashSet<Integer>(integerSet);
  }

  private static void createHashSetFromAnotherSetKommonLee()
  {
    // KommonLee
    final Set<Integer> integerSet = newHashSet(-14, -10, -1, 0, 1, 2, 10, 35, 100);
    final Set<Integer> antherintegerSet = newHashSet(integerSet);
  }

}
