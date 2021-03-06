/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.hadoop.hdfs.server.namenode;

import java.io.IOException;
import java.io.InputStream;

/**
 * A generic abstract class to support reading edits log data from 
 * persistent storage.
 * 
 * It should stream bytes from the storage exactly as they were written
 * into the #{@link EditLogOutputStream}.
 * 多了几个以字节方式读入的抽象方法
 */
abstract class EditLogInputStream extends InputStream {
  /**
   * Get this stream name.
   * 输入流的名称
   * @return name of the stream
   */
  abstract String getName();

  /** {@inheritDoc}日志是可用，根据长度是否大于0判断*/
  public abstract int available() throws IOException;

  /** {@inheritDoc} */
  public abstract int read() throws IOException;

  /** {@inheritDoc}字节方式的读方法*/
  public abstract int read(byte[] b, int off, int len) throws IOException;

  /** {@inheritDoc} */
  public abstract void close() throws IOException;

  /**
   * Return the size of the current edits log.
   *返回编辑日志的大小
   */
  abstract long length() throws IOException;
}
