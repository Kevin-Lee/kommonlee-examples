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

import java.math.BigDecimal;
import java.util.List;

import org.elixirian.kommonlee.type.functional.Function1;

import static org.elixirian.kommonlee.util.number.BigDecimalTotal.*;

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
 * @authoFr Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2012-11-13)
 */
public class Order
{
  private Long id;

  private List<OrderedProduct> orderedProducts;

  private int quantity;

  public Order(final Long id, final List<OrderedProduct> orderedProducts, final int quantity)
  {
    this.id = id;
    this.orderedProducts = orderedProducts;
    this.quantity = quantity;
  }

  public Long getId()
  {
    return id;
  }

  public void setId(final Long id)
  {
    this.id = id;
  }

  public List<OrderedProduct> getOrderedProducts()
  {
    return orderedProducts;
  }

  public void setOrderedProducts(final List<OrderedProduct> orderedProducts)
  {
    this.orderedProducts = orderedProducts;
  }

  public int getQuantity()
  {
    return quantity;
  }

  public void setQuantity(final int quantity)
  {
    this.quantity = quantity;
  }

  public BigDecimal getTotalPrice()
  {
    // BigDecimal total = BigDecimal.ZERO;
    // for (OrderedProduct orderedProduct : orderedProducts)
    // {
    // total = total.add(orderedProduct.getTotalPrice());
    // }
    // return total;

    return total(orderedProducts, new Function1<OrderedProduct, BigDecimal>() {
      @Override
      public BigDecimal apply(final OrderedProduct orderedProduct)
      {
        return orderedProduct.getTotalPrice();
      }
    });
  }
}
