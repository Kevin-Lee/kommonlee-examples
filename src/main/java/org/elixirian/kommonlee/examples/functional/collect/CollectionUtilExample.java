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
package org.elixirian.kommonlee.examples.functional.collect;

import static org.elixirian.kommonlee.functional.collect.CollectionUtil.*;
import static org.elixirian.kommonlee.util.collect.Lists.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.elixirian.kommonlee.examples.Person;
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
 * @version 0.0.1 (2012-11-16)
 */
public class CollectionUtilExample
{
  private static void selectAllPositiveIntegerJdk()
  {
    System.out.println("CollectionUtilExample.selectAllPositiveIntegerJdk()");
    final List<Integer> integerList = new ArrayList<Integer>();
    integerList.add(-100);
    integerList.add(-55);
    integerList.add(-32);
    integerList.add(-21);
    integerList.add(-17);
    integerList.add(-10);
    integerList.add(-3);
    integerList.add(0);
    integerList.add(1);
    integerList.add(15);
    integerList.add(33);
    integerList.add(77);
    integerList.add(999);
    integerList.add(1234);

    final List<Integer> anotherIntegerList = new ArrayList<Integer>();
    anotherIntegerList.add(-555);
    anotherIntegerList.add(-46);
    anotherIntegerList.add(-23);
    anotherIntegerList.add(-11);
    anotherIntegerList.add(-8);
    anotherIntegerList.add(-5);
    anotherIntegerList.add(-1);
    anotherIntegerList.add(2);
    anotherIntegerList.add(11);
    anotherIntegerList.add(14);
    anotherIntegerList.add(24);
    anotherIntegerList.add(56);
    anotherIntegerList.add(100);
    anotherIntegerList.add(9999);

    final List<Integer> positiveIntegerList = new ArrayList<Integer>();
    for (final Integer integer : integerList)
    {
      if (0 < integer.intValue())
      {
        positiveIntegerList.add(integer);
      }
    }
    System.out.println("positiveIntegerList: " + positiveIntegerList);

    final List<Integer> anotherPositiveIntegerList = new ArrayList<Integer>();
    for (final Integer integer : anotherIntegerList)
    {
      if (0 < integer.intValue())
      {
        anotherPositiveIntegerList.add(integer);
      }
    }
    System.out.println("anotherPositiveIntegerList: " + anotherPositiveIntegerList);
  }

  private static void selectAllPositiveIntegerKommonLee()
  {
    System.out.println("CollectionUtilExample.selectAllPositiveIntegerKommonLee()");

    final List<Integer> integerList = newArrayList(-100, -55, -32, -21, -17, -10, -3, 0, 1, 15, 33, 77, 999, 1234);

    final List<Integer> anotherIntegerList =
      newArrayList(-555, -46, -23, -11, -8, -5, -1, 2, 11, 14, 24, 56, 100, 9999);

    final Condition1<Integer> positiveInteger = new Condition1<Integer>() {
      @Override
      public boolean isMet(final Integer integer)
      {
        return 0 < integer.intValue();
      }
    };

    final List<Integer> positiveIntegerList = selector().fromIterable()
        .toArrayList()
        .select(positiveInteger, integerList);
    System.out.println("positiveIntegerList: " + positiveIntegerList);

    final List<Integer> anotherPositiveIntegerList = selector().fromIterable()
        .toArrayList()
        .select(positiveInteger, anotherIntegerList);
    System.out.println("anotherPositiveIntegerList: " + anotherPositiveIntegerList);
  }

  private static void getAllEmailAddressesJdk()
  {
    System.out.println("CollectionUtilExample.getAllEmailAddressesJdk()");
    final List<Person> personList = new ArrayList<Person>();
    personList.add(new Person("Lee", "Kevin", "test@test.email.com"));
    personList.add(new Person("Kent", "Clark", "clark.kent@krypton.com"));
    personList.add(new Person("Wayne", "Bruce", "bruce.wayne@gotham.com"));
    personList.add(new Person("Lee", "Tom", "test@another.test-email.com"));
    personList.add(new Person("Odinson", "Thor", "thor.odinson@asgard.com"));
    personList.add(new Person("Stark", "Tony", "tony.stark@stark.com"));

    final List<Person> personList2 = new ArrayList<Person>();
    personList2.add(new Person("Rogers", "Steve", "steve.rogers@captain.america.com"));
    personList2.add(new Person("Jordan", "Hal", "hal.jordan@earth.com"));
    personList2.add(new Person("Banner", "Bruce", "bruce.banner@hulk.com"));

    final List<String> emailAddressList = new ArrayList<String>();
    for (final Person person : personList)
    {
      emailAddressList.add(person.getEmail());
    }
    System.out.println("emailAddressList: " + emailAddressList);

    final Set<String> emailAddressSet = new HashSet<String>();
    for (final Person person : personList2)
    {
      emailAddressSet.add(person.getEmail());
    }
    System.out.println("emailAddressSet: " + emailAddressSet);
  }

  private static void getAllEmailAddressesKommonLee()
  {
    System.out.println("CollectionUtilExample.getAllEmailAddressesKommonLee()");

    final List<Person> personList =
      newArrayList(new Person("Lee", "Kevin", "test@test.email.com"), new Person("Kent", "Clark",
          "clark.kent@krypton.com"), new Person("Wayne", "Bruce", "bruce.wayne@gotham.com"), new Person("Lee", "Tom",
          "test@another.test-email.com"), new Person("Odinson", "Thor", "thor.odinson@asgard.com"), new Person("Stark",
          "Tony", "tony.stark@stark.com"));

    final List<Person> personList2 =
      newArrayList(new Person("Rogers", "Steve", "steve.rogers@captain.america.com"), new Person("Jordan", "Hal",
          "hal.jordan@earth.com"), new Person("Banner", "Bruce", "bruce.banner@hulk.com"));

    final Function1<Person, String> personToEmailMapper = new Function1<Person, String>() {
      @Override
      public String apply(final Person person)
      {
        return person.getEmail();
      }
    };

    final List<String> emailAddressList = mapper().fromIterable()
        .toArrayList()
        .map(personToEmailMapper, personList);
    System.out.println("emailAddressList: " + emailAddressList);

    final Set<String> emailAddressSet = mapper().fromIterable()
        .toHashSet()
        .map(personToEmailMapper, personList2);
    System.out.println("emailAddressSet: " + emailAddressSet);
  }

  public static void main(final String[] args)
  {
    selectAllPositiveIntegerJdk();
    System.out.println();
    selectAllPositiveIntegerKommonLee();
    System.out.println("\n");
    getAllEmailAddressesJdk();
    System.out.println();
    getAllEmailAddressesKommonLee();
  }
}
