/**
 *
 */
package org.elixirian.kommonlee.examples;

/**
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
public class Person
{
  private String surname;

  private String givenName;

  private String email;

  public Person()
  {
  }

  public Person(final String surname, final String givenName)
  {
    this.surname = surname;
    this.givenName = givenName;
  }

  public Person(final String email)
  {
    this.email = email;
  }

  public Person(final String surname, final String givenName, final String email)
  {
    this.surname = surname;
    this.givenName = givenName;
    this.email = email;
  }

  public String getSurname()
  {
    return surname;
  }

  public String getGivenName()
  {
    return givenName;
  }

  public String getEmail()
  {
    return email;
  }

  public void rename(final String surname, final String givenName)
  {
    this.surname = surname;
    this.givenName = givenName;
  }

  public void changeNameAndEmail(final String surname, final String givenName, final String email)
  {
    this.surname = surname;
    this.givenName = givenName;
    this.email = email;
  }

}
