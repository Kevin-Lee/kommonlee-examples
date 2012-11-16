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
package org.elixirian.kommonlee.examples.util.number;

import static org.elixirian.kommonlee.util.collect.Lists.*;
import static org.elixirian.kommonlee.util.number.BigDecimalTotal.*;

import java.math.BigDecimal;
import java.util.List;

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
 * @version 0.0.1 (2012-11-13)
 */
public class BigDecimalTotalExample
{
  private static void totalUsingMapper()
  {
    final List<Product> productList =
      newArrayList(new Product(1L, "Product A", new BigDecimal("10.50")), new Product(1L, "Product B", new BigDecimal(
          "50.00")), new Product(1L, "Product C", new BigDecimal("123.99")));

    // JDK
    BigDecimal totalPrice = BigDecimal.ZERO;
    for (final Product product : productList)
    {
      totalPrice = totalPrice.add(product.getPrice());
    }
    System.out.println("total price: $" + totalPrice);

    // KommonLee
    final BigDecimal totalPrice2 = total(productList, new Function1<Product, BigDecimal>() {
      @Override
      public BigDecimal apply(final Product product)
      {
        return product.getPrice();
      }
    });
    System.out.println("total price: $" + totalPrice2);
  }

  private static final Function1<Product, BigDecimal> TO_BIG_DECIMAL_MAPPER = new Function1<Product, BigDecimal>() {
    @Override
    public BigDecimal apply(final Product product)
    {
      return product.getPrice();
    }
  };

  private static void totalUsingMapperReused()
  {
    final List<Product> productList =
      newArrayList(new Product(1L, "Product A", new BigDecimal("10.50")), new Product(1L, "Product B", new BigDecimal(
          "50.00")), new Product(1L, "Product C", new BigDecimal("123.99")));

    final List<Product> anotherProductList =
      newArrayList(new Product(1L, "Product A", new BigDecimal("999.99")), new Product(1L, "Product B", new BigDecimal(
          "1.50")), new Product(1L, "Product C", new BigDecimal("19.20")));

    // JDK
    BigDecimal totalPrice1_1 = BigDecimal.ZERO;
    for (final Product product : productList)
    {
      totalPrice1_1 = totalPrice1_1.add(product.getPrice());
    }
    System.out.println("total price: $" + totalPrice1_1);

    BigDecimal totalPrice1_2 = BigDecimal.ZERO;
    for (final Product product : anotherProductList)
    {
      totalPrice1_2 = totalPrice1_2.add(product.getPrice());
    }
    System.out.println("another total price: $" + totalPrice1_2);

    System.out.println();

    // KommonLee
    final BigDecimal totalPrice2_1 = total(productList, TO_BIG_DECIMAL_MAPPER);
    System.out.println("total price: $" + totalPrice2_1);

    final BigDecimal totalPrice2_2 = total(anotherProductList, TO_BIG_DECIMAL_MAPPER);
    System.out.println("another total price: $" + totalPrice2_2);
  }

  public static void main(final String[] args)
  {
    totalUsingMapper();
    System.out.println("=====================================");
    totalUsingMapperReused();
  }
}
