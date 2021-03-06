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

package org.apache.sqoop.mapreduce;

import org.apache.avro.Schema;
import org.apache.hadoop.conf.Configuration;

/**
 * Helper class for setting up an Avro MapReduce job.
 */
public final class AvroJob {
  public static final String MAP_OUTPUT_SCHEMA = "avro.map.output.schema";

  /** The configuration key for a job's output schema. */
  public static final String OUTPUT_SCHEMA = "avro.output.schema";

  private AvroJob() {
  }

  public static void setMapOutputSchema(Configuration job, Schema s) {
    job.set(MAP_OUTPUT_SCHEMA, s.toString());
  }

  /** Return a job's map output key schema. */
  public static Schema getMapOutputSchema(Configuration job) {
    return Schema.parse(job.get(MAP_OUTPUT_SCHEMA, job.get(OUTPUT_SCHEMA)));
  }

  /** Set a job's output key schema. */
  public static void setOutputSchema(Configuration job, Schema s) {
    job.set(OUTPUT_SCHEMA, s.toString());
  }

  /** Return a job's output key schema. */
  public static Schema getOutputSchema(Configuration job) {
    return Schema.parse(job.get(OUTPUT_SCHEMA));
  }
}
