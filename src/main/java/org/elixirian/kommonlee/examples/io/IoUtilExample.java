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
package org.elixirian.kommonlee.examples.io;

import static org.elixirian.kommonlee.io.IoCommonConstants.*;
import static org.elixirian.kommonlee.io.util.IoUtil.*;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;

import org.elixirian.kommonlee.io.ByteArrayConsumer;

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
 * @version 0.0.1 (2012-10-28)
 */
public final class IoUtilExample
{

  public static void main(final String[] args) throws URISyntaxException
  {
    readFileTraditional();
    readFileKommonLee();

    readInputStreamTraditional();
    readInputStreamKommonLee();
  }

  private static void readFileTraditional() throws URISyntaxException
  {
    System.out.println("\n>> IoUtilExample.readFileTraditional() <<");
    final StringBuilder stringBuilder = new StringBuilder();
    final File file = new File(new URI(IoUtilExample.class.getResource("/test.txt")
        .toString()));
    InputStream inputStream = null;
    final int bufferSize = 131072; // 128Ki

    try
    {
      inputStream = new FileInputStream(file);
      final byte[] buffer = new byte[bufferSize];
      int bytesRead = inputStream.read(buffer);

      while (-1 < bytesRead)
      {
        stringBuilder.append(new String(buffer, 0, bytesRead));
        bytesRead = inputStream.read(buffer);
      }
    }
    catch (final IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (null != inputStream)
      {
        try
        {
          inputStream.close();
        }
        catch (final IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    System.out.println(stringBuilder);
  }

  private static void readFileKommonLee() throws URISyntaxException
  {
    System.out.println("\n>> IoUtilExample.readFileKommonLee() <<");
    final StringBuilder stringBuilder = new StringBuilder();
    final File file = new File(new URI(IoUtilExample.class.getResource("/test.txt")
        .toString()));
    readFile(file, BUFFER_SIZE_128Ki, new ByteArrayConsumer() {
      @Override
      public void consume(final byte[] bytes, final int offset, final int count) throws IOException
      {
        stringBuilder.append(new String(bytes, offset, count));
      }
    });
    System.out.println(stringBuilder);
  }

  private static void readInputStreamTraditional()
  {
    System.out.println("\n>> IoUtilExample.readInputStreamTraditional() <<");
    final StringBuilder stringBuilder = new StringBuilder();
    final InputStream inputStream = IoUtilExample.class.getResourceAsStream("/test.txt");
    final int bufferSize = 131072; // 128Ki
    InputStream bufferedInputStream = null;

    try
    {
      bufferedInputStream = new BufferedInputStream(inputStream, bufferSize);
      final byte[] buffer = new byte[bufferSize];
      int bytesRead = bufferedInputStream.read(buffer);

      while (-1 < bytesRead)
      {
        stringBuilder.append(new String(buffer, 0, bytesRead));
        bytesRead = bufferedInputStream.read(buffer);
      }
    }
    catch (final IOException e)
    {
      e.printStackTrace();
    }
    finally
    {
      if (null != bufferedInputStream)
      {
        try
        {
          bufferedInputStream.close();
        }
        catch (final IOException e)
        {
          e.printStackTrace();
        }
      }
      if (null != inputStream)
      {
        try
        {
          inputStream.close();
        }
        catch (final IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    System.out.println(stringBuilder);
  }

  private static void readInputStreamKommonLee()
  {
    System.out.println("\n>> IoUtilExample.readInputStreamKommonLee() <<");
    final StringBuilder stringBuilder = new StringBuilder();
    final InputStream inputStream = IoUtilExample.class.getResourceAsStream("/test.txt");
    readInputStream(inputStream, BUFFER_SIZE_128Ki, new ByteArrayConsumer() {
      @Override
      public void consume(final byte[] bytes, final int offset, final int count) throws IOException
      {
        stringBuilder.append(new String(bytes, offset, count));
      }
    });
    System.out.println(stringBuilder);
  }

}
