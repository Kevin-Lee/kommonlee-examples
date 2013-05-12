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
import static org.elixirian.kommonlee.nio.util.NioUtil.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.util.ArrayList;
import java.util.List;

import org.elixirian.kommonlee.io.ByteArrayConsumingContainer;
import org.elixirian.kommonlee.io.DataConsumers;

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
 * @version 0.0.1 (2013-05-12)
 */
public final class NioUtilExample
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
    System.out.println("\n>> NioUtilExample.readFileTraditional() <<");
    final File file = new File(new URI(NioUtilExample.class.getResource("/test.txt")
        .toString()));

    FileInputStream fileInputStream = null;
    FileChannel fileChannel = null;

    final int bufferSize = 131072; // 128Ki
    final List<Byte> byteList = new ArrayList<Byte>();

    try
    {
      fileInputStream = new FileInputStream(file);
      fileChannel = fileInputStream.getChannel();

      final byte[] buffer = new byte[bufferSize];
      final ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
      int bytesRead = fileChannel.read(byteBuffer);
      while (-1 != bytesRead)
      {
        for (int i = 0; i < bytesRead; i++)
        {
          byteList.add(buffer[i]);
        }
        byteBuffer.clear();
        bytesRead = fileChannel.read(byteBuffer);
      }
    }
    catch (final FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    catch (final IOException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      if (null != fileChannel)
      {
        try
        {
          fileChannel.close();
        }
        catch (final IOException e)
        {
          e.printStackTrace();
        }
      }
      if (null != fileInputStream)
      {
        try
        {
          fileInputStream.close();
        }
        catch (final IOException e)
        {
          e.printStackTrace();
        }
      }
    }
    final int length = byteList.size();
    final byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++)
    {
      bytes[i] = byteList.get(i);
    }
    System.out.println(new String(bytes));
  }

  private static void readFileKommonLee() throws URISyntaxException
  {
    System.out.println("\n>> NioUtilExample.readFileKommonLee() <<");
    final ByteArrayConsumingContainer byteArrayConsumingContainer = DataConsumers.newByteArrayConsumingContainer();
    final File file = new File(new URI(NioUtilExample.class.getResource("/test.txt")
        .toString()));
    readFile(file, BUFFER_SIZE_128Ki, byteArrayConsumingContainer);
    System.out.println(byteArrayConsumingContainer.toString());
  }

  private static void readInputStreamTraditional()
  {
    System.out.println("\n>> NioUtilExample.readInputStreamTraditional() <<");
    InputStream inputStream = null;
    ReadableByteChannel readableByteChannel = null;

    final int bufferSize = 131072; // 128Ki
    final List<Byte> byteList = new ArrayList<Byte>();

    try
    {
      inputStream = NioUtilExample.class.getResourceAsStream("/test.txt");
      readableByteChannel = Channels.newChannel(inputStream);

      final byte[] buffer = new byte[bufferSize];
      final ByteBuffer byteBuffer = ByteBuffer.wrap(buffer);
      int bytesRead = readableByteChannel.read(byteBuffer);
      while (-1 != bytesRead)
      {
        for (int i = 0; i < bytesRead; i++)
        {
          byteList.add(buffer[i]);
        }
        byteBuffer.clear();
        bytesRead = readableByteChannel.read(byteBuffer);
      }
    }
    catch (final FileNotFoundException e)
    {
      throw new RuntimeException(e);
    }
    catch (final IOException e)
    {
      throw new RuntimeException(e);
    }
    finally
    {
      if (null != readableByteChannel)
      {
        try
        {
          readableByteChannel.close();
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
    final int length = byteList.size();
    final byte[] bytes = new byte[length];
    for (int i = 0; i < length; i++)
    {
      bytes[i] = byteList.get(i);
    }
    System.out.println(new String(bytes));
  }

  private static void readInputStreamKommonLee()
  {
    System.out.println("\n>> NioUtilExample.readInputStreamKommonLee() <<");
    final InputStream inputStream = NioUtilExample.class.getResourceAsStream("/test.txt");
    final ByteArrayConsumingContainer byteArrayConsumingContainer = DataConsumers.newByteArrayConsumingContainer();
    readInputStream(inputStream, BUFFER_SIZE_128Ki, byteArrayConsumingContainer);
    System.out.println(byteArrayConsumingContainer.toString());
  }

}
