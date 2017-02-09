/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.apache.samza.operators.functions;

import org.apache.samza.annotation.InterfaceStability;
import org.apache.samza.config.Config;
import org.apache.samza.task.TaskContext;

import java.util.Collection;


/**
 * A function that transforms an input message into a collection of 0 or more messages,
 * possibly of a different type.
 * @param <M>  type of the input message
 * @param <OM>  type of the transformed messages
 */
@InterfaceStability.Unstable
public interface FlatMapFunction<M, OM>  extends InitFunction {

  /**
   * Transforms the provided message into a collection of 0 or more messages.
   * @param message  the input message to be transformed
   * @return  a collection of 0 or more transformed messages
   */
  Collection<OM> apply(M message);

  /**
   * Init method to initialize the context for this {@link FlatMapFunction}. The default implementation is NO-OP.
   *
   * @param config  the {@link Config} object for this task
   * @param context  the {@link TaskContext} object for this task
   */
  default void init(Config config, TaskContext context) { };
}
